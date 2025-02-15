package com.mtraders.demo.controller;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtraders.demo.entity.LocalTimeTestingClass;
import com.mtraders.demo.repository.LocalTimeRepository;

@RestController
@RequestMapping("api/localTime")
public class LocalTimeTesting {

	@Autowired
	private LocalTimeRepository repository;
	
	@GetMapping
	public LocalTimeTestingClass get() {
		return repository.findById(1).get();
	}
	
	
	@PostMapping
	public LocalTimeTestingClass save() {
		LocalTimeTestingClass local = new LocalTimeTestingClass();
		local.setId(1);
		local.setMessage("test");
		local.setTime(LocalTime.now());
		
		return repository.save(local);
	}
}
