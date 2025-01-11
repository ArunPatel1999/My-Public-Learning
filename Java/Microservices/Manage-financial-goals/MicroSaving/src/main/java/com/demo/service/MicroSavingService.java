package com.demo.service;

import java.util.List;

import com.demo.entity.MicroSaving;
import com.demo.exception.CustomeException;

public interface MicroSavingService {
	
	public MicroSaving getById(long id) throws CustomeException;
	
	public MicroSaving save(MicroSaving goals);

	public List<MicroSaving> getByGoalId(int goalId);


}
