package com.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entits.User;
import com.demo.exception.CustomeException;
import com.demo.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
	
	private UserService userService;
	
	
	@GetMapping
	public List<User> getAll() {
		return userService.getAll();
	}

	@GetMapping("/{id}")
	public User getById(@PathVariable int id) throws CustomeException {
		return userService.getById(id);
	}
	
	@GetMapping("getByNumber/{number}")
	public User getByNumber(@PathVariable String number) throws CustomeException {
		return userService.getByNumber(number);
	}
	
	@PostMapping
	public User save(@Valid @RequestBody User user) throws CustomeException {
		return userService.save(user);
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable int id) {
		return userService.deleteById(id);
	}
	
}
