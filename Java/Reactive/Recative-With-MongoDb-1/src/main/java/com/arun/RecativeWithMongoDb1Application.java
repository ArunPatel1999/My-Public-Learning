package com.arun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class RecativeWithMongoDb1Application {

	public static void main(String[] args) {
		SpringApplication.run(RecativeWithMongoDb1Application.class, args);
	}

}
