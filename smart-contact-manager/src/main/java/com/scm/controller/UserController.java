package com.scm.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.scm.dao.ContactRepository;
import com.scm.dao.UserRepository;
import com.scm.entities.ContactEntity;
import com.scm.entities.UserEntity;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ContactRepository contactRepository;
	
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
	public String processContact(@Valid @ModelAttribute("contact") ContactEntity contactEntity, BindingResult result, @RequestParam("lname") String lastName,@RequestParam("profileImg") MultipartFile file, Model model, Principal principal) {
		if (result.hasErrors()) {
			System.out.println(result);
			model.addAttribute("title", "Add New Contact");
			model.addAttribute("contact", contactEntity);
			return "normal/add_contact";
		}
		try {
			
			if (!file.isEmpty()) {
				contactEntity.setImage(file.getOriginalFilename());
				
				File saveFile = new ClassPathResource("static/img").getFile();
				
				
				Path path = Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());
				
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				
			}else {
				contactEntity.setImage("default.jpg");
			}
			
			
			
			UserEntity userEntity = userRepository.findByEmail(principal.getName());
			
			contactEntity.setName(contactEntity.getName()+" "+lastName);
			contactEntity.setUser(userEntity);
			
			contactRepository.save(contactEntity);
			
			model.addAttribute("alertClass", "alert-success");
			model.addAttribute("message", "Contact has been added successfully.");
			model.addAttribute("contact", new ContactEntity());
			
		} catch (Exception e) {
			model.addAttribute("alertClass", "alert-danger");
			model.addAttribute("message", "Something went wrong.");
		}
		return "normal/add_contact";
	}
	
	
	
	@GetMapping("/contacts")
	public String viewContacts(Model model, Principal principal) {
		
		model.addAttribute("title", "User Contacts");
		UserEntity userEntity = userRepository.findByEmail(principal.getName());
		List<ContactEntity> userContacts = contactRepository.findContactsByUser(userEntity.getId());
		
		model.addAttribute("contacts", userContacts);
		return "normal/view_contacts";
	}
	
	@GetMapping("/contact/{id}")
	public String viewSingleContact(@PathVariable("id") Integer id, Model model) {
		ContactEntity contactEntity = contactRepository.findById(id).get();
		
		model.addAttribute("title", contactEntity.getName());
		model.addAttribute("contact", contactEntity);
		return "normal/view_single_contact";
	}
	
	
	@GetMapping("/contact/update/{id}")
	public String updateContact(@PathVariable("id") Integer id, Model model) {
		ContactEntity contactEntity = contactRepository.findById(id).get();
		
		model.addAttribute("title", contactEntity.getName());
		model.addAttribute("contact", contactEntity);
		if (contactEntity.getName().split(" ").length > 1) {
			model.addAttribute("fname", contactEntity.getName().split(" ")[0]);
			model.addAttribute("lname", contactEntity.getName().split(" ")[1]);
		}
		return "normal/update_contact";
	}
}
