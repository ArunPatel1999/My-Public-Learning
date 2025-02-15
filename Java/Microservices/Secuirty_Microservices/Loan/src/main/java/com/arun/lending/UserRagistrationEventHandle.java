package com.arun.lending;

import org.springframework.stereotype.Component;

import com.arun.lending.entity.User;
import com.arun.lending.repository.UserRepository;
import com.google.gson.Gson;

@Component
public class UserRagistrationEventHandle {

	private UserRepository userRepository;
	private Gson gson;
	public UserRagistrationEventHandle(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
		gson = new Gson();
	}
	

	public void handleRegistration(String user) {
		System.out.println(userRepository.save(gson.fromJson(user, User.class)).getFirstName()+" register");
	}
	
}
