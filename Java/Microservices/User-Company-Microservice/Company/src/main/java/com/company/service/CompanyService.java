package com.company.service;

import java.util.List;

import com.company.entity.Company;

public interface CompanyService {

	public List<Company> getAll();
	
	public Company getById(int id) throws Exception;
	
	public Company save(Company user);
	
	public Company edit(int id, Company editCompany) throws Exception;
	
	public Company addUser(int id, int userId) throws Exception;
	
	public Company removeUser(int id, int userId)  throws Exception;
	
	public String deleteCompany(int id);
}
