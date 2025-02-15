package com.company;

import java.util.Arrays;

public class SecondHighstInArray {
	public static void main(String[] args) {
		
		int[] normalArray = {45, 65, 2, 46, 88, 89};
		Arrays.sort(normalArray);
		System.out.println(normalArray[normalArray.length-2]);
		
	}
}
