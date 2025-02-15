package com.arun;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigServer
public class ConfigrationServerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ConfigrationServerApplication.class, args);
		
	}
	
	@Value("${spring.cloud.config.server.native.search-locations}") private String url;
	
	@Bean
	public void data() {
		System.out.println(url);
	}

}
