package com.java.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/hello")
	public String helloWorld() {
		RiotKeyVO R = new RiotKeyVO();
		try {
			R.GetID();
			System.out.println("Champion : " +R.ChampionCall());
			System.out.println("Spector : " +R.SpectorCall());
			System.out.println("Match : " +R.MatchCall());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "helloWorld";
	}
}
