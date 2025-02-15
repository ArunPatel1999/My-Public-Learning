package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.entity.User;
import com.user.entity.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<User> getAll() {
		return repository.findAll();
	}

	@Override
	public User getById(int id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("User Not Found"));
	}

	@Override
	public User save(User user) {
		user.setId(restTemplate.getForEntity("http://PRIMERY-KEY/api/primery/USERTABLE", Integer.class).getBody());
		return repository.save(user);
	}

	@Override
	public User edit(int id, User editUser) throws Exception {
		getById(id);
		editUser.setId(id);
		return repository.save(editUser);
	}

	@Override
	public String deleteUser(int id) {
		repository.deleteById(id);
		return "success";
	}

}
