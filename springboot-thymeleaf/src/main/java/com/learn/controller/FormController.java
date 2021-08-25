package com.learn.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.learn.entities.Login;

@Controller
public class FormController {

	@GetMapping("/form")
	public String showForm(Model model) {
		model.addAttribute("loginData", new Login());
		
		return "form-validation";
	}
	
	@PostMapping("/process")
	public String handleForm(@Valid @ModelAttribute("loginData") Login loginData, BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println(result);
			return "form-validation";
		}
		return "success-form";
	}
}
