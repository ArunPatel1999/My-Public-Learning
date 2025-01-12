package com.arun.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.arun.entity.Employee;

@Service
public class UserServiceImpl implements UserService{

	
	private DynamoDBMapper dynamoDBMapper;
	
	public UserServiceImpl(DynamoDBMapper dynamoDBMapper) {
		this.dynamoDBMapper = dynamoDBMapper;
	}

	@Override
	public List<Employee> getAll() {
		return dynamoDBMapper.scan(Employee.class, new DynamoDBScanExpression());
	}

	@Override
	public Employee getById(String id) {
		return dynamoDBMapper.load(Employee.class,id);
	}

	@Override
	public Employee save(Employee item) {
		dynamoDBMapper.save(item);
		return item;
	}

	@Override
	public Employee update(String id, Employee user) {
		user.setId(id);
		dynamoDBMapper.save(user, new DynamoDBSaveExpression().withExpectedEntry("id", new ExpectedAttributeValue(new AttributeValue().withS(id))));
		return user;
	}

	@Override
	public String deleteById(String id) {
		dynamoDBMapper.delete(getById(id));
		return "delete Successfull";
	}

	@Override
	public String deleteAll() {
		dynamoDBMapper.batchDelete(getAll());
		return "success";
	}

	

}
