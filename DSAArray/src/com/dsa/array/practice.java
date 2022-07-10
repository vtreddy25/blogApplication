package com.dsa.array;

public class practice {

public static void main(String[] args) {
	
	int[] arr= {1,3,5,0,4,6,0,2,0,6};
	int j=0;
	
	for(int i=0;i<arr.length;i++) {
		if(arr[i]!=0 && arr[j]==0) {
			arr[j]=arr[i];
			arr[i]=0;
			j++;
		}
		if(arr[j]!=0)
		      j++;
	}
	
	for(int i=0;i<arr.length;i++) {
		System.out.println(arr[i]);
	}
}
}
