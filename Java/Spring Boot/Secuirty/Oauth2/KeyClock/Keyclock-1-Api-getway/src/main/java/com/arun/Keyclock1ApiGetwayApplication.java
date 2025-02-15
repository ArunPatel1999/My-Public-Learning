package com.arun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Keyclock1ApiGetwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(Keyclock1ApiGetwayApplication.class, args);
	}

}
