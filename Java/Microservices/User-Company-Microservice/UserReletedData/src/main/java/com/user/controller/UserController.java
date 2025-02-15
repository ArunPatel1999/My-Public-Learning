package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getAll() {
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
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User userEdit) throws Exception {
		return userService.edit(id, userEdit);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		return userService.deleteUser(id);
	}
}
