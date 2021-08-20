package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping(path = "/hello")
	@ResponseBody
	public String handle() {
		return "Welcome to spring boot world!!!";
	}
}
