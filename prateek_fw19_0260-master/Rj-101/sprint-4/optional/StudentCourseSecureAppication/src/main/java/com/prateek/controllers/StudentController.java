package com.prateek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prateek.entity.Student;
import com.prateek.exceptions.CourseNotFoundException;
import com.prateek.exceptions.DuplicateUsernameException;
import com.prateek.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@PostMapping("/add")
	public ResponseEntity<Student> registerStudent(@RequestBody Student student,@RequestParam("courseName") String course) throws CourseNotFoundException, DuplicateUsernameException
	{
		return new ResponseEntity<Student>(studentService.registerAsStudent(student, course), HttpStatus.OK);
	}
	
}
