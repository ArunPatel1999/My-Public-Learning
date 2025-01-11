package com.apigetwaya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiGetwayaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGetwayaApplication.class, args);
	}

}
