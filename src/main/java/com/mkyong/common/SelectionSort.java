package com.mkyong.common;

public class SelectionSort {
	
	public static void selection_Sort(int[] arr){
		int index=0;
		
		for(int i=0;i<arr.length-1;i++){
			index=i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[index]>arr[j]){
					index=j;
				}
				
				int smallNumber=arr[index];
				arr[index]=arr[i];
				arr[i]=smallNumber;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr={23,8,5,1,-5,90,34};
		
		System.out.println("Before Sorting: ");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i] +",");
		}
		selection_Sort(arr);
		System.out.println("\nAfter Sorting ");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i] + ",");
		}
		
	}

}
