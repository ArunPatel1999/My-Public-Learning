package com.arun.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arun.service.JWTUtility;
import com.arun.service.UserService;

@RestController
public class Controller {

	private AuthenticationManager authenticationManager;
	private JWTUtility jwtUtility;
	private UserService userService;
	
	public Controller(AuthenticationManager authenticationManager, JWTUtility jwtUtility, UserService userService) {
		this.authenticationManager = authenticationManager;
		this.jwtUtility = jwtUtility;
		this.userService = userService;
	}

	@GetMapping
	public String getData() {
		System.out.println("secuirty => "+SecurityContextHolder.getContext().getAuthentication().getName());
		
		return "Tests Data";
	}
	
	
	@GetMapping("/getData")
	public String data() {
		System.out.println("datra");
		return "This data";
	}
	
	@PostMapping("/getToken")
	public Map<String, Object>  getToken(@RequestBody User user) throws Exception {
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		}catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		
		UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
		
		System.out.println("secuirty => "+SecurityContextHolder.getContext().getAuthentication().getName());
		
		Map<String, Object> data = new LinkedHashMap<>();
		data.put("token", jwtUtility.generateToken(userDetails));
		data.put("refrense", getRefrenseToken(userDetails));
		
		return data;
	}
	
	@PostMapping("againToken")
	public Map<String, Object> againToken(@RequestBody Map<String, String> data) throws Exception {
		String refrense = data.get("refrense");
		String tokenUsername = jwtUtility.getUsernameFromToken(refrense);
		String username = data.get("username");
		
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, "", new ArrayList<>()) ;
		
		if(!jwtUtility.validateToken(refrense, userDetails) && !username.equals(tokenUsername))
			throw new Exception("Token is not good"); 
		
		Map<String, Object> returnData = new LinkedHashMap<>();
		returnData.put("token", jwtUtility.generateToken(userDetails));
		returnData.put("refrense", getRefrenseToken(userDetails));
		
		return returnData;
	}
	
	
	private String getRefrenseToken(UserDetails userDetails ) {
		return jwtUtility.generateRefrenseToken(userDetails);
	}
	
}
