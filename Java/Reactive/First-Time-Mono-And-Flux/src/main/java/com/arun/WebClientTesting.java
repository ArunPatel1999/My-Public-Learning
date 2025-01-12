package com.arun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.arun.entitys.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webClient")
public class WebClientTesting {

	@Autowired
	private WebClient webClient;
	
	@GetMapping("/retreve")
	public Flux<User> getAll() {
		return webClient.get().uri("http://localhost:9090/v1/user")
				.retrieve().bodyToFlux(User.class);
	}
	
	// Excherng give status code --- demo
	@GetMapping("/exchenge")
	public Flux<User> getAllExchenge() {
		return webClient.get().uri("http://localhost:9090/v1/user")
				.exchangeToFlux(x -> x.bodyToFlux(User.class));
//		.exchange().flatMapMany(x -> x.bodyToFlux(User.class));
	}
	
	@GetMapping("/retreve/{id}")
	public Mono<User> getById(@PathVariable String id) {
		return webClient.get().uri("http://localhost:9090/v1/user/{id}",id)
				.retrieve().bodyToMono(User.class).onErrorReturn(new User());
	}
	
	@PostMapping("/retreve/save")
	public Mono<User> save(@RequestBody User user) {
		return webClient.post().uri("http://localhost:9090/v1/user")
				.contentType(MediaType.APPLICATION_JSON)
				.body(Mono.just(user), User.class)
				.retrieve().bodyToMono(User.class);
	}
	
	@PostMapping("/retreve/update/{id}")
	public Mono<User> update(@PathVariable String id, @RequestBody User user) {
		
		return webClient.put().uri("http://localhost:9090/v1/user/{id}",id)
				.contentType(MediaType.APPLICATION_JSON)
				.body(Mono.just(user), User.class)
				.retrieve().bodyToMono(User.class).onErrorReturn(new User());
	}
	
	@DeleteMapping("/retreve/delete/{id}")
	public Mono<String> delete(@PathVariable String id) {
		return webClient.delete().uri("http://localhost:9090/v1/user/{id}",id)
				.retrieve().bodyToMono(String.class);
	}
	
	
}
