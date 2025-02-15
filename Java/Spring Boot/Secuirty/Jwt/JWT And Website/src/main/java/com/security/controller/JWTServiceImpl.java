package com.security.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.config.JWTUtil;
import com.security.exception.KeeboAppException;
import com.security.repository.TestA;
import com.security.repository.TestARepositoy;
import com.security.repository.TestB;
import com.security.repository.TestBRepositoy;
import com.security.repository.UserNameAndPassword;
import com.security.service.UserDetailServiceImpl;

@Service
public class JWTServiceImpl implements JWTService {

	@Autowired
	UserDetailServiceImpl userDetailsService;

	@Autowired
	JWTUtil jwtUtil;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	TestARepositoy userRepository;
	
	@Autowired
	private TestBRepositoy testBRepositoy;
	

	@Autowired
	PasswordEncoder passwordEncoder;


	@Override
	public Map<String, String> getToken(UserNameAndPassword userNameAndPassword) throws KeeboAppException {
		userDetailsService.setClassName(userNameAndPassword.getClassName());
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					userNameAndPassword.getUsername(), userNameAndPassword.getPassword()));
		} catch (Exception e) {
			throw new KeeboAppException(401,""+e.toString());
		} 

		UserDetails userDetails = userDetailsService.loadUserByUsername(userNameAndPassword.getUsername());
		System.out.println(userDetails.getPassword());
		Map<String, String> map = new HashMap<String, String>(1);
		map.put("token", jwtUtil.generateToken(userDetails));
		return map;
	}

	int id =3;
	@Override
	public String registerUser(TestA user) throws KeeboAppException {
		
		if (userRepository.existsByNumber(user.getNumber()))
			throw new KeeboAppException(409, "NUMBER_ALREADY_EXISTS");
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		user.setId(id++);
		userRepository.save(user);
		return "SUCCESS";
	}

	@Override
	public String registerUser1(TestB user) throws KeeboAppException {
		if (testBRepositoy.existsByNumber(user.getNumber()))
			throw new KeeboAppException(409, "NUMBER_ALREADY_EXISTS");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setId(id++);
		testBRepositoy.save(user);
		return "SUCCESS";
	}

}
