package com.arun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

	@GetMapping("/singup")
	public String getSingup() {
		return "singup";
	}
	

}
