package com.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.entities.UserEntity;

@Controller
public class UserController {

	@PostMapping("/register_user")
	public String registerUser(@ModelAttribute("user") UserEntity user, @RequestParam(value = "aggrement", defaultValue = "false") boolean agreement, Model model) {
		
		if (agreement == true) {
			
			model.addAttribute("alertClass", "alert-success");
			model.addAttribute("message", "You have registered successfully. Login now.");
			
			return "register";
		}
		System.out.println("AGREEMENT  "+agreement);
		System.out.println("USER  "+user);
		
		
		model.addAttribute("alertClass", "alert-danger");
		model.addAttribute("message", "You must agree terms & conditions.");
		
		return "register";
	}
}
