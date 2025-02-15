package com.arun.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.arun.controller.User;

@Service
public class UserService implements UserDetailsService {

	private List<User> list;
	
	public UserService() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		list = new LinkedList<>();
		list.add(new User("admin1", passwordEncoder.encode("admin1")));
		list.add(new User("admin2", passwordEncoder.encode("admin2")));
		list.add(new User("admin3", passwordEncoder.encode("admin3")));
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Run");
		User user = list.stream().filter(x -> x.getUsername().equals(username)).findAny().orElseThrow(() -> new BadCredentialsException("INVALID"));
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), new ArrayList<>()) ;
	}

	

}
