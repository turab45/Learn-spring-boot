package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping(path = "/")
	public String handle() {
		return "home";
	}
	
	@RequestMapping(path = "/contact")
	public String contact() {
		return "contact";
	}
	
	@RequestMapping(path = "/hello")
	@ResponseBody
	public String handleHello() {
		return "This is home page!.";
	}
}
