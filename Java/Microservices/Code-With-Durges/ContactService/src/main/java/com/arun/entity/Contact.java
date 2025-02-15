package com.arun.entity;

public class Contact {

	private String name;
	private String number;
	
	private int userId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Contact() {
		super();
	}
	public Contact(String name, String number, int userId) {
		super();
		this.name = name;
		this.number = number;
		this.userId = userId;
	}
	
	
}
