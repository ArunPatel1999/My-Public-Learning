package com.arun;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/hii")
	public String hii() {
		return "hii.....";
	}
	
	@GetMapping("/bay")
	public String bay() {
		return "bay.....";
	}
	
	@GetMapping("/openApi/{data}")
	public String openApi(@PathVariable String data) {
		return "AAAA..."+data;
	}
	
	
	@GetMapping("/password") 
	public List<String> getData() {
		List<String> data =	new ArrayList<>();
		data.add(new BCryptPasswordEncoder().encode("password"));
		data.add(new Pbkdf2PasswordEncoder().encode("password"));
		data.add(new SCryptPasswordEncoder().encode("password"));
		
		
		Map<String, PasswordEncoder> map= new HashMap<>();
		map.put("bcrypt", new BCryptPasswordEncoder());
		map.put("pbkd", new Pbkdf2PasswordEncoder());
		map.put("bcrypt", new SCryptPasswordEncoder());
		
		System.out.println(new DelegatingPasswordEncoder("bcrypt", map).encode("password"));
		
		return data;
	}
	
}
