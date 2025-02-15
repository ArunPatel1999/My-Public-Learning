package com.arun;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/getData")
	public List<String> getData(){
		return Arrays.asList("Tests 1","Tests 2","Tests 3", "Tests 4", "Tests 5");
	}
}
