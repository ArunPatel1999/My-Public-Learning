package com.arun.newwayapi;

import com.arun.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureWebTestClient
class SimpleDataClassTest {

	@Autowired
	private WebTestClient webTestClient;
	
	@Test
	void getFlux() {
		List<Integer> accepted = Arrays.asList(0,1,2,3,4);
		webTestClient.get().uri("/simple/flux").accept(MediaType.APPLICATION_JSON_UTF8)
				.exchange().expectStatus().isOk().expectBodyList(Integer.class).consumeWith(x -> {assertEquals(accepted, x.getResponseBody());});
		
	}
	
	@Test
	void getMono() {
		Integer test = new Integer(1);
		webTestClient.get().uri("/simple/mono").accept(MediaType.APPLICATION_JSON_UTF8)
		.exchange().expectStatus().isOk().expectBodyList(Integer.class).consumeWith(x -> {assertEquals(test, x.getResponseBody());});
		
	}
	
//=======================================	

	@Test
	void userGetAll() {
		Flux<User> data= webTestClient.get().uri("/fun/user").accept(MediaType.APPLICATION_JSON)
				.exchange().expectStatus().isOk().returnResult(User.class).getResponseBody();
		StepVerifier.create(data).expectNextCount(1001).verifyComplete();
	}

}
