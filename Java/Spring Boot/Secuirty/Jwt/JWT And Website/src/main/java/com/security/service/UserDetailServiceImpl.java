package com.security.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.repository.SameFields;
import com.security.repository.TestARepositoy;
import com.security.repository.TestBRepositoy;



@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private TestARepositoy testA;
	
	@Autowired
	private TestBRepositoy testB;
	
	private String classname= null;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Map<String, String> map = new HashMap<>();
		
		SameFields object=null;
		if(classname.equals("TestA"))
			object =	testA.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("USER_NOT_FOUND"));
		else if(classname.equals("TestB"))
			object =	testB.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("USER_NOT_FOUND"));
		
		System.out.println(object.getUsername());
		map.put("username", object.getUsername());
		map.put("password", object.getPassword());
		return UserDetailsImpl.build(map);

	}

	public void setClassName(String classname) {
		this.classname=classname;
	}

}
