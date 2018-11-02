package com.joonson.assignment3;

public class MyQuickSort {
	public static final int FIRST_EL_PIVOT = 1;
	public static final int LAST_EL_PIVOT = 2;
	public static final int THREE_OF_MEDIAN = 3;

	private int[] inputArr;
	private int pivot_rule;
	private int compCnt = 0;
	
	public MyQuickSort(int[] inputArr, int pivot_rule) {
		this.inputArr = inputArr;
		this.pivot_rule = pivot_rule;
	}
	
	public void quickSort() {
		this.compCnt = 0;
		execQuickSort(this.inputArr, 0, this.inputArr.length-1);
	}
	
	private void execQuickSort(int[] input, int leftIndex, int rightIndex) {
		if(leftIndex >= rightIndex) return;
		
		int pivoit = getPivotIndex(input, leftIndex, rightIndex);
		//swap input[l] - input[p]
		int temp = input[leftIndex];
		input[leftIndex] = input[pivoit];
		input[pivoit] = temp;
		
		pivoit = sortPartition(input, leftIndex, rightIndex); // after partitioning it, get new pivot index
		execQuickSort(input, leftIndex, pivoit-1);
		execQuickSort(input, pivoit+1, rightIndex);
	}	
	private int sortPartition(int[] input, int leftIndex, int rightIndex) {		
		int pivotValue = input[leftIndex];
		int i = leftIndex+1;
		// count comparison
		this.compCnt += rightIndex - leftIndex;
		
		for(int j=leftIndex+1; j<rightIndex + 1; j++) {
			if(input[j] < pivotValue) {				
				//swap input[j] - input[i]
				int temp = input[i];
				input[i] = input[j];
				input[j] = temp;				
				i++;
				
			}
		}
		//swap input[l] - input[i-1]
		int temp = input[leftIndex];
		input[leftIndex] = input[i-1];
		input[i-1] = temp;
		
		return i-1;
	}
	private int getPivotIndex(int[] input, int leftIndex, int rightIndex) {
		if(this.pivot_rule == FIRST_EL_PIVOT) {
			return leftIndex;
		}else if(this.pivot_rule == LAST_EL_PIVOT) {
			return rightIndex;
		}else {
			int[][] theThree = {
					{leftIndex, input[leftIndex]}
					, {rightIndex, input[(leftIndex + rightIndex)/2]}
					, {rightIndex, input[rightIndex]}
			};
			for(int i=0; i<2; i++) { //1-2
				for(int j=i+1; j<3; j++) {
					if(theThree[i][1] > theThree[j][1]) {
						int[] temp = theThree[i];
						theThree[i] = theThree[j];
						theThree[j] = temp;
					}
				}
			}
			return theThree[1][0];
		}
	}

	public int[] getInputArr() {
		return inputArr;
	}

	public void setInputArr(int[] inputArr) {
		this.inputArr = inputArr;
	}

	public int getCompCnt() {
		return compCnt;
	}

	public void setCompCnt(int compCnt) {
		this.compCnt = compCnt;
	}
	
}
