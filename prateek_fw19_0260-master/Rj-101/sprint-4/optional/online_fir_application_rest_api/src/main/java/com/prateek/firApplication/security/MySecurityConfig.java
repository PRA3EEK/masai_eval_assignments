package com.prateek.firApplication.security;

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
					auth.requestMatchers("/masaifir/user/fir", "/masaifir/user/fir/{firId}").authenticated()
					.requestMatchers("/masaifir/user/register", "/masaifir/user/login").permitAll()
					
				
				).csrf().disable().httpBasic();
		return http.build();
	}
	
	@Bean
	PasswordEncoder customePasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
