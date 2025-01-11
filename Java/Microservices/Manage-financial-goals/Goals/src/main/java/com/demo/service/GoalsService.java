package com.demo.service;

import java.util.List;
import java.util.Map;

import com.demo.entity.Goals;
import com.demo.exception.CustomeException;

public interface GoalsService {

	public List<Goals> getAllGoals();
	
	public Goals getById(long id) throws CustomeException;
	
	public Goals save(Goals goals);

	public List<Goals> getByUserId(int userId);

	public boolean savingAdd(long id, double amount, String text) throws CustomeException;

	public Map<String, Object> getFullDetailsOfGoals(int goalId) throws CustomeException;

}
