package com.mtraders.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mtraders.demo.entity.LocalTimeTestingClass;

@Repository
public interface LocalTimeRepository extends MongoRepository<LocalTimeTestingClass, Integer> {

}
