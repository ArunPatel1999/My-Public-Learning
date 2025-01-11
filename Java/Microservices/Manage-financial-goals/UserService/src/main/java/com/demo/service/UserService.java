package com.demo.service;

import java.util.List;

import com.demo.entits.User;
import com.demo.exception.CustomeException;

public interface UserService {

	public List<User> getAll();

	public User getById(int id) throws CustomeException;
	
	public User getByNumber(String number) throws CustomeException;
	
	public User save(User user) throws CustomeException;
	
	public String deleteById(int id) ;
}
