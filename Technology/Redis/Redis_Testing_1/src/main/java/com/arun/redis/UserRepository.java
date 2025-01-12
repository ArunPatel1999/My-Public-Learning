package com.arun.redis;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
	
	public List<User> getAll();
	
	public User getById(int id);
	
	public User save(User user);
	
	public String delete(int id);

}
