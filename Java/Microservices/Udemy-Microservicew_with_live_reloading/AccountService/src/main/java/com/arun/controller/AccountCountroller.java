package com.arun.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountCountroller {

	@GetMapping("/check")
	public String check() {
		return "working...";
	}
	
}
