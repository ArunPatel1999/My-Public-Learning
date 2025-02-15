package com.arun.configration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SpringSecuirtyConfigration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.headers().frameOptions().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests()
			.antMatchers("/user-service/h2-console/**", "/user-service/users/getByUserId/*").permitAll()
			.antMatchers(HttpMethod.POST, "/user-service/users","/user-service/users/login").permitAll()
			.anyRequest().authenticated();
		http.addFilter(new AuthenticationFilter(authenticationManager()));
	}

	
	
}
