package com.security.controller;

import java.util.Map;

import com.security.exception.KeeboAppException;
import com.security.repository.TestA;
import com.security.repository.TestB;
import com.security.repository.UserNameAndPassword;


public interface JWTService {

	Map<String, String> getToken(UserNameAndPassword userNameAndPassword) throws KeeboAppException ;

	String registerUser(TestA user) throws KeeboAppException ;

	String registerUser1(TestB user) throws KeeboAppException;

}
