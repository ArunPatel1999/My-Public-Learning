package com.mtraders.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mtraders.demo.entity.User;

@SpringBootTest
class UserServiceInterfaceTest {

	@Autowired
	private UserServiceInterface userServiceInterface;
	
	@MockBean
	private UserServicerFirebase userServicerFirebase;
	
	@BeforeEach
	void setUp() throws Exception {
		
		User user = User.builder().userId(1).name("ap").email("email@Gmail.com").build();
		
		Mockito.when(userServicerFirebase.getOne(1)).thenReturn(user);
	}

	
	@Test
	@DisplayName("Get By Id 1")
	public void getById() {
			
		User user = userServiceInterface.getOne(1);
		assertEquals("ap", user.getName());
	}
	
}
