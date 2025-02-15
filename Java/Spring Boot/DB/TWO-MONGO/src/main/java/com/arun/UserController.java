package com.arun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arun.entity.User;
import com.arun.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userRepository;
	
	@PostMapping
	public Object save(@RequestBody User user) {
		return userRepository.save(user);
	}
	
}
