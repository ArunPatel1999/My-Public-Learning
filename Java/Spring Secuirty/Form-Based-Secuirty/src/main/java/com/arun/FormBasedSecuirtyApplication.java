package com.arun;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.arun.entity.User;
import com.arun.service.UserService;

@SpringBootApplication
public class FormBasedSecuirtyApplication implements CommandLineRunner {

	private UserService userService;
	
	
	public FormBasedSecuirtyApplication(UserService userService) {
		super();
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(FormBasedSecuirtyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userService.save(new User("admin", "admin", "ROLE_ADMIN"));
		userService.save(new User("user", "user", "ROLE_USER"));	
	}

}
