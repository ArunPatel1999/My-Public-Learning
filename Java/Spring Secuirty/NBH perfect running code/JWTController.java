package com.chatapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.entity.embeddedentity.Login;
import com.chatapp.secuirty.JWTUtil;
import com.chatapp.secuirty.UserDetailsImpl;
import com.chatapp.secuirty.UserDetailsServiceImpl;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	private UserDetailsServiceImpl userDetailsService;
	private AuthenticationManager authenticationManager;
	private JWTUtil jwtUtil;
	
	public LoginController(UserDetailsServiceImpl userDetailsService, AuthenticationManager authenticationManager,
			JWTUtil jwtUtil) {
		super();
		this.userDetailsService = userDetailsService;
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}

	@PostMapping("getToken")
	public Map<String, String> getToken(@RequestBody Login login) {		
		userDetailsService.setClassName(login.getClassname());
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));

		UserDetailsImpl userDetails = userDetailsService.loadUserByUsername(login.getUsername());
		Map<String, String> map = new HashMap<>(1);
		map.put("token", jwtUtil.generateToken(userDetails));
		return map;
	}
	
}
