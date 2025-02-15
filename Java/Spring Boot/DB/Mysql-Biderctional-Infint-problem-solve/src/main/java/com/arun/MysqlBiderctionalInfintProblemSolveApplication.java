package com.arun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.arun.entity.Address;
import com.arun.entity.AddressRepository;
import com.arun.entity.User;
import com.arun.entity.UserRepository;

@SpringBootApplication
@RestController
public class MysqlBiderctionalInfintProblemSolveApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MysqlBiderctionalInfintProblemSolveApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Address address = new Address();
		address.setAddress("testsvgmn cc");
		address.setPincode(465321);
		
		User user = new User();
		user.setName("Test1");
		user.setAge(24);
		user.setAddress(address);
		
		address.setUser(user);
		
		userRepository.save(user);
		
		
		Address address2 = new Address();
		address2.setAddress("sdgh");
		addressRepository.save(address2);
		
		
		User user1 = new User();
		user1.setName("sddj");
		userRepository.save(user1);
	}
	
	@GetMapping("/getUserById/{id}")
	public User getUserById(@PathVariable int id ) {
		return userRepository.findById(id).orElse(new User());
	}
	
	@GetMapping("/getAddress/{id}")
	public Address getAddress(@PathVariable int id ) {
		return addressRepository.findById(id).orElse(new Address());
	}
}
