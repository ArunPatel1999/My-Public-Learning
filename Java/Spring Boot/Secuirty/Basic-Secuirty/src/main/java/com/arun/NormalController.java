package com.arun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.databind.JsonNode;

@Controller
public class NormalController {

	@GetMapping
	public String getAll() {
		return "Test";
		
	}
	
}
