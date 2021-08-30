package com.scm.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.dao.ContactRepository;
import com.scm.dao.UserRepository;
import com.scm.entities.ContactEntity;
import com.scm.entities.UserEntity;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, Principal principal) {
		
		String name = principal.getName();
		System.out.println(name);
		model.addAttribute("title", "User Dashboard");
		return "normal/index";
	}
	
	
	// Show the contact form
	@GetMapping("/add-contact")
	public String addContact(Model model, Principal principal) {
		
		String name = principal.getName();
		System.out.println(name);
		
		model.addAttribute("title", "Add New Contact");
		model.addAttribute("contact", new ContactEntity());
		return "normal/add_contact";
	}
	
	// Add a new contact
	
	@PostMapping("/process-contact")
	public String processContact(@Valid @ModelAttribute("contact") ContactEntity contactEntity, BindingResult result, @RequestParam("lname") String lastName, Model model, Principal principal) {
		if (result.hasErrors()) {
			System.out.println(result);
			model.addAttribute("title", "Add New Contact");
			model.addAttribute("contact", contactEntity);
			return "normal/add_contact";
		}
		
		UserEntity userEntity = userRepository.findByEmail(principal.getName());
		
		contactEntity.setName(contactEntity.getName()+" "+lastName);
		contactEntity.setUser(userEntity);
		
		userEntity.getContacts().add(contactEntity);
		
		//userRepository.save(userEntity);
		return "normal/add_contact";
	}
}
