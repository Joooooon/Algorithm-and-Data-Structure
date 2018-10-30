package com.joonson.assignment1;

public class KaratsubaMultiplication {
	
	public KaratsubaMultiplication() {}
	
	public static String multiply(String num1, String num2) {
		/* n = length of input
		 * 
		 * num1 = 10^(n/2) * A + B
		 * num2 = 10^(n/2) * C + D
		 * 
		 * num1 * num2 = 10^n*(AC) + 10^(n/2)*(AD+BC) + BD
		 * 
		 *   AD+BC = (A+B)(C+D) - AC - BD
		 * 
		 * */
		String result="";
		
		//Make the lengths of two input same and even number
		boolean isEqual = false;
		while(!isEqual) {
			if(num1.length()==num2.length()) isEqual = true;
			else if(num1.length() > num2.length()) num2 = "0"+num2;
			else num1 = "0"+num1;
		}
		if(num1.length()%2!=0) {
			num1="0"+num1;
			num2="0"+num2;			
		}
		
		int inputLen=num1.length();
		//when the inputs are shorter or equal to 2
		if(inputLen <= 2) {
			int a = Integer.valueOf(num1);
			int b = Integer.valueOf(num2);
			return String.valueOf(a*b);
		}
		//Split inputs to A, B, C, D
		// A : First half integers of num1
		// B : rest of integers of num1
		// C : First half integers of num2
		// D : rest of integers of num2
		String A = num1.substring(0, inputLen/2);
		String B = num1.substring(inputLen/2);
		String C = num2.substring(0, inputLen/2);
		String D = num2.substring(inputLen/2);
		
		//get AC
		String AC = multiply(A,C);		
		//get BD
		String BD = multiply(B,D);
		//get AD+BC = (A+B)(C+D) - AC - BD
		String ADBC = subtract(subtract(multiply(add(A,B), add(C,D)), AC),BD);
		//get result
		//AC * 10^n
		for(int i=0; i<inputLen; i++) AC=AC+"0";
		//ADBC * 10^(n/2)
		for(int i=0; i<(inputLen/2); i++) ADBC=ADBC+"0";
		//10^n*(AC) + 10^(n/2)*(AD+BC) + BD
		result = add(add(AC,ADBC),BD);
		
		//remove 0 paddings
		for(int idx=0; idx<result.length(); idx++) {
			if(result.charAt(idx)!='0') {
				result = result.substring(idx);
				break;
			}
		}		
		return result;
	}
	
	private static String add(String num1, String num2) {
		String result="";
		String longer=num1;
		String shorter=num2;		
		
		int gap = num1.length()-num2.length();
		if(gap<0) {
			gap = -gap;
			longer=num2;
			shorter=num1;			
		}
		for(int i=0; i<gap; i++) 
			shorter="0"+shorter;
		
		int over = 0;
		for(int i=longer.length(); i>0; i--) {			
			int numA = Integer.parseInt(longer.substring(i-1, i));
			int numB = Integer.parseInt(shorter.substring(i-1, i));
			int tempSum = numA+numB+over;
						
			if(tempSum>=10) {
				over = 1;				
				tempSum = tempSum-10;				
			}else 
				over = 0;
			result = String.valueOf(tempSum)+result;
		}
		if(over==1) result="1"+result;
				
		return result;		
	}
	
	private static String subtract(String num1, String num2) {
		String result="";
		// num1 must be bigger than num2
		int gap = num1.length() - num2.length();
		for(int i=0; i<gap; i++) {
			num2 = "0"+num2;
		}		
		int over=0;
		for(int i=num1.length(); i>0; i--) {			
			int numA = Integer.parseInt(num1.substring(i-1, i))-over;
			int numB = Integer.parseInt(num2.substring(i-1, i));
			if(numA<numB) {
				over = 1;
				numA += 10;
			}else {
				over = 0;				
			}
			result = String.valueOf(numA-numB)+result;	
		}
		int idx=0;
		for(; idx<result.length(); idx++) {
			if(result.charAt(idx)!='0') break;
		}
		result = result.substring(idx);
		return result;
	}
}
