package com.arun.controllers;

import com.arun.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Date;

@SpringBootTest
@AutoConfigureWebTestClient
class UserController_V1Test {

	@Autowired private WebTestClient webTestClient;
	
	
	@Test
	void findAll() {
		Flux<User> allData =webTestClient.get().uri("/v1/user").exchange().expectStatus().isOk().returnResult(User.class).getResponseBody();
		StepVerifier.create(allData).expectNextCount(1001).verifyComplete();
	}

	@Test
	void findById() {
		webTestClient.get().uri("/v1/user/1").exchange().expectStatus().isOk()
		.expectBody().jsonPath("$.id").isEqualTo("1").jsonPath("$.createdDate").doesNotExist();
	}
	
	@Test
	void findByIdError() {
		webTestClient.get().uri("/v1/user/NoID").exchange().expectStatus().is4xxClientError()
		.expectBody(String.class).isEqualTo("User not found");
	}
	
	@Test
	void update() {
		User user = new User("test","updateedName",1000, new Date());
		webTestClient.put().uri("/v1/user/{id}","username")
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON)
		.body(Mono.just(user), User.class)
		.exchange().expectStatus().isOk()
		.expectBody().jsonPath("$.age").isEqualTo(1000).jsonPath("$.name").isEqualTo("updateedName");
			
	}
}
