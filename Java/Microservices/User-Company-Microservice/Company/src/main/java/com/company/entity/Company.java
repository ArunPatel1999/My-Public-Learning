package com.company.entity;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Company {

	@Id
	private int id;
	private String name;
	private String email;
	private String number;
	
	@DBRef
	Set<User> employes;
	
	
}
