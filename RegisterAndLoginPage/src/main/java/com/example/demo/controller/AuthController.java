package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.Services;

@Controller
public class AuthController {
    
	@Autowired
	private Services s;
	@GetMapping("/")
	public String hello() {
		return "welcome";
	}
	
	@GetMapping("/register")
	public String regster() {
		return "register";
	}
	@PostMapping("/register")
	public String registerUser(@RequestParam String username , String password) {
		if(s.registerUser(username, password)) {
			return "al";
		}
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
}
