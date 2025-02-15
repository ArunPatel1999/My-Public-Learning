package com.mtraders.demo.entity;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {

	public static final String SEQUENCE_NAME = "customer_sequence";
	
	@Id
	private int userId;
	
	@NotBlank(message =  "name not null")
	private String name;
	@Email(message = "not a valide email")
	private String email;
	@Length(min = 10, max = 10 , message = "number Shoud be 10")
	private String phone;
	private String address;
	private String userImage;
	private String token;

}
