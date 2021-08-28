package com.scm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.dao.UserRepository;
import com.scm.entities.UserEntity;

@Controller
public class HomeController {
	
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Home - Smart Contact Manager");
		return "home";
	}
	
	
	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "About Us");
		return "about";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("title", "Register");
		model.addAttribute("user",new UserEntity());
		return "register";
	}
	
	@PostMapping("/register_user")
	public String registerUser(@Valid @ModelAttribute("user") UserEntity user,BindingResult result,
			@RequestParam(value = "aggrement", defaultValue = "false") boolean agreement, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "register";
		}

		if (agreement == true) {

			user.setImage("default.jpg");
			user.setRoll("ROLE_NORMAL");
			user.setStatus("ACTIVE");
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			
			userRepository.save(user);
			
			
			model.addAttribute("user", new UserEntity());
			model.addAttribute("alertClass", "alert-success");
			model.addAttribute("message", "You have registered successfully. Login now.");

			return "register";
		}

		System.out.println("AGREEMENT  " + agreement);
		System.out.println("USER  " + user);

		model.addAttribute("alertClass", "alert-danger");
		model.addAttribute("message", "You must agree terms & conditions.");

		return "register";
	}
}
