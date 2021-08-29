package com.scm.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.entities.ContactEntity;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, Principal principal) {
		
		String name = principal.getName();
		System.out.println(name);
		model.addAttribute("title", "User Dashboard");
		return "normal/index";
	}
	
	
	@GetMapping("/add-contact")
	public String addContact(Model model, Principal principal) {
		
		String name = principal.getName();
		System.out.println(name);
		
		model.addAttribute("title", "Add New Contact");
		model.addAttribute("contact", new ContactEntity());
		return "normal/add_contact";
	}
	
	@PostMapping("/process-contact")
	public String processContact(@Valid @ModelAttribute("contact") ContactEntity contactEntity, BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println(result);
			model.addAttribute("title", "Add New Contact");
			model.addAttribute("contact", contactEntity);
			return "normal/add_contact";
		}
		return "";
	}
}
