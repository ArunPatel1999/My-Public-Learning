package com.mtraders.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/log")
@Slf4j
public class CreateContuiesLog {

	private boolean stop;
	
	@GetMapping
	public void startLog() {
		int i=0;
		while(!stop) {
			log.info(String.format("========%s========",i++));
		}
	}
	
	@DeleteMapping
	public void statAndStop() {
		stop = !stop;
	}
	
}
