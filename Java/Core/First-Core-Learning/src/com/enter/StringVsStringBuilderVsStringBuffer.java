package com.enter;

public class StringVsStringBuilderVsStringBuffer {
	public static void main(String[] args) {
		
		//Highest Salary 
		//SELECT * FROM employee ORDER BY salary DESC LIMIT 0,1
		
		//o is start index
		//1 number of row

		String a = "abc";
		String b = "abc";
		String s = new String("abc");
	
		System.out.println(a==b);
		System.out.println(b==s);
		System.out.println(a==s);
		
		
	}
}
