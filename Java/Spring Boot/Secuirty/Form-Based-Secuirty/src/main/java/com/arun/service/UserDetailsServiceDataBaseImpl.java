package com.arun.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.arun.entity.EntityRepositry;

@Service
public class UserDetailsServiceDataBaseImpl implements UserDetailsService {

	private EntityRepositry entityRepositry;
	
	public UserDetailsServiceDataBaseImpl(EntityRepositry entityRepositry) {
		this.entityRepositry = entityRepositry;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new UserDetailsImpl(entityRepositry.findById(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found")));
	}

}
