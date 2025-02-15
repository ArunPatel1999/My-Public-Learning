package com.mtraders.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtraders.demo.entity.User;

@Service
public class UserServicerFirebase implements UserServiceInterface{

	@Autowired
	private Firebase f;

	private final Logger log = LoggerFactory.getLogger(UserServicerFirebase.class);
	
	 
	public List<User> getAll() {
		try {
			log.info("Get All Running");
			return f.getAll();
		} catch (Exception e) {
			log.error("Get All Failde Beacuse" +e.getLocalizedMessage());
			return null;

		}
	}

	 
	public User getOne(int id) {
		try {

			log.error("Testing ");
			log.info("Get By Id");
			return f.getById(id);
		} catch (Exception e) {
			log.error("Get By Id Beacuse" +e.getLocalizedMessage());
			return null;

		}
	}

	 
	public String update(int id, User user) {
		try {
			return f.saveUserDetails(user);
		} catch (Exception e) {
			return e.getLocalizedMessage();
		}
	}

	 
	public String delete(int id) {
		try {
			return f.delete(id);
		} catch (Exception e) {
			return e.getLocalizedMessage();
		}
	}

	 
	public String addUserWithoutImage(User user) {
		try {
			log.debug("save debug");
			log.trace("save trace");
			return f.saveUserDetails(user);
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			return e.getLocalizedMessage();

		}
	}

}
