package com.mtraders.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test")
public class TestClass {
	
	@GetMapping
	public ResponseEntity<Object> getAll(HttpServletResponse response) {
		response.setHeader("cache-control", "max-age=86400");
		return ResponseEntity.ok("ok");
	}

}
