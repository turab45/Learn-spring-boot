package com.learn.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/iterate")
	public String iterate(Model model) {
		List<String> list = List.of("Turab", "Naresh", "JK", "Ayoob");
		model.addAttribute("names", list);
		return "iterate";
	}
	
	
	@GetMapping("/condition")
	public String condition(Model model) {
		
		List<String> list = List.of("Turab", "Naresh", "JK", "Ayoob");
		
		model.addAttribute("isLoggedIn", true);
		model.addAttribute("gender", "F");
		model.addAttribute("myList", list);
		return "condition";
	}
	
}
