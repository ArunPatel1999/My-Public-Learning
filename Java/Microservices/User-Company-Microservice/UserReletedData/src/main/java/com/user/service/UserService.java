package com.user.service;

import java.util.List;

import com.user.entity.User;

public interface UserService {

	public List<User> getAll();
	
	public User getById(int id) throws Exception;
	
	public User save(User user);
	
	public User edit(int id, User editUser) throws Exception;
	
	public String deleteUser(int id);
}
