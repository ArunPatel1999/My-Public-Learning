package com.arun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class MyOAuthServer extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.passwordEncoder(passwordEncoder).checkTokenAccess("isAuthenticated()"); //permitAll()
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		//localhost:8080/oauth/token?grant_type=password&username=admin1&password=admin1&scope=read BASIC AUTH
		clients.inMemory().withClient("page1")
		.accessTokenValiditySeconds(450000)
		.secret(passwordEncoder.encode("page1")).scopes("read").authorizedGrantTypes("password","refresh_token").and()
		
		.withClient("page3").secret(passwordEncoder.encode("page3")).scopes("read").authorizedGrantTypes("client_credentials").and()
		
		//localhost:8080/oauth/token?grant_type=authorization_code&code=861h8F&scope=read  
		.withClient("page2").secret(passwordEncoder.encode("page2")).scopes("read").authorizedGrantTypes("authorization_code").redirectUris("https://localhost:9090");
		
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager);
	}

	
}
