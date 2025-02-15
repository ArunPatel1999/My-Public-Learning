package com.mtraders.demo.controller;

import java.util.Random;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.server.AbstractReactiveWebServerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/restTemplete")
public class TestingForReadingHtmlPages {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("getMap")
	public String getMap() {

		long a = System.nanoTime();
		startReading();
		long b = System.nanoTime();
		System.out.println(b - a);
		return startReading();
	}	

	private String startReading() {

		String result;

		// String st =
		// restTemplate.getForEntity("http://103.222.20.150/ftpdata/Movies/Hollywood/2019/",
		// String.class).getBody();
		String st = restTemplate.getForEntity("https://www58.zippyshare.com/v/xtmTS3Ti/file.html",String.class).getBody();

		result = st.substring(st.indexOf("https://video"), st.indexOf("\\');\">Download Now"));

		return result;
	}

	
	@GetMapping
	private String one() throws ScriptException  {
		long a =System.nanoTime();
		
		
		String st = restTemplate.getForEntity("https://anonfiles.com/Dc6bt524pb/Ak_Vs_Ak_2020_Hindi_480p_WEB-DL_ESubs_Hdmoviesflix.org_mkv", String.class).getBody();
		String result = st.substring(st.indexOf("btn btn-primary btn-block")+56, st.indexOf("\">                    <img"));
		
		return result;
	}

}
