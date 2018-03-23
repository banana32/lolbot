package com.java.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/")
	public String helloWorld() {
		
		return "helloWorld";
	}
}
