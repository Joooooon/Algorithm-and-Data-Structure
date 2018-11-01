package com.joonson.assignment2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
		final int SIZE = 100000;
		int[] inputArr = new int[SIZE];
		try {
			File file = new File("src/file/integerArray.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));			
			String st;			
			int cnt = 0;			
			while((st = br.readLine()) != null ) 
				inputArr[cnt++] = Integer.parseInt(st);
			br.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}
		
		
		MyMergeSort mergeSort = new MyMergeSort(inputArr);
		mergeSort.mergeSort();
		long numInv = mergeSort.getNumberOfInv();
		
		System.out.println(">>>>"+numInv);
		// first try : 2430156032
		// 2nd try : 2407905288
		
	}
	
}
