package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.service.CustomuserDetail;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
	  CustomuserDetail cu;

	public SecurityConfig(CustomuserDetail cu) {
		this.cu = cu;
	}
	
	@Bean
	public SecurityFilterChain se(HttpSecurity http) throws Exception {

		http.csrf(csrf->csrf
				.disable())
		        .authorizeHttpRequests(request->request
		        		.requestMatchers("/register" , "/login" , "/css/**" , "/js/**s")
		        		.permitAll().anyRequest().authenticated()
		 
		        		)
		        
		        .oauth2Login(oauth->oauth
		        		.loginPage("/login")
		        		)
		        
		        
		        .formLogin(form->form
		        .loginPage("/login")		
		        .loginProcessingUrl("/login").defaultSuccessUrl("/welcome" , false).permitAll())
		        .logout(logout->logout.logoutSuccessUrl("/login").permitAll())
		        .userDetailsService(cu)
		        ;
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder p() {
		return new BCryptPasswordEncoder();
	}
}
