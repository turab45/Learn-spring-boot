package com.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(path = "/about", method = RequestMethod.GET)
	public String about(Model model) {
		
		model.addAttribute("name", "Turab Bajeer");
		
		System.out.println("Going to about page...");
		return "about"; // about.html
	}
}
