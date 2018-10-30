package com.joonson.assignment1;

import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		/*
		 * Implementation Karatsuba integer multiplication algorithm.
		 *
		 * */
		//input values
		String numStr1 = "3141592653589793238462643383279502884197169399375105820974944592";
		String numStr2 = "2718281828459045235360287471352662497757247093699959574966967627";
		
		//print result
		System.out.println(KaratsubaMultiplication.multiply(numStr1, numStr2));
		
		//check the result comparing with "BigInteger" library
		BigInteger biA = new BigInteger(numStr1);
		BigInteger biB = new BigInteger(numStr2);
		
		//print result of the check
		System.out.println(KaratsubaMultiplication.multiply(numStr1, numStr2).equals(
				biA.multiply(biB).toString())?"correct":"wrong");
	}

}
