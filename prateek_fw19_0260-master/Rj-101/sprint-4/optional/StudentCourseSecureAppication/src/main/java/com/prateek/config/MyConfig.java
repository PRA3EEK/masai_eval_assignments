package com.prateek.config;

import java.net.http.HttpRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MyConfig {

	@Bean
	 SecurityFilterChain securityConfig(HttpSecurity http) throws Exception
	{
		
		http
		   
		  .authorizeHttpRequests(
				  (auth) -> auth.requestMatchers("/admin/add/course", "/admin/students", "/admin/courses").hasAuthority("admin")
				   .requestMatchers("/student/add").permitAll()
				  ).csrf().disable().httpBasic();
	     
		return http.build();
          		
	}
	
//	@Bean
//	 InMemoryUserDetailsManager userDetails()
//	{
//		InMemoryUserDetailsManager userDetails = new InMemoryUserDetailsManager();
//		    UserDetails admin = User.withUsername("admin").password("$2a$12$7ejctJ37EzWAoGQ2K9OgmOanI1/s1h9hV/LFG5Avj.JsYiWL24UqG").authorities("admin").build();
//		    UserDetails user = User.withUsername("user").password("$2a$12$P/XoKj.cLnDOCWJE6UhQm.swu2TIrVaqF8.i8lIHxUIHaW4m7pC8.").authorities("user").build();
//		   userDetails.createUser(user);
//		   userDetails.createUser(admin);
//		    return userDetails;
//	}
	
	@Bean
	 PasswordEncoder encodePassword()
	{
		return new BCryptPasswordEncoder();
	}
	
}
