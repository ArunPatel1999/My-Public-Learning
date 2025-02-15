package com.arun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired 
	private MySerice mySerice;
	
	@GetMapping
	public Object getData() {
		return mySerice.test();
	}

	
}
