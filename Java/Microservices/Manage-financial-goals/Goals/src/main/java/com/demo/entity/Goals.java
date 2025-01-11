package com.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class Goals {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
	@NotNull(message = "user id required ")
	private int userId;
	@NotNull(message = "title required")
	private String goalTitle;
	private String goalDescription;
	@NotNull(message = "amount required")
	private double amount;
	private double totalMicroSaving;
	@CreationTimestamp
	private LocalDateTime createdDate;
	private LocalDateTime lastSavingDate;
	private boolean goalCompleted;
	
}
