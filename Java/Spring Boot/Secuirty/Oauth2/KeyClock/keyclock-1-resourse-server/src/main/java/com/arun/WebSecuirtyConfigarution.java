package com.arun;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@EnableGlobalMethodSecurity(securedEnabled = true , prePostEnabled = true)
@EnableWebSecurity
public class WebSecuirtyConfigarution extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		JwtAuthenticationConverter jwtConvater= new JwtAuthenticationConverter();
		jwtConvater.setJwtGrantedAuthoritiesConverter(new JwtGetRole());
		
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/data").permitAll()
		.antMatchers(HttpMethod.GET, "/jwt")
			.hasRole("devloper").anyRequest().authenticated()
			.and().oauth2ResourceServer().jwt()
			.jwtAuthenticationConverter(jwtConvater);
	}

	
}
