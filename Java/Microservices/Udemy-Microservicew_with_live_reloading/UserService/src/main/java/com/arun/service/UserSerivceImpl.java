package com.arun.service;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.arun.entity.AlbumEntity;
import com.arun.entity.User;
import com.arun.entity.UserRepository;
import com.arun.request.UserResponse;
import com.arun.utility.Utility;

@Service
public class UserSerivceImpl implements UserSerivce {

	private UserRepository userRepository;
	private ModelMapper modelMapper;
	private PasswordEncoder passwordEncoder;
	private RestTemplate restTemplate;
	private FeignClientAlbemApiCall feignClientAlbemApiCall;

	public UserSerivceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder,
			RestTemplate restTemplate, FeignClientAlbemApiCall feignClientAlbemApiCall) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
		this.passwordEncoder = passwordEncoder;
		this.restTemplate = restTemplate;
		this.feignClientAlbemApiCall = feignClientAlbemApiCall;
	}

	@Override
	public UserResponse save(UserResponse response) {
		response.setUserId(Utility.getId());
		User user = modelMapper.map(response, User.class);
		user.setEncriptedPassword(passwordEncoder.encode(response.getNormalPassword()));
		userRepository.save(user);
		response.setNormalPassword(null);
		return response;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("username not found"));
		return new org.springframework.security.core.userdetails.User(username, user.getEncriptedPassword(), Arrays.asList());
	}

	@Override
	public UserResponse getByUsername(String username) {
		User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("username not found"));
		return modelMapper.map(user, UserResponse.class);
	}

	@Override
	public Map<String, Object> getByUserId(String userId) {
		Map<String, Object> data = new LinkedHashMap<>();
		data.put("user", getByUsername(userId));
//		data.put("restTemplete", restTemplate.exchange("http://ALBUMS-WS//users/"+userId+"/albums", HttpMethod.GET,null, new ParameterizedTypeReference<List<AlbumEntity>>(){}).getBody() );
		data.put("feign", feignClientAlbemApiCall.getAll(userId));
		return data;
	}

}
