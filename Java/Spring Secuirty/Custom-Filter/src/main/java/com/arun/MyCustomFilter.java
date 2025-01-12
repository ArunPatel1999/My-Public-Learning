package com.arun;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class MyCustomFilter extends OncePerRequestFilter {

	@Autowired
	private AuthenticationManager authenticationException;


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		MyCustomAuthentication obj = new MyCustomAuthentication(request.getHeader("key"), null);
		
		try {
		Authentication authentication = authenticationException.authenticate(obj);
		
		if(authentication.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(authentication);
			filterChain.doFilter(request, response);
		} else
			response.sendError(403, "Key Not GOOD");
		}catch (Exception e) {
			response.sendError(403, "Key Not Found");
		}
	}

}
