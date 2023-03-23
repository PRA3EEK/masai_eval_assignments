package com.prateek.configurations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.prateek.beans.Course;
import com.prateek.beans.Student;

@Configuration
@ComponentScan("com.prateek")
@PropertySource("p1.properties")
public class AppConfig {
  
	@Bean
	public Map<Student, Course> returnMap () {
		
		Map<Student, Course> map = new HashMap<>();
		
		map.put(new Student(1, "prateek chauhan", "Delhi", "prateek@gmail.com", 500), new Course(1, "Java", 3, 55000));
		map.put(new Student(2, "pratham chauhan", "Delhi", "pratham@gmail.com", 550), new Course(2, "Spring", 2, 40000));
		map.put(new Student(3, "Aniket rawal", "Delhi", "aniket@gmail.com", 400), new Course(1, "Java", 3, 55000));
		
		return map;
		
	}
	
	@Bean
	public List<Student> returnList(){
		
		List<Student> list = new ArrayList<>();
		
		list.add(new Student(1, "prateek chauhan", "Delhi", "prateek@gmail.com", 500));
		list.add(new Student(2, "pratham chauhan", "Delhi", "pratham@gmail.com", 550));
		list.add(new Student(3, "Aniket rawal", "Delhi", "aniket@gmail.com", 400));
		list.add(new Student(4, "Shobbhit", "Delhi", "shobhhit@gmail.com", 450));
		list.add(new Student(5, "Sandeep", "Delhi", "sandeep@gmail.com", 300));
		
		return list;
		
		}
	
}
