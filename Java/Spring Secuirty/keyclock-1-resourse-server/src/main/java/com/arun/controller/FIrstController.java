package com.arun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.arun.entity.User;

@RestController
public class FIrstController {

	@Autowired
	private Environment env;
	
	@GetMapping("/data")
	public String data() {
		return "gfsdusdfg";
	}
	
	
	@GetMapping("check")
	public String check() {
		return "working...."+env.getProperty("local.server.port");
	}
	
	@GetMapping("/jwt")
	public Object getJwtDetails(@AuthenticationPrincipal Jwt jwt){
		return jwt;
	}
	
	
	@PreAuthorize("hasRole('devloper') and #id==1")
//	@Secured("ROLE_devloper")
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable int id) {
		return "vaalue delete =>"+id;
	}
	
	
	@PostAuthorize("returnObject.id == #jwt.subject")
	@GetMapping("/getById/{id}")
	public User getById(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
		return new User(id, "First", 45);
	}
		
	
}
