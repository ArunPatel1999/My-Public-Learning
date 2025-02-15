package com.mtraders.demo.service;

import java.util.List;

import com.mtraders.demo.entity.User;

public interface UserServiceInterface {

	List<User> getAll();

	User getOne(int id);

	String update(int id, User user);

	String delete(int id);

	String addUserWithoutImage(User user);

}
