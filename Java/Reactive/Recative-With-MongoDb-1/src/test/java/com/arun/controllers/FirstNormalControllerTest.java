package com.arun.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebFluxTest
class FirstNormalControllerTest {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void getJust1() {
		Flux<Integer> data = webTestClient.get().uri("/normal/justInteger").accept(MediaType.APPLICATION_JSON_UTF8)
				.exchange().expectStatus().isOk().returnResult(Integer.class).getResponseBody();

		StepVerifier.create(data.log()).expectNext(0, 1, 2, 3, 4, 5, 6).verifyComplete();
	}
	
	@Test
	void getJust2() {
		webTestClient.get().uri("/normal/justInteger").accept(MediaType.APPLICATION_JSON_UTF8)
				.exchange().expectStatus().isOk().expectBodyList(Integer.class).hasSize(7);
	}
	
	@Test
	void getJust3() {
		List<Integer> accepted = Arrays.asList(0,1,2,3,4,5,6);
		EntityExchangeResult<List<Integer>> data = webTestClient.get().uri("/normal/justInteger").accept(MediaType.APPLICATION_JSON_UTF8)
		.exchange().expectStatus().isOk().expectBodyList(Integer.class).returnResult();
		assertEquals(accepted, data.getResponseBody());
	}
	
	@Test
	void getJust4() {
		List<Integer> accepted = Arrays.asList(0,1,2,3,4,5,6);
		webTestClient.get().uri("/normal/justInteger").accept(MediaType.APPLICATION_JSON_UTF8)
				.exchange().expectStatus().isOk().expectBodyList(Integer.class).consumeWith(x -> {assertEquals(accepted, x.getResponseBody());});
		
	}

	@Test
	void getStreamInfifnte() {
		Flux<Integer> data = webTestClient.get().uri("/normal/justStreamInfinit").accept(MediaType.APPLICATION_STREAM_JSON)
				.exchange().expectStatus().isOk().returnResult(Integer.class).getResponseBody();

		StepVerifier.create(data).expectNext(0, 1, 2).thenCancel().verify();
	}

}
