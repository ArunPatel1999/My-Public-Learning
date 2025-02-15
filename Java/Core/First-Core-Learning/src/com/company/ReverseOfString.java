package com.company;

import java.util.Scanner;

public class ReverseOfString {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter String => ");
		String normalString = input.nextLine();
		String reverseString = "";
		for(int i=normalString.length()-1; i >=0 ; i--)
			reverseString+=normalString.charAt(i);
		
		System.out.println("Reverse String =>"+ reverseString);
		input.close();
		
	}
	
}
