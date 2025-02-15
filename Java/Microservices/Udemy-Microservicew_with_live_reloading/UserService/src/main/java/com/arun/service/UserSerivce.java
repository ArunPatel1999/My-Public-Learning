package com.arun.service;

import java.util.Map;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.arun.request.UserResponse;

public interface UserSerivce extends UserDetailsService {
	
	public UserResponse save(UserResponse response);

	public UserResponse getByUsername(String username);

	public Map<String, Object> getByUserId(String userId);
}
