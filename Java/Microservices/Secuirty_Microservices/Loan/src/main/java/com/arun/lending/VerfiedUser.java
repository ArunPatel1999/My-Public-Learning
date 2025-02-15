package com.arun.lending;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class VerfiedUser {

	private RestTemplate restTemplate;
	private String	secuirtUrl;
	
	public VerfiedUser(@Value("${secuirt.url}")String secuirtUrl) {
		super();
		this.secuirtUrl = secuirtUrl;
		this.restTemplate = new RestTemplate();
	}
	
	public String checkValideUser(String userName) throws Exception {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", userName);
		HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
		ResponseEntity<String> responseEntity=	restTemplate.exchange(secuirtUrl,HttpMethod.POST, httpEntity, String.class);
		if(responseEntity.getStatusCode().equals(HttpStatus.OK))
			return responseEntity.getBody();
		throw new Exception("Not Valide User");
	}
	
	
}
