package com.arun;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arun.entity.Contact;

@RestController
@RequestMapping("/contact")
public class ContactController {

	private List<Contact> contact;
	public ContactController() {
		contact = Arrays.asList(new Contact("Testyy", "0123456789",1));
	}

	@GetMapping
	public List<Contact> getAll() {
		return contact;
	}
	
	@GetMapping("/{id}")
	public List<Contact> getById(@PathVariable int id) {
		return contact.stream().filter(x -> x.getUserId() == id).collect(Collectors.toList());
	}
	
	@PostMapping("/{userId}")
	public Contact save( @PathVariable int userId, @RequestBody Contact user) {
		user.setUserId(userId);
		contact.add(user);
		return user;
	}
	
	@DeleteMapping("/{number}")
	public boolean delete(@PathVariable String number) {
		return contact.removeIf(x -> x.getNumber().equals(number));
	}
}
