package com.arun.lending.entity.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanApprovedGET {

	private String requestUserId;
	private String acceptUserId;
	private double amount;
	private int daysReturn;
	private float intersetRate;	
	
}
