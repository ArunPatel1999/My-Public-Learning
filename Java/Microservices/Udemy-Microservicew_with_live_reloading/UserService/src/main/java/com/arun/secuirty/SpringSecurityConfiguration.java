package com.arun.secuirty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.arun.service.UserSerivce;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	private UserSerivce userSerivce;
	private PasswordEncoder encoder;
	private String getwayIp;
	private String loginUrl;
	private String jwtSecret;
	private int exprationDate;
	
	public SpringSecurityConfiguration(UserSerivce userSerivce, PasswordEncoder encoder, 
		@Value("${getwayIp}") String getwayIp, @Value("${loginUrl}") String loginUrl, @Value("${jwt.secret}") String jwtSecret, @Value("${expration.date}") int exprationDate) {
		this.userSerivce = userSerivce;
		this.encoder = encoder;
		this.getwayIp = getwayIp;
		this.loginUrl = loginUrl;
		this.jwtSecret = jwtSecret;
		this.exprationDate = exprationDate;
		System.out.println(exprationDate);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http.authorizeRequests()
		.antMatchers(HttpMethod.POST, "/users","/users/login").permitAll()
		.antMatchers("/users/check", "/users/getByUserId/*").permitAll()
		.antMatchers("/users/**").hasIpAddress(getwayIp);
			//.access("hasIpAddress('10.0.0.0/16') or hasIpAddress('127.0.0.1/32')");
		http.headers().frameOptions().disable();	
		http.addFilter(authencationFilter());
	}

	private AuthencationFilter authencationFilter() throws Exception {
		 AuthencationFilter authencationFilter = new AuthencationFilter(super.authenticationManager(), userSerivce, exprationDate, jwtSecret);
		 authencationFilter.setFilterProcessesUrl(loginUrl);
		 return authencationFilter;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userSerivce).passwordEncoder(encoder);
	}

}
