package com.chatapp.secuirty;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.chatapp.entity.embeddedentity.UsernameAndPasswordInterface;
import com.chatapp.exception.ChatAppException;
import com.chatapp.repository.AdminRepository;
import com.chatapp.repository.UserRepository;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserRepository userRepository;
	private AdminRepository adminRepository;
	
	public UserDetailsServiceImpl(UserRepository userRepository, AdminRepository adminRepository) {
		super();
		this.userRepository = userRepository;
		this.adminRepository = adminRepository;
	}

	private String classname= null;

	@Override
	public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
		Map<String, String> map = new HashMap<>();

		UsernameAndPasswordInterface data=null;
		try {
		if(classname.equals("USER"))
			data =	userRepository.findByNumberOrUsernameIgnoreCase(username,username).orElseThrow(() -> new ChatAppException("Username not found"));
		else if(classname.equals("ADMIN"))
			data =	adminRepository.findById(username).orElseThrow(() -> new ChatAppException("Admin Not Found"));
		else
			throw new ChatAppException("Class Name Not Good");
		}catch (Exception e) {
			throw new InternalAuthenticationServiceException(e.getLocalizedMessage());
		}
		map.put("username", data.getUsername());
		map.put("password", data.getPassword());
		map.put("classname", classname);
		return UserDetailsImpl.build(map);

	}

	public void setClassName(String classname) {
		this.classname=classname;
	}

}
