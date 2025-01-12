package com.arun.main;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.scheduler.VirtualTimeScheduler;

public class VirtualTime {

	@Test
	void withoutVirtualTimeScheduler() {
		
		Flux<String> data = Flux.concat(Flux.just("a","b","c").delayElements(Duration.ofSeconds(1)), Flux.just("D","E","F").delayElements(Duration.ofSeconds(1)));
		
		StepVerifier.create(data.log()).expectSubscription().expectNextCount(6).verifyComplete();
		
	}
	
	@Test
	void Test() {
		VirtualTimeScheduler.getOrSet();
		
		Flux<String> data = Flux.concat(Flux.just("a","b","c").delayElements(Duration.ofSeconds(1)), Flux.just("D","E","F").delayElements(Duration.ofSeconds(1)));
		
		StepVerifier.withVirtualTime(() ->data.log()).expectSubscription().thenAwait(Duration.ofSeconds(6)).expectNextCount(6).verifyComplete();
		
	}
}
