package com.arun;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 {

	@GetMapping
	public String getData() {
		return "My Data ";
	}
}
