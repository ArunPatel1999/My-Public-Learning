package com.security.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.exception.KeeboAppException;
import com.security.repository.TestA;
import com.security.repository.TestB;
import com.security.repository.UserNameAndPassword;



@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class JWTController {

	@Autowired
	JWTService jwtService;
	
	@PostMapping("/getToken")
	public Map<String, String> getToken(@RequestBody UserNameAndPassword userNameAndPassword) throws KeeboAppException {		
		return jwtService.getToken(userNameAndPassword);
	}

	@PostMapping("/signup")
	public String registerUser(@RequestBody TestA user) throws KeeboAppException {
		return jwtService.registerUser(user);
	}

	@PostMapping("/signup1")
	public String registerUser1(@RequestBody TestB user) throws KeeboAppException {
		return jwtService.registerUser1(user);
	}
	
	
	@GetMapping
	public String get() {
		return "suidyudfh";
	}

}
