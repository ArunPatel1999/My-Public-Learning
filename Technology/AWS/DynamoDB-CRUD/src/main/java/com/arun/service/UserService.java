package com.arun.service;

import java.util.List;

import com.arun.entity.Employee;

public interface UserService {

	public List<Employee> getAll();
	
	public Employee getById(String id);
	
	public Employee save(Employee user);

	public Employee update(String id, Employee user);
	
	public String deleteById(String id);
	
	public String deleteAll(); 
	
	
	
}
