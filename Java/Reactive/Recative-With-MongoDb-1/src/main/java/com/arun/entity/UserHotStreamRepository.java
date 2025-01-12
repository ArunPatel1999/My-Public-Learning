package com.arun.entity;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;

import reactor.core.publisher.Flux;

public interface UserHotStreamRepository extends ReactiveMongoRepository<UserHotStream, String>{
	
	@Tailable
	public Flux<UserHotStream> findUserHotStreamBy();
}
