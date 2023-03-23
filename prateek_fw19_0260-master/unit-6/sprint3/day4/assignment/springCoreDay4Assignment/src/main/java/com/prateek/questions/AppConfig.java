package com.prateek.questions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.prateek")
@PropertySource("t.properties")
public class AppConfig {

	
	@Bean
	public List<String> citiesList() {
		
		List<String>  list = new ArrayList<>();
		
		list.add("Delhi");
		list.add("bangalore");
		list.add("kolkata");
		list.add("goa");
		list.add("gurugram");
		
		return list;
		
	}
	

	
	@Bean
	public List<Student> studentsList() {
		
		List<Student> list = new ArrayList<>();
		
		list.add(new Student(1, "prateek", "delhi"));
		list.add(new Student(2, "pratham", "delhi"));
		list.add(new Student(3, "monty", "delhi"));
		list.add(new Student(4, "aniket", "delhi"));
		list.add(new Student(5, "bhoomika", "delhi"));
		
		return list;
	}
	
//	@Bean
//	public Car travelByCar () {
//		
//		Car c = new Car();
//		
//		return c;
//		
//	}
	
	@Bean
	public Bike travelByBike () {
		
		Bike b = new Bike();
		
		return b;
		
	}
	
	@Bean("v")
	public Car travelByCar () {
		
		Car c = new Car();
		
		return c;
		
	}
}
