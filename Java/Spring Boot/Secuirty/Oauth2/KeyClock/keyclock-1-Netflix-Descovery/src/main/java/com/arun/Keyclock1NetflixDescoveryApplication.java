package com.arun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Keyclock1NetflixDescoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(Keyclock1NetflixDescoveryApplication.class, args);
	}

}
