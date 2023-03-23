package com.prateek.cabApplication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class MySecurityConfig {

	@Bean
	SecurityFilterChain customeFilterChain(HttpSecurity http) throws Exception
	{
		
		http
		.authorizeHttpRequests(
				(auth) -> 
					auth.requestMatchers("/masaicab/user/findRide", "/masaicab/user/book/{driverId}/{x-cordinate}/{y-cordinate}").authenticated()
					.requestMatchers("/masaicab/driver/register", "/masaicab/user/register", "/masaicab/user/login").permitAll()
					
				
				).csrf().disable().httpBasic();
		return http.build();
	}
	
	@Bean
	PasswordEncoder customePasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
