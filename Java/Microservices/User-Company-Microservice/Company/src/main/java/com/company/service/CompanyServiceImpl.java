package com.company.service;

import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.company.entity.Company;
import com.company.entity.CompanyRepository;
import com.company.entity.User;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<Company> getAll() {
		return repository.findAll();
	}

	@Override
	public Company getById(int id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("Company Not Found"));
	}

	@Override
	public Company save(Company user) {
		user.setId(restTemplate.getForEntity("http://PRIMERY-KEY/api/primery/COMPANYTABLE", Integer.class).getBody());
		user.setEmployes(new LinkedHashSet<>());
		return repository.save(user);
	}

	@Override
	public Company edit(int id, Company editUser) throws Exception {
		getById(id);
		editUser.setId(id);
		return repository.save(editUser);
	}

	@Override
	public String deleteCompany(int id) {
		repository.deleteById(id);
		return "success";
	}

	@Override
	public Company addUser(int id, int userId) throws Exception {
		Company company = getById(id);
		company.getEmployes().add(restTemplate.getForEntity("http://USER/api/user/"+userId, User.class).getBody());
		return repository.save(company);
	}

	@Override
	public Company removeUser(int id, int userId) throws Exception {
		Company company = getById(id);
		company.getEmployes().removeIf(x -> x.getId() == userId);
		return repository.save(company);
	}

}
