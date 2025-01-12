package com.arun;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.stereotype.Component;

@Component
public class MyCustomeCSRF implements CsrfTokenRepository {

	
	@Override
	public CsrfToken generateToken(HttpServletRequest request) {
		return  new DefaultCsrfToken("X-CSRF-TOKEN", "_arun", "123456789ABC");
	}

	@Override
	public void saveToken(CsrfToken token, HttpServletRequest request, HttpServletResponse response) {
		
	}

	@Override
	public CsrfToken loadToken(HttpServletRequest request) {
		return null;
	}

}
