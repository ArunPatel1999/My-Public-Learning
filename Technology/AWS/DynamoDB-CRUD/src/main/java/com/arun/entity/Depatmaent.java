package com.arun.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@DynamoDBDocument
public class Depatmaent {

	@DynamoDBAttribute
	private String name;
	@DynamoDBAttribute
	private String headName;
	
}
