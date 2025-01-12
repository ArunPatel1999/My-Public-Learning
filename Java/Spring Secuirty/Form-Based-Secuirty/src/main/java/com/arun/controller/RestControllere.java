package com.arun.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arun.entity.User;
import com.arun.service.UserService;

@RestController
@RequestMapping("/user")
public class RestControllere {

	private UserService userService;
	
	
	public RestControllere(UserService userService) {
		super();
		this.userService = userService;
	}


	@GetMapping("/getData")
	public String getData() {
		return "Tests Data";
	}
	
	@GetMapping
	public List<User> getAll(){
		return userService.getAll();
	}
	
	@GetMapping("/{id}")
	public User getById(@PathVariable String id ){
		return userService.getById(id);
	}
	
	@PostMapping
	public User save(@RequestBody User user) {
		return  userService.save(user);
	}
}
