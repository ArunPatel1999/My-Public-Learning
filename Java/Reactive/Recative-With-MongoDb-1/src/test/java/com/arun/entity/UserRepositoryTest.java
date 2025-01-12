package com.arun.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.annotation.DirtiesContext;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@DataMongoTest
@DirtiesContext
class UserRepositoryTest {

	
	@Autowired private UserRepository userRepository;
	
	List<User> data = Arrays.asList(new User("1", "First User", 45, new Date()),
			new User("2", "2 User", 2, new Date()),
			new User("3", "3 User", 42, new Date()),
			new User("4", "4 User", 8, new Date()),
			new User("5", "5 User", 23, new Date()));
	@BeforeEach
	void saveSomeDate() {
		userRepository.deleteAll().thenMany(Flux.fromIterable(data)).flatMap(userRepository::save).doOnNext(a -> System.out.println("new User add =>"+a)).blockLast();
	}
	
	
	@Test
	void findAll() {
		StepVerifier.create(userRepository.findAll().log()).expectNextCount(5).verifyComplete();
	}
	
	@Test
	void findById() {
		StepVerifier.create(userRepository.findById("5").switchIfEmpty(Mono.error(new Exception("User not found"))).log()).expectNextMatches(data -> data.getAge()==23).verifyComplete();
	}
	
	@Test
	void update() {
		int newage =55;
		Mono<User> updateData =	userRepository.findById("3").map(x -> {
			x.setAge(newage);
			return x;
		}).flatMap(userRepository::save);
		
		StepVerifier.create(updateData.log("update :")).expectNextMatches(x -> x.getAge() == newage && x.getId().equals("3")).verifyComplete(); 
		
	}

}
