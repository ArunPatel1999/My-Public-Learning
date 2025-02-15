package com.arun;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecirtyConfigration {

	@Bean
	public UserDetailsService userDetailsService() {
		  InMemoryUserDetailsManager in = new InMemoryUserDetailsManager();
		  in.createUser(User.withUsername("test1").password(passwordEncoder().encode("test1")).authorities("read").build());
		  return in;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
}
