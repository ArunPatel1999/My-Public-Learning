package com.company;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateInString {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter String => ");
		String normalString = input.nextLine();
		Set<Character> duplicateChar = new LinkedHashSet<>();
		
		for(int i=0; i < normalString.length() ; i++)
			if(normalString.substring(i+1).contains(""+normalString.charAt(i)))
				duplicateChar.add(normalString.charAt(i));
		
		System.out.println("duplicate char =>"+ duplicateChar);
		input.close();
		
	}
}
