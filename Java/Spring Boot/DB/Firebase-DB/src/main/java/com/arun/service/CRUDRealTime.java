package com.arun.service;

import java.util.Map;

public interface CRUDRealTime {

	public Object getAll();
	
	public Object getById(String nodename);
	
	public Map<String, Object> saveAndUpdate(String nodename, Map<String, Object> save);
	
	public String deleteById(String nodename);
	
}
