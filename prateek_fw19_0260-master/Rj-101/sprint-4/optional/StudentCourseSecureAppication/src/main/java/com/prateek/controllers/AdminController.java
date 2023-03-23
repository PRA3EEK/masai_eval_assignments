package com.prateek.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prateek.entity.Course;
import com.prateek.entity.Student;
import com.prateek.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	
	@PostMapping("/add/course")
	public ResponseEntity<Course> addCourse(@RequestBody Course course)
	{
		return new ResponseEntity<Course>(adminService.addCourse(course), HttpStatus.OK);
		
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents()
	{
		return new ResponseEntity<List<Student>>(adminService.getAllStudents(), HttpStatus.OK);
	}
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourses()
	{
		return new ResponseEntity<List<Course>>(adminService.getAllCourses(), HttpStatus.OK);
	}
	
	
	
}
