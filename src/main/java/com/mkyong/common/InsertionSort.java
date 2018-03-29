package com.mkyong.common;

public class InsertionSort {
	
	public static int[] insertion_sort(int[] arr){
		
		for(int i=0;i<arr.length;i++){
			
			for(int j=i;j>0;j--){
				if(arr[j]<arr[j-1]){
					int temp=arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=temp;
				}
				
			}
		}
		
		return arr;
	}

	public static void main(String[] args) {
		
		int[] arr={23,8,5,1,-5,90,34};
		
		System.out.println("Before Sorting: ");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i] +",");
		}
		arr=insertion_sort(arr);
		System.out.println("\nAfter Sorting ");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i] + ",");
		}

	}

}
