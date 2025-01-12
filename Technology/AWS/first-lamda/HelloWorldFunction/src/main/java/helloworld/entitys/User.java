package helloworld.entitys;

import java.util.Date;

public class User {

	private int id;
	private String name;
	private int age;
//	private LocalDate dob;
	private Date craetedDate;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
//	public LocalDate getDob() {
//		return dob;
//	}
//	public void setDob(LocalDate dob) {
//		this.dob = dob;
//	}
	public Date getCraetedDate() {
		return craetedDate;
	}
	public void setCraetedDate(Date craetedDate) {
		this.craetedDate = craetedDate;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public User(int id, String name, int age, LocalDate dob, Date craetedDate) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.age = age;
//		this.dob = dob;
//		this.craetedDate = craetedDate;
//	}
	public User(int id, String name, int age, Date craetedDate) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.craetedDate = craetedDate;
	}
	
	
	
}
