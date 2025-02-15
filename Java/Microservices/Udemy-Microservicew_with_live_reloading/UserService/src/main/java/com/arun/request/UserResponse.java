package com.arun.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserResponse {
	
	private String userId;
	
	@NotNull(message = "name should not be null")
	@Size(min = 2, message = "name")
	private String name;
	
	@NotNull(message = "username should not be null")
	@Size(min = 2, message = "username")
	private String username;
	
	
	@NotNull(message = "password should not be null")
	@Size(min = 8, max = 16)
	private String normalPassword;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNormalPassword() {
		return normalPassword;
	}

	public void setNormalPassword(String normalPassword) {
		this.normalPassword = normalPassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
