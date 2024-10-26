package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;

@Service
public class Services {

	private UserRepository ur;
	
	@Autowired
	private PasswordEncoder ps;

	public Services(UserRepository ur) {
		this.ur=ur;
	}
	public Boolean registerUser(String username , String password) {
		
		Users user =new Users();
		user.setUsername(username);
		user.setPassword(ps.encode(password));
		user.setRole("USER");
		
		Users u=ur.findByUsername(username);
		if(u==null) {
		ur.save(user);
		return false;
		}
		else
		{
			return true;
		}
	}
  
	
}
