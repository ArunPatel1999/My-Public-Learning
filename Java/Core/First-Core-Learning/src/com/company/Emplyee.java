package com.company;

import java.util.Arrays;
import java.util.List;

public class Emplyee {

	private int id;
	private String name;
	private int salary;
	private float pfPercentage;
	private int allownces;

	public Emplyee() {
	}

	public Emplyee(int id, String name, int salary, float pfPercentage, int allownces) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.pfPercentage = pfPercentage;
		this.allownces = allownces;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public float getPfPercentage() {
		return pfPercentage;
	}

	public void setPfPercentage(float pfPercentage) {
		this.pfPercentage = pfPercentage;
	}

	public int getAllownces() {
		return allownces;
	}

	public void setAllownces(int allownces) {
		this.allownces = allownces;
	}

	@Override
	public String toString() {
		return "id = " + id + ", name = " + name + ", salary = " + salary + ", pfPercentage = " + pfPercentage + ", allownces = " + allownces;
	}

	public static void main(String[] args) {

		List<Emplyee> employess = Arrays.asList(
				new Emplyee(1, "Test 1", 10000, 4, 1000),
				new Emplyee(2, "Test 2", 30000, 5, 1000), 
				new Emplyee(3, "Test 3", 5000, 2, 1000),
				new Emplyee(4, "Test 4", 100000, 10, 10000));
		
		employess.forEach(x ->  System.out.println(x+", netSalary = "+calculate(x)) );

	}

	private static double calculate(Emplyee emplyee) {
		double pfamount=emplyee.getSalary()*(emplyee.getPfPercentage()/ 100);
	    return emplyee.getSalary()+emplyee.getAllownces()-pfamount;
	}

}
