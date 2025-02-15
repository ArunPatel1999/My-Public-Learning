package com.enter;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

class Tests{
	final int id = 10;
	public String name = "value";
	public static String staticData = "staticData";
	private final String str;

	Tests(){
        this.str = "This is the string that never changes!";
    }

	@Override
	public String toString() {
		return "Tests [id=" + id + ", name=" + name + ", finalData=" + str + "]";
	}
	
	
}

public class ReflactionAndClass {
	private Integer id = 10;
	public String name = "value";
	public static String staticData = "staticData";
	public final String finalData ="DATA";
	
	public static void main(String[] args) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		
		Tests reflactionAndClass = new Tests();

        Field field = reflactionAndClass.getClass().getDeclaredField("str");
        System.out.println(reflactionAndClass);
        field.setAccessible(true);
        field.set(reflactionAndClass, "There you are");
        System.out.println(reflactionAndClass);

        
        Scanner input = new Scanner(System.in);
		System.out.print("Enter Class Name = > ");
		Class data = Class.forName(input.next());
		
        
		System.out.println("\nconstruter --");
		for(Constructor c: data.getConstructors())
			System.out.println(c);
		
		

		System.out.println("\nfield --");
		for(Field c: data.getDeclaredFields()) {
			System.out.println(c+" ==== "+c.isAccessible());
			
		}
		
		System.out.println("\nMethod --");
		for(Method c: data.getDeclaredMethods())
			System.out.println(c);
		
		
		try {
		ReflactionAndClass res =	(ReflactionAndClass) data.newInstance();
		res.mentod();
		}catch (Exception e) {
			System.out.println("\nnot ReflactionAndClass");
		}
	}
	
	private void mentod() {
		System.out.println("\nmethod Run");
	}
	
	public static void mentod1(int id, int name) {}
	
}
