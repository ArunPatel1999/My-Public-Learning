package com.arun;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class NormalController2 {

	
	
	//@PostMapping("returnObject.discount<60")
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public String getAll(Authentication auth) {
		//Authentication auth1 = SecurityContextHolder.getContext().getAuthentication();
		return "Tests 2 "+auth.getName();
	}
	
	
}
