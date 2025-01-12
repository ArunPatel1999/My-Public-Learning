package com.arun.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arun.entity.Employee;
import com.arun.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

	private UserService userService;
	
	@GetMapping
	public List<Employee> getAll() {
		return userService.getAll();
	}
	
	@GetMapping("/{id}")
	public Employee getById(@PathVariable String id) {
		return userService.getById(id);
	}
	
	@PostMapping
	public Employee save(@RequestBody Employee user) {
		return userService.save(user);
	}
	
	@PutMapping("/{id}")
	public Employee update(@PathVariable String id, @RequestBody Employee user) {
		return userService.update(id, user);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable String id) {
		return userService.deleteById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public String deleteAll() {
		return userService.deleteAll();
	}
	
	
}
