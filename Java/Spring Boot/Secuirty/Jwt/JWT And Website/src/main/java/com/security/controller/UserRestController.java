package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.entity.User;
import com.security.entity.UserService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping
	public List<User> getAll(){
		return userService.getAll();	
	}
	
	
	@GetMapping("/{id}")
	public User getById(@PathVariable int id) throws Exception {
		return userService.getById(id);
	}
	
	@PostMapping
	public User save(@RequestBody User user) {
		return userService.save(user);
	}
	
	
	@PostMapping("/{id}")
	public User update(@PathVariable int id,@RequestBody User user) throws Exception {
		return userService.editUser(id,user);
	}
	
	@DeleteMapping("/{id}")
	public String deletUser(@PathVariable int id)  {
		return userService.delete(id);
	}
	
}
