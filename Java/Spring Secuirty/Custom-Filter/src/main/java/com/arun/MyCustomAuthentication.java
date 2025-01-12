package com.arun;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class MyCustomAuthentication extends UsernamePasswordAuthenticationToken{

	private static final long serialVersionUID = 1L;

	public MyCustomAuthentication(Object principal, Object credentials) {
		super(principal, credentials);
	}

	public MyCustomAuthentication(Object principal, Object credentials,
			Collection<? extends GrantedAuthority> authorities) {
		super(principal, credentials, authorities);
	}

}
