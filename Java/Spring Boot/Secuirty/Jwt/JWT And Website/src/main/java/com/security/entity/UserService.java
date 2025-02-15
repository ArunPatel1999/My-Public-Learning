package com.security.entity;

import java.util.List;

public interface UserService {

	
	public List<User> getAll();
	
	public User getById(int id) throws Exception;
	
	public User save(User user);
	
	public User editUser(int id, User user) throws Exception;
	
	public String delete(int id);
	
}
