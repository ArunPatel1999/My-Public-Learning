package com.arun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@SpringBootApplication
public class TwoMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwoMongoApplication.class, args);
	}
	
	@Bean
	public DB getDatabase() {
		
		return new MongoClient(new MongoClientURI("mongodb://localhost:localhost@localhost:27017/?authSource=admin")).getDB("ZZZ");
	}

}
