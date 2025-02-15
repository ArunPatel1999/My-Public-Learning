package com.arun.lending.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {
	
	@Id
	private String username;
	private String firstName;
	private String lastName;
	private int age;
	private String occupation;
	@OneToOne
	private Balance balance;
			
	
	public void topUp(Money money) {
		balance.topUp(money);
	}
	
	public void withDraw(Money money) {
		balance.withdraw(money);
	}

	public User(String username, String firstName, String lastName, int age, String occupation) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.occupation = occupation;
	}
	
	
}
