package com.demo.entits;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull(message = "name not null")
	@Size(min = 2, max = 200 , message = "name length between 2 to 200")
	private String name;
	
	@NotNull(message = "number not null" )
	@Size(min = 10, max = 10, message = "number should be 10 digit")
	private String number;
	
	@CreationTimestamp
	private LocalDateTime creatredDate;
	@UpdateTimestamp
	private LocalDateTime updatedDate;
	
}
