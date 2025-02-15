package com.security.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestARepositoy extends MongoRepository<TestA, Integer> {

	Optional<TestA> findByUsername(String username);

	boolean existsByNumber(String number);

}
