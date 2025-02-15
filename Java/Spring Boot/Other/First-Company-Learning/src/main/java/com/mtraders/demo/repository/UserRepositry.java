package com.mtraders.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mtraders.demo.entity.User;

@Repository
public interface UserRepositry extends MongoRepository<User, Integer> {


}
