package com.arun.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arun.service.impl.CRUDRealTimeService;

@RestController
@RequestMapping("/realtime")
public class RealTimeController {

	@Autowired
	private CRUDRealTimeService crudServcice;
		
	@GetMapping
	public Object getAll(){
		return crudServcice.getAll();
	}
	
	@GetMapping("/{nodename}")
	public Object getById(@PathVariable String nodename){
		return crudServcice.getById(nodename);
	}
	
	@PostMapping("/{nodename}")
	public Map<String, Object> saveOrUpdate(@PathVariable String nodename, @RequestBody Map<String, Object> map)  {
		return crudServcice.saveAndUpdate(nodename, map);
	}
	
	@DeleteMapping("/{nodename}")
	public String deleteData(@PathVariable String nodename) {
		return crudServcice.deleteById(nodename);
	}
	
}
