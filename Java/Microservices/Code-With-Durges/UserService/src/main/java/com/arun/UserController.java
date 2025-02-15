package com.arun;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.arun.entity.Contact;
import com.arun.entity.User;

@RestController
@RequestMapping("/user")
public class UserController {

	private List<User> users;
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private RestTemplate restTemplate;
	private int id = 2;
	
	 
	public UserController() {
		users = Arrays.asList(new User(1, "First", "0123456789"));
	}

	@GetMapping("/getAll")
	public List<User> getAllData() {
		logger.info("Get All User");
		return users;
	}
	
	@GetMapping
	public List<User> getAll() {
		logger.info("Get All User and also contact");
		return users.stream().peek(x -> x.setContacts(getContact(x.getId()))).collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public User getById(@PathVariable int id) {
		logger.info("Get ById User ");
		User user = users.stream().filter(x -> x.getId() == id).findAny().orElse(new User());
		user.setContacts(getContact(id));
		return user;
	}
	
	@PostMapping
	public User save(@RequestBody User user) {
		logger.info("Get Save ");
		user.setId(id++);
		users.add(user);
		return user;
	}
	
	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable int id) {
		return users.removeIf(x -> x.getId()==id);
	}
	
	private List<Contact> getContact(int id) {
		if(id == 0)
			return null;
		return restTemplate.getForEntity("http://contact/contact/"+id, List.class).getBody();
	}
}
