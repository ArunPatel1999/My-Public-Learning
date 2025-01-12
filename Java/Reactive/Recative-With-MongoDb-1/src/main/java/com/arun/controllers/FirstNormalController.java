package com.arun.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("/normal")
public class FirstNormalController {

	@GetMapping("/just")
	public Flux<String> getJsut() {
		return Flux.just(0,1,2,3,4,5,6).map(x ->x==0?"<b> without produce type work like normal rest </b><br>":" "+x).delayElements(Duration.ofSeconds(1));
	}

	@GetMapping("/justInteger")
	public Flux<Integer> justInteger() {
		return Flux.just(0,1,2,3,4,5,6).delayElements(Duration.ofNanos(1000));
	}
	
	@GetMapping(value =  "/justStream",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<String> justStream() {
		return Flux.just(0,1,2,3,4,5,6).map(x ->x==0?"<b> without produce type work like normal rest </b><br>":" "+x).delayElements(Duration.ofSeconds(1));
	}

	@GetMapping(value =  "/justStreamInfinit",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Long> justStreamInfinit() {
		return Flux.interval(Duration.ofSeconds(1)).log();
	}
	
	@GetMapping("/range")
	public Flux<String> getRange() {
		return Flux.range(0,100).map(x ->x==0?"<b> without produce type work like normal rest </b><br>":""+x+" ");
	}
}
