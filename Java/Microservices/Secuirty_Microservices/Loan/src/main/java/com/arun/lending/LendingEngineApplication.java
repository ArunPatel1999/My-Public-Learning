package com.arun.lending;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.arun.lending.entity.User;
import com.arun.lending.repository.UserRepository;

@SpringBootApplication
public class LendingEngineApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;


	public static void main(String[] args) {
		SpringApplication.run(LendingEngineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.saveAll(Arrays.asList(
				new User("firstOne","first 1","last 1", 21, "PULAMBER"  ),
				new User("firstTwo","first 2","last 2", 26, "IT"  ),
				new User("firstThree","first 3","last 3", 15, "BANKER"  ),
				new User("firstFour","first 4","last 4", 45,  "SELLESMAN"  ),
				new User("firstFifth","first 5","last 5", 85, "BANKER"  )
				));
	}

}
