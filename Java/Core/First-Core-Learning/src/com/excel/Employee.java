package com.excel;

public class Employee {
	
	private String name;
	private String email;
	private String mobile;
	private String gstNumber;
	private String address;
	private String	bankAccount;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getGstNumber() {
		return gstNumber;
	}
	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public Employee(String name, String email, String mobile, String gstNumber, String address, String bankAccount) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.gstNumber = gstNumber;
		this.address = address;
		this.bankAccount = bankAccount;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
