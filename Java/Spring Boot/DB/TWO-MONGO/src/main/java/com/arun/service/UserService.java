package com.arun.service;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.arun.entity.User;
import com.arun.entity.UserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

@Service
public class UserService {

	private UserRepository userRepository;
	private DBCollection dbCollection ;
	
	public UserService(UserRepository userRepository, DB database) {
		this.userRepository = userRepository;
		dbCollection = database.getCollection("User");
	}



	public Object save(User user) {
		user.setCreatedDate(new Date());
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map =  mapper.convertValue(user, new TypeReference<Map<String, Object>>() {});

		dbCollection.save(new BasicDBObject(map));
		return userRepository.save(user);
	}
	
	
}
