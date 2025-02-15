package com.mtraders.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/encoder")
public class PasswordEncodeing {

	@Autowired
	public BCryptPasswordEncoder encoder;
	
	private String mainPass;
	
	@GetMapping("/{pass}")
	public String  getAll(@PathVariable String pass) {
		return "value =  "+encoder.matches(pass, mainPass);		
	}
	
	
	@PostMapping("/{pass}")
	public String save(@PathVariable String pass) {
		mainPass = encoder.encode(pass);
		return mainPass;
	}

}
