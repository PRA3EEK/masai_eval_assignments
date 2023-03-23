package com.prateek.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
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
					auth.requestMatchers("/masaimail/mails", "/masaimail/starred", "/masaimail/user", "/masaimail/mail","/masaimail/delete/{mailId}", "/masaimail/starred/{mailId}").authenticated()
					.requestMatchers("/masaimail/register", "/masaimail/login").permitAll()
					
				
				).csrf().disable().httpBasic();
		return http.build();
	}
	
	@Bean
	PasswordEncoder customePasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
