package com.mtraders.demo.controller;

import java.io.File;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/image")
public class ImageExtensenChange {

	@GetMapping
	public void test() {
		File directoryPath = new File("C:\\apps\\1633077246594.jpg");
		File rename = new File("C:\\apps\\3_1633077246594.png");
	    directoryPath.renameTo(rename); 
		
	}
}
