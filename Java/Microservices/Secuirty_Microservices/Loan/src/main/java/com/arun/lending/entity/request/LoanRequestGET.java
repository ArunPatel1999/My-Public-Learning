package com.arun.lending.entity.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoanRequestGET {

	
	private double amount;
	private String userId;
	private int daysReturn;
	private float intersetRate;
}
