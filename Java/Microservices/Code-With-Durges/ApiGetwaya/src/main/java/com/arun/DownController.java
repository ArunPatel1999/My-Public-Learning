package com.arun;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownController {

	@GetMapping("/userDown")
	public String userDown() {
		return "User service is Down";
	}

	@GetMapping("/contactDown")
	public String contactDown() {
		return "Contact service is Down";
	}
	
	
}
