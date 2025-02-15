package com.mtraders.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/upload")
public class Uploadonly {

	final String PATH = "c:/apps/testingCompresser/";
	
	@PostMapping
	public String setUpload(@RequestParam("file") MultipartFile file) throws IOException {
		String text = " "+(file.getSize()/1000000);
		file.transferTo(new File(PATH+file.getOriginalFilename()));
		return text;
	}
	
	@GetMapping("/{filename}")
	public String getUpload(HttpServletResponse  response , @PathVariable String filename ) throws IOException {
		try (InputStream is = new FileInputStream(new File(PATH+filename))) {
			StreamUtils.copy(is, response.getOutputStream());
			return "success";
		} catch (FileNotFoundException fileNotFoundException) {
			return "faild";
		}
	}
}
