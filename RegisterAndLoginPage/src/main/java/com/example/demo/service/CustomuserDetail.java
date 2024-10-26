package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;

@Service
public class CustomuserDetail implements UserDetailsService{

	@Autowired
	private UserRepository ur;
	
	public CustomuserDetail(UserRepository ur) {

		this.ur = ur;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user= ur.findByUsername(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("User not found with given username");
		}
		return User.withUsername(user.getUsername()).password(user.getPassword()).roles(user.getRole()).build() ;
	}

}
