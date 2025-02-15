package com.arun.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arun.request.UserResponse;
import com.arun.service.UserSerivce;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	private Environment env;
	private UserSerivce userSerivce;

	public UserController(Environment env, UserSerivce userSerivce) {
		super();
		this.env = env;
		this.userSerivce = userSerivce;
	}

	@GetMapping("/check")
	public String check() { 
		return "working =>"+env.getProperty("local.server.port")+" === "+env.getProperty("expration.date");
	}
	
	@PostMapping
	public UserResponse save(@Valid @RequestBody UserResponse userResponse) {
		return userSerivce.save(userResponse); 
	}
	
	@GetMapping("/getByUserId/{userId}")
	public Map<String, Object> getByUserId(@PathVariable String userId) {
		return userSerivce.getByUserId(userId);
	}
	
}
