package com.dsa.array;

public class Arrayoperations {
	
	public int secondMax(int[] arr) {
		
		int max=Integer.MIN_VALUE;
		int secondMax=Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				secondMax=max;
				max=arr[i];
			}else if(arr[i]>secondMax && max!=arr[i]) {
				secondMax=arr[i];
			}
		}
		
		return secondMax;
	}
	public int[] moveZerosToEnd(int[] arr) {
		
		int j=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=0 && arr[j]==0) {
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
			if(arr[j]!=0) {
				j++;
			}
		}
		
		return arr;
	}
	

	public static void main(String[] args) {
		int[] intArray= {1,0,4,0,0,12,43};
		Arrayoperations arp=new Arrayoperations();
		
	  System.out.println( arp.secondMax(intArray));
	  int[] arr=arp.moveZerosToEnd(intArray);
	  

		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
		
		
	}
}
