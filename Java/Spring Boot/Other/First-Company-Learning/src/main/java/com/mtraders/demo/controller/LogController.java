package com.mtraders.demo.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/log")
public class LogController {

	List<String> list = null;

	private BufferedReader getBufferedReader() throws FileNotFoundException {
		FileInputStream fstream = new FileInputStream("C:/Users/Account/Desktop/common-apis.log");
		return new BufferedReader(new InputStreamReader(fstream));
	}

	@GetMapping
	public List<String> getAll() {
		try {
				list = new LinkedList<>();
				BufferedReader br = getBufferedReader();
				String line;
				while ((line = br.readLine()) != null) {
					list.add(line);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return list;
	}

	@GetMapping("/{startDate}/{endDate}")
	public List<String> getManyDate(@PathVariable String startDate, @PathVariable String endDate) {

		try {
			list = new LinkedList<>();
			BufferedReader br = getBufferedReader();
			String line;
			boolean status = false;
			while ((line = br.readLine()) != null) {
				if (line.startsWith(startDate))
					status = true;
				else if (line.startsWith(endDate))
					break;
				if (status)
					list.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
