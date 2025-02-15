package com.security.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User getById(int id) throws Exception {
		return userRepository.findById(id).orElseThrow(() -> new Exception("Data Not Found"));
	}

	@Override
	public User save(User user) {
		user.setId(getAll().size()+1);
		return userRepository.save(user);
	}

	@Override
	public User editUser(int id, User user) throws Exception {
		user.setId(getById(id).getId());
		return userRepository.save(user);
	}

	@Override
	public String delete(int id) {
		userRepository.deleteById(id);
		return "success";
	}

}
