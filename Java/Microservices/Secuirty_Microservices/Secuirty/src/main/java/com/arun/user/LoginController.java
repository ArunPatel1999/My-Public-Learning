package com.arun.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arun.user.configaration.MeassageSendEvent;

@RestController
@RequestMapping("/login")
public class LoginController {

	private LoginRepository loginRepository;
	private MeassageSendEvent meassageSendEvent;
	
	public LoginController(LoginRepository loginRepository, MeassageSendEvent meassageSendEvent) {
		super();
		this.loginRepository = loginRepository;
		this.meassageSendEvent = meassageSendEvent;
	}

	@GetMapping
	public String checkValid(@RequestHeader("Authorization") String username) throws Exception {
		return loginRepository.findById(username).orElseThrow(() -> new Exception("User Is Not Valid")).getUsername();
	}
	
	@PostMapping
	public String addNewUser(@RequestBody UserDTO user) {
		loginRepository.save(new Login(user.getUsername(), user.getPassword()));
		meassageSendEvent.sendMessage(user);
		return user.getUsername();
	}
	
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> exceptionHandler(Exception e) {
		return ResponseEntity.status(404).body(e.getMessage());
	}
}
