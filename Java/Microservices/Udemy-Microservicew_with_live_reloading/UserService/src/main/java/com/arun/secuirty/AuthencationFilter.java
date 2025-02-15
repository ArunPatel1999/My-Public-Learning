package com.arun.secuirty;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.arun.request.Login;
import com.arun.request.UserResponse;
import com.arun.service.UserSerivce;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthencationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;
	private UserSerivce userSerivce;
	private int exprationDate;
	private String jwtSecuirty;
	
	public AuthencationFilter(AuthenticationManager authenticationManager, UserSerivce userSerivce, int exprationDate,
			String jwtSecuirty) {
		super();
		this.authenticationManager = authenticationManager;
		this.userSerivce = userSerivce;
		this.exprationDate = exprationDate;
		this.jwtSecuirty = jwtSecuirty;
	}



	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			Login login = new ObjectMapper().readValue(request.getInputStream(), Login.class);
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword(), Arrays.asList()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	
	@SuppressWarnings("deprecation")
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		String username =	((User) authResult.getPrincipal()).getUsername();
		UserResponse userResponse = userSerivce.getByUsername(username);
		
		Date expiorationDate = new Date();
		expiorationDate.setDate(expiorationDate.getDate()+exprationDate);
		
		String token = Jwts.builder().setSubject(userResponse.getUserId()).setExpiration(expiorationDate)
							.signWith(SignatureAlgorithm.HS512, jwtSecuirty).compact();
		response.addHeader("token", token);
		response.addHeader("userId", userResponse.getUserId());
	}


	
}
