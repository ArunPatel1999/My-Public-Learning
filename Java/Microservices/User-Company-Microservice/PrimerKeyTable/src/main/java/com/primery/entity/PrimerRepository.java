package com.primery.entity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimerRepository extends MongoRepository<Primery, String>{

}
