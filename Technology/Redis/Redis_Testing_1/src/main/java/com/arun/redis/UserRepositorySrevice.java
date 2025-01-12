package com.arun.redis;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserRepositorySrevice implements UserRepository {

	private RedisTemplate<String, User> redisTemplate;
	private HashOperations<String, Integer, User> hashOperations;
	
	public UserRepositorySrevice(RedisTemplate<String, User> redisTemplate) {
		super();
		this.redisTemplate = redisTemplate;
		this.hashOperations = this.redisTemplate.opsForHash();
	}

	@Override
	public List<User> getAll() {
		return hashOperations.entries("USER").values().stream().collect(Collectors.toList());
	}

	@Override
	public User getById(int id) {
		return hashOperations.get("USER", id);
	}

	@Override
	public User save(User user) {
		 if(hashOperations.putIfAbsent("USER", user.getId(), user))
			 return getById(user.getId());
		 return null;
	}

	@Override
	public String delete(int id) {
		 System.out.println(hashOperations.delete("USER", id)); 
		 return "Success";
	}
	
	
	
	
}
