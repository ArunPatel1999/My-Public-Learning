package com.security.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestBRepositoy extends MongoRepository<TestB, Integer> {

	Optional<TestB> findByUsername(String username);

	boolean existsByNumber(String number);

}
