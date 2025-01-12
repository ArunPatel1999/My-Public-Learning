package com.arun.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.arun.entity.EntityRepositry;
import com.arun.entity.User;

@Service
public class UserService {

	private EntityRepositry userRepositry;
	private PasswordEncoder  passwordEncoder;
	
	
	public UserService(EntityRepositry userRepositry, PasswordEncoder passwordEncoder) {
		super();
		this.userRepositry = userRepositry;
		this.passwordEncoder = passwordEncoder;
	}

	public List<User> getAll(){
		return userRepositry.findAll();
	}
	
	public User getById(String username) {
		return userRepositry.findById(username).orElse(new User());
	}
	
	public User save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepositry.save(user);
	}
	
}
