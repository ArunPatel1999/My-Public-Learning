package com.arun.lending.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LoanApproved {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	private User requestUser;
	@ManyToOne
	private User acceptUser;
	private double amount;
	private int daysReturn;
	private float intersetRate;
	private Date createdDate;
	
	public LoanApproved(User requestUser, User acceptUser, double amount, int daysReturn, float intersetRate,
			Date createdDate) {
		super();
		this.requestUser = requestUser;
		this.acceptUser = acceptUser;
		this.amount = amount;
		this.daysReturn = daysReturn;
		this.intersetRate = intersetRate;
		this.createdDate = createdDate;
	}
	
	
	
}
