package com.company;

import java.time.LocalDate;

public class Student {

	private String name;
	private LocalDate dob;
	
	public Student(String name, LocalDate dob) {
		super();
		this.name = name;
		this.dob = dob;
	}
	
	
	public static void main(String[] args) {
		
		Student student1 = new Student("Test1", LocalDate.of(1999, 01, 01)); 
		Student student2 = new Student("Test2", LocalDate.of(2000, 03, 01)); 
		Student student3 = new Student("Test1", LocalDate.of(1999, 01, 01)); 
		
		System.out.println(isEqual(student1, student2));
		System.out.println(isEqual(student2, student3));
		System.out.println(isEqual(student1, student3));
		
		Student student4 = student1;
		System.out.println(isEqual(student1, student4));
		System.out.println(isEqual(student2, student4));
		
		
	}
	
	private static boolean isEqual(Student obj1, Student obj2) {
//		System.out.println(obj1.hashCode());
//		System.out.println(obj2.hashCode());
		return obj1.equals(obj2);
	}
	
	
}
