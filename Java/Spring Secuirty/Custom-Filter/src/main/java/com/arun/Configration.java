package com.arun;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class Configration extends WebSecurityConfigurerAdapter {

	private CustomeAuthPovider customeAuthPovider;
	private MyCustomFilter myCustomFilter;

	public Configration(CustomeAuthPovider customeAuthPovider, MyCustomFilter myCustomFilter) {
		this.customeAuthPovider = customeAuthPovider;
		this.myCustomFilter = myCustomFilter;
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customeAuthPovider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterAt(myCustomFilter, BasicAuthenticationFilter.class);
		http.authorizeRequests().anyRequest().permitAll();
	}

	
	
	
	
}
