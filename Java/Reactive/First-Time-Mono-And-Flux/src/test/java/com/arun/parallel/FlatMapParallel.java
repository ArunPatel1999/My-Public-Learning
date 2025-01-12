package com.arun.parallel;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

public class FlatMapParallel {

	@Test
	void withoutParallel() {
		long a= System.nanoTime();
		Flux<String> data = Flux.just("A", "B", "C","D","E","F")
				.flatMap(x -> Flux.fromIterable(getFlux(x))).log();
		
		StepVerifier.create(data).expectNextCount(12).verifyComplete();
		System.out.println("without Parallel =>"+(System.nanoTime()-a));
		
	}

	@Test
	void withParallel() {
		long a= System.nanoTime();
		Flux<String> data = Flux.fromIterable(Arrays.asList("A", "B", "C","D","E","F"))
				.window(2)
//				.flatMapSequential(x -> x.map(this::getFlux).subscribeOn(Schedulers.parallel()))
				.flatMap(x -> x.map(this::getFlux).subscribeOn(Schedulers.parallel()))
				.flatMap(s -> Flux.fromIterable(s))
				.log();
		
		StepVerifier.create(data).expectNextCount(12).verifyComplete();
		System.out.println("with Parallel =>"+(System.nanoTime()-a));
		
	}

	private List<String> getFlux(String x) {
		try {
			Thread.sleep(1000);
		}catch (Exception e) {
		}
		return Arrays.asList(x, "Add DATA");
	}
	
	
}
