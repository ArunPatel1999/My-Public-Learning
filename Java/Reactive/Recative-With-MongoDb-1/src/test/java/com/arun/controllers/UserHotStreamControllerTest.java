package com.arun.controllers;

import java.time.Duration;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.arun.entity.UserHotStream;
import com.arun.entity.UserHotStreamRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@Slf4j
class UserHotStreamControllerTest {

	@Autowired MongoTemplate mongoTemplate;
	@Autowired WebTestClient webTestClient;
	@Autowired UserHotStreamRepository userHotStreamRepository;
	
	@BeforeEach
	public void setUp()  {
		System.out.println("=====Yes Run=======");
		mongoTemplate.dropCollection(UserHotStream.class);
		mongoTemplate.createCollection(UserHotStream.class, CollectionOptions.empty().maxDocuments(20).size(50000).capped());
		Flux<UserHotStream> data = Flux.interval(Duration.ofSeconds(1)).map(x -> new UserHotStream(""+x, "name "+x, Integer.parseInt(""+x+26), new Date())).take(5);
		userHotStreamRepository.insert(data).doOnNext(x -> log.info("insertIng =>"+x)).blockLast();
	}
	
	@Test
	public void test() {
		System.out.println("=======run==========");
		Flux<UserHotStream>	data = webTestClient.get().uri("/hotStream")
			.exchange()
			.expectStatus().isOk()
			.returnResult(UserHotStream.class)
			.getResponseBody().log("data =>> ").take(5);
		
		StepVerifier.create(data).expectNextCount(5).verifyComplete();
	}

}
