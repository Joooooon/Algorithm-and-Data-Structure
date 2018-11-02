package com.joonson.assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		int[] input = new int[10000];
		try {
			File file = new File("src/file/quickSort.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));						
			String st;
			int cnt = 0;
			while((st = br.readLine()) != null ) 
				input[cnt++] = Integer.parseInt(st);	
		}catch(FileNotFoundException fe) {}
		catch(IOException ie) {}
					

		//MyQuickSort myQuickSort = new MyQuickSort(input, MyQuickSort.FIRST_EL_PIVOT); //162085
		//MyQuickSort myQuickSort = new MyQuickSort(input, MyQuickSort.LAST_EL_PIVOT); //164123
		MyQuickSort myQuickSort = new MyQuickSort(input, MyQuickSort.THREE_OF_MEDIAN); //151032
		myQuickSort.quickSort();
		int diff = 1;
		int prev = 0;
		for(int t: myQuickSort.getInputArr()) {			
			if(prev !=0) {				
				if(diff != t-prev) System.out.println("Wrong! :"+ t +"was founded while expecting "+ (prev+1));
			}
			prev = t;
		}
		
		System.out.println(myQuickSort.getCompCnt());
	}

}
