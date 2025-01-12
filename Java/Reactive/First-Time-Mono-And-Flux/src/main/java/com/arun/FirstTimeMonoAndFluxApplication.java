package com.arun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.tools.agent.ReactorDebugAgent;

@SpringBootApplication
public class FirstTimeMonoAndFluxApplication {
	
	public static void main(String[] args) {
		ReactorDebugAgent.init();
		SpringApplication.run(FirstTimeMonoAndFluxApplication.class, args);
	}
	
	@Bean
	public WebClient webClient() {
		return WebClient.create();
	}

}
