package com.java.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/hello")
	public String helloWorld() {
		String SummonerName = "회로가주거씀돠엉";
		
		RiotKeyVO R = new RiotKeyVO();
		try {
			R.GetID(SummonerName);
			System.out.println("Champion : " +R.SummonerCall());
			System.out.println("Spector : " +R.SpectorCall());
			System.out.println("Match : " +R.MatchCall());
			R.MatchDetail(3206033663l);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "helloWorld";
	}
}
