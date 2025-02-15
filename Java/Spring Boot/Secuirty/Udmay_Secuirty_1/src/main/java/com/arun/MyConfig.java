package com.arun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class MyConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private MyAuthenticationProvider myAuthenticationProvider;

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		InMemoryUserDetailsManager users= new InMemoryUserDetailsManager();
//		users.createUser(User.withUsername("admin1").password(passwordEncoder.encode("admin1")).authorities("read").build());
//		users.createUser(User.withUsername("admin2").password(passwordEncoder.encode("admin2")).authorities("read").build());
//		users.createUser(User.withUsername("admin3").password(passwordEncoder.encode("admin3")).authorities("read").build());
//		
//		auth.userDetailsService(users);
//	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(myAuthenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		http.authorizeRequests().mvcMatchers(HttpMethod.GET, "/openApi/{data}").permitAll().anyRequest().authenticated();
		http.addFilterBefore(new MyFilter(), BasicAuthenticationFilter.class);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
