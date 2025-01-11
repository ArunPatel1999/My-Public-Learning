package com.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entits.User;
import com.demo.exception.CustomeException;
import com.demo.repository.UserRepository;
import com.demo.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User getById(int id) throws CustomeException {
		log.info("find By id => "+id);
		return userRepository.findById(id).orElseThrow(() -> new CustomeException(404, "user not found"));
	}

	@Override
	public User getByNumber(String number) throws CustomeException {
		log.info("find By number => "+number);
		return userRepository.findByNumber(number).orElseThrow(() -> new CustomeException(404, "user not found"));
	}

	private boolean exists(String number) {
		return userRepository.existsByNumber(number);
	}

	@Override
	public User save(User user) throws CustomeException {
		log.info("save user number => "+(user.getNumber()));
		if(exists(user.getNumber()))
			throw new CustomeException(409, "number already stored");
		return userRepository.save(user);
	}


	@Override
	public String deleteById(int id) {
		log.warn("delete user id => "+id); 
		userRepository.deleteById(id);
		return "success";
	}

}
