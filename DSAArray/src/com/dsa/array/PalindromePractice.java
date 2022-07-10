package com.dsa.array;

public class PalindromePractice {
	
public static void main(String[] args) {
	
    String str= "krl";
    int j=str.length()-1;
	int i=0;
	for(;i<(str.length()/2);i++) {
		if(str.charAt(i)==str.charAt(j)) {
			j--;
		}
		else {
			break;
		}
	}
	if(i!=(str.length()/2)) {
		System.out.println("Given string is not palindrome");
	}
	else {
		System.out.println("palindrome");
	}
}
	
}
