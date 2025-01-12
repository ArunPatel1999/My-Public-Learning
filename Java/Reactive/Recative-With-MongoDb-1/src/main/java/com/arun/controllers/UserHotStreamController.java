package com.arun.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arun.entity.UserHotStream;
import com.arun.entity.UserHotStreamRepository;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/hotStream")
public class UserHotStreamController {

	@Autowired
	private UserHotStreamRepository userHotStreamRepository;
	
	@GetMapping(path = "", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<UserHotStream> getAll() {
		return userHotStreamRepository.findUserHotStreamBy();
	}

	@PostMapping(path="", consumes = "application/stream+json")
	public void saveCConutinues(@RequestBody Flux<UserHotStream> data) {
		userHotStreamRepository.saveAll(data);
	}
}
