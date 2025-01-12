package com.arun.redis;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String address;
	private int age;
	private LocalDate createdDate;
	public User() {
		super();
	}
	public User(int id, String name, String address, int age, LocalDate createdDate) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.age = age;
		this.createdDate = createdDate;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	
}
