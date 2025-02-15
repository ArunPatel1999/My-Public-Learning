package com.arun.service;

import java.util.Map;
import java.util.concurrent.ExecutionException;

public interface CRUDFirestore {

	public Object getAll() throws InterruptedException, ExecutionException;
	
	public Object getById(int id) throws InterruptedException, ExecutionException ;

	public String saveUserDetails(Map<String, Object> map) throws InterruptedException, ExecutionException;
	
	public String delete(int id) throws InterruptedException, ExecutionException;
}
