package com.arun.lending.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class LoanRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private double amount;
	@ManyToOne
	private User user;
	private int daysReturn;
	private float intersetRate;
	private Date createdDate;
	
	
	public LoanRequest(double amount, int daysReturn, float intersetRate, Date createdDate) {
		super();
		this.amount = amount;
		this.daysReturn = daysReturn;
		this.intersetRate = intersetRate;
		this.createdDate = createdDate;
	}
	

	
	
}
