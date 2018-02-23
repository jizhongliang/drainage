package com.py.app.account.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@Value("${server.port}")
	String port;
	
	@RequestMapping("/hello")
	public String hellow() {
		String getConf="hello, sping Cloud!" + port;
		return getConf;
	}

}
