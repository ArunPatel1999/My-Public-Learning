package com.arun.configration;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;

public class AuthenticationFilter extends BasicAuthenticationFilter {

	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String bearerToken = request.getHeader("Authorization");
		if(bearerToken == null || !bearerToken.startsWith("Bearer ")) {
			chain.doFilter(request, response);
			return;
		}
		
		UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(request);
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		chain.doFilter(request, response);
	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if(bearerToken == null)
			return null;
		String token = bearerToken.substring(7);
		String userId = Jwts.parser().setSigningKey("BFGghdach#%^cvhvhnBV").parseClaimsJws(token).getBody().getSubject();
		if(userId == null)
			return null;
		return new UsernamePasswordAuthenticationToken(userId, null, Arrays.asList());
	}

	

}
