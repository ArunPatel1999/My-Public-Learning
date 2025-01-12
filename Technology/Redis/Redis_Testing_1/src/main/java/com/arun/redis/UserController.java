package com.arun.redis;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@GetMapping
	public List<User> getAll() {
		return userRepository.getAll();
	}
	
	@GetMapping("/{id}")
	public User getById(@PathVariable int id) {
		return userRepository.getById(id);
	}
	
	@PostMapping
	public User save(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		return userRepository.delete(id);
	}
	
}
