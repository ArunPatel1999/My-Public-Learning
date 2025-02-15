package com.enter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompraterAndComprable {
	public static void main(String[] args) {
		
		List<Student> list = new ArrayList<>();
		
		list.add(new Student(45,"Test1"));
		list.add(new Student(10,"Test2"));
		list.add(new Student(60,"Test1"));
		list.add(new Student(45,"Test4"));
		list.add(new Student(80,"Test5"));
		
		list.forEach(System.out::println);
		System.out.println("\n----------------Comprrable => implemet by the class,Sorting is fix , com.lang---------------\n");
		
		
		Collections.sort(list);
		list.forEach(System.out::println);
		
		System.out.println("\n----------------Comprater => run time sorting , sorting change in run time , Lamda , com.util---------------\n");

		Collections.sort(list, (o1,o2)-> {
			if(o1.getName().equals(o2.getName())) {
				return o1.getMaks() - o2.getMaks();
			}else
				return o1.getName().compareTo(o2.getName());
		});

		Collections.sort(list, Comparator.comparing(Student::getName).thenComparingInt(Student::getMaks).reversed());
		
		//Without Lamda
		//Collections.sort(list, new MyCompraterSort());
		list.forEach(System.out::println);
	}
}

	class MyCompraterSort implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			if(o1.getName().equals(o2.getName())) {
				return o1.getMaks() - o2.getMaks();
			}else
				return o1.getName().compareTo(o2.getName());
		}}
	
