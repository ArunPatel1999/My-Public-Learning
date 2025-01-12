package com.arun.controllers;

import com.arun.entity.User;
import com.arun.entity.UserRepository;
import com.arun.exception.DemoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/user")
public class UserController_V1 {

	@Autowired private UserRepository userRepository;
	
	@GetMapping
	public Flux<User> getAll() {
		return userRepository.findAll();
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Mono<User> getById(@PathVariable String id) {
		return userRepository.findById(id).switchIfEmpty(Mono.error(new DemoException(404,  "User not found")));
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Mono<User> save(@RequestBody User user) {
		return userRepository.save(user);
	}
	@PostMapping("/saveAll")
	public Flux<User> saveAll(@RequestBody Flux<User> user) {
		return userRepository.saveAll(user);
	}
	
	@PutMapping("/{id}")
	public Mono<User> update(@PathVariable String id, @RequestBody User userEdit) {
		return getById(id).flatMap(x -> {
			x.setAge(userEdit.getAge());
			x.setName(userEdit.getName());
			return userRepository.save(x);
		});
	}
	
	@DeleteMapping("/{id}")
	public Mono<String> delete(@PathVariable String id) {
		 userRepository.deleteById(id);
		 return Mono.just("success");
	}
}
