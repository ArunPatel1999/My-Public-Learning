package com.mtraders.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtraders.demo.entity.User;
import com.mtraders.demo.repository.UserRepositry;

@Service
public class UserMongoService implements UserServiceInterface{

	@Autowired
	private UserRepositry userRepositry;
	
	@Override
	public List<User> getAll() {
		return userRepositry.findAll();
	}

	@Override
	public User getOne(int id) {
		return userRepositry.findById(id).orElse(new User());
	}

	@Override
	public String update(int id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addUserWithoutImage(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
