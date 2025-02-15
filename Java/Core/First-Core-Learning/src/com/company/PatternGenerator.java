package com.company;

import java.util.Scanner;

public class PatternGenerator {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter size => ");
		int size = input.nextInt();
		
		for(int i=1; i<=size; i++) {
			for(int j=1; j<=i; j++)
				System.out.print(i+" ");
			System.out.println();
		}
		
		input.close();
		
	}
	
}
