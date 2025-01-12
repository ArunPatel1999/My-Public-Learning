package com.chatapp.secuirty;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


@Component
public class AuthenticationFilter extends OncePerRequestFilter {

	private JWTUtil jwtUtil;
	private UserDetailsServiceImpl userDetailsService;
	
	public AuthenticationFilter(JWTUtil jwtUtil, UserDetailsServiceImpl userDetailsService) {
		super();
		this.jwtUtil = jwtUtil;
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = null;
		String username = null;
		String className = null;
		String requestToken = request.getHeader("Authorization");
		try {
			if (requestToken != null && requestToken.startsWith("Bearer ")) {
				token = requestToken.substring(7);
				username = jwtUtil.extractUsername(token);
				className = jwtUtil.extractClass(token);
				
				if (className != null && username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
					userDetailsService.setClassName(className);
				
					UserDetails userDetails = userDetailsService.loadUserByUsername(username);
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
					usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
			}else 
				response.setHeader("error","token is null else token start with \"Bearer \" ");
		} catch (Exception e) {
			response.setHeader("error","token expired");
		}		
		filterChain.doFilter(request, response);
	}

}
