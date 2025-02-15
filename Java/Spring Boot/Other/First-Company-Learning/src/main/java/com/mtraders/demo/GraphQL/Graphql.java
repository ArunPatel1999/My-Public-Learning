package com.mtraders.demo.GraphQL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.mtraders.demo.entity.User;
import com.mtraders.demo.service.UserServiceInterface;

public class Graphql  implements GraphQLQueryResolver{

	@Autowired
	private UserServiceInterface userSewrvice;
	
	public List<User> getAll(){
		return userSewrvice.getAll();
	}
}
