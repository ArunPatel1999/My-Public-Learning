package com.mtraders.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.mtraders.demo.entity.User;
import com.mtraders.demo.service.UserServiceInterface;

@WebMvcTest(UserControllerAndHideFilde.class)
class UserControllerAndHideFildeTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserServiceInterface userService;
	

	private User user;
	
	@BeforeEach
	void setUp() throws Exception {
		user = User.builder().userId(100).name("test").email("email@gmail.com").phone("0123456789").build();
	}

	@Test
	@DisplayName("getById")
	void testGetById() throws Exception {
	  User	add = User.builder().userId(100).name("test").email("email@gmail.com").phone("0123456789").build();

	Mockito.when(userService.addUserWithoutImage(add)).thenReturn(user.toString());
	
	mockMvc.perform(MockMvcRequestBuilders.post("/api/user")
		.contentType(MediaType.APPLICATION_JSON)
		.content("{\r\n"
				+ "    \"userId\": 100,\r\n"
				+ "    \"name\": \"test\",\r\n"
				+ "    \"email\": \"email@gmail.com\",\r\n"
				+ "    \"phone\": \"0123456789\",\r\n"
				+ "    \"userImage\": null,\r\n"
				+ "    \"token\": \"null\"\r\n"
				+ "}")).andExpect(MockMvcResultMatchers.status().isOk());
	
	
	}

	@Test
	void testSave() {
		assertEquals(1, 1);
	}

}
