package com.joonson.assignment2;

public class MyMergeSort {
	private int[] inputArr;
	private long numberOfInv;
	private int length;
	
	public MyMergeSort(int[] inputArr) {
		this.inputArr = inputArr;
		this.numberOfInv = 0;
		this.length = inputArr.length;
	}
	public int[] getInputArr() {
		return inputArr;
	}
	public void setInputArr(int[] inputArr) {
		this.inputArr = inputArr;
	}
	public long getNumberOfInv() {
		return numberOfInv;
	}
	public void setNumberOfInv(long numberOfInv) {
		this.numberOfInv = numberOfInv;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	public void mergeSort() {
		execMergeSort(this);
	}
	
	private MyMergeSort execMergeSort(MyMergeSort input) {
		if(input.length==1) {
			return input;
		}
		int[] inputArr = input.getInputArr();
		
		int[] leftArr = new int[input.getInputArr().length/2];
		int[] rightArr = new int[input.getInputArr().length - (input.getInputArr().length/2)];
		
		for(int i=0; i<input.getInputArr().length/2; i++) { 
			leftArr[i] = input.getInputArr()[i];
			rightArr[i] = input.getInputArr()[i+(input.getInputArr().length/2)];
		}
		if(input.getInputArr().length%2 != 0) rightArr[rightArr.length-1] = inputArr[inputArr.length-1];
		
		MyMergeSort left = new MyMergeSort(leftArr);
		MyMergeSort right = new MyMergeSort(rightArr);
		
		left = execMergeSort(left);
		right = execMergeSort(right);
				
		long numLeftInv = left.getNumberOfInv();
		long numRightInv = right.getNumberOfInv();
		long numSplitInv = 0;
		leftArr = left.getInputArr(); //sorted
		rightArr = right.getInputArr(); //sorted
		

		int j =0, k=0;
		boolean leftDone = false, rightDone = false;
		for(int i=0; i<input.length; i++) {
			if(rightDone || (j<leftArr.length && leftArr[j] < rightArr[k])) {
				inputArr[i] = leftArr[j];
				j++;		
				if(j>=leftArr.length) leftDone=true;
			}else if(leftDone || (k<rightArr.length && leftArr[j] > rightArr[k])){
				inputArr[i] = rightArr[k];
				k++;
				numSplitInv += leftArr.length - j;
				if(k>=rightArr.length) rightDone=true;
			}			
		}

		input.setNumberOfInv(numLeftInv+numRightInv+numSplitInv);
		return input;
	}
}
