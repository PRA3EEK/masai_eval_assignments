package com.prateek.questions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Question1 {

	@Autowired(required = false)
	List<String> cities;
	@Autowired(required = false)
	List<Student> students;
	
	public void showCities() {
		
		cities.forEach(c -> {
			System.out.println(c);
		});
		
	}
	
	public void showStudents() {
		
		students.forEach(s -> {
			System.out.println(s);
		});
		
	}
	
//	public static void main(String[] args) {
//		
//	 	
//		
//	}
//	
	
}
