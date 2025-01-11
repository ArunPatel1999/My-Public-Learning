package com.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class MicroSaving {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
	@NotNull(message = "goal id required ")
	private int goalId;
	@NotNull(message = "amount required")
	@Min(100)
	@Max(500)
	private double amount;
	private String text;	
	private LocalDateTime createdDate;	
}
