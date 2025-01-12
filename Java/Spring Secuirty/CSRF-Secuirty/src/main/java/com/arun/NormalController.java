package com.arun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NormalController {

	@GetMapping
	public String getAll() {
		return "Test";
	}
	
	@PostMapping("/save")
	public String getData(String data) {
		System.out.println(data);
		return "Test";
	}
}
