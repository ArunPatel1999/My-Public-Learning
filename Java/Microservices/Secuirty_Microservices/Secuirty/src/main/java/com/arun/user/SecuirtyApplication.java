package com.arun.user;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecuirtyApplication implements CommandLineRunner {

	private LoginRepository loginRepository;
	
	public SecuirtyApplication(LoginRepository loginRepository) {
		super();
		this.loginRepository = loginRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SecuirtyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		loginRepository.saveAll(Arrays.asList(
				new Login("firstOne","123456"),
				new Login("firstSecond","123456"),
				new Login("firstThird","123456")
				));
	}

}
