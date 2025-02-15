package com.arun;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomeAuthPovider implements AuthenticationProvider {

	private String secuirtKey;
	
	public CustomeAuthPovider(@Value("${my.key}") String secuirtKey) {
		super();
		this.secuirtKey = secuirtKey;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		if(secuirtKey.equals(authentication.getName()))
			return new MyCustomAuthentication(null, null, null);
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return MyCustomAuthentication.class.equals(authentication);
	}

}
