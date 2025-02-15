package com.enter;

public class Student implements Comparable<Student> {

	private int maks;
	private String name;
	public int getMaks() {
		return maks;
	}
	public void setMaks(int maks) {
		this.maks = maks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [maks=" + maks + ", name=" + name + "]";
	}
	
	@Override
	public int compareTo(Student o) {
		if(this.maks > o.maks) return 1;
		else if (this.maks < o.maks) return -1;
		return this.getName().compareTo(o.getName());
	}
	public Student(int maks, String name) {
		super();
		this.maks = maks;
		this.name = name;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
