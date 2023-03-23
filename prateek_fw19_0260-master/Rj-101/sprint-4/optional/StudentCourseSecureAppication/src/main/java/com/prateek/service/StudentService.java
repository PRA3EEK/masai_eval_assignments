package com.prateek.service;

import com.prateek.entity.Student;
import com.prateek.exceptions.CourseNotFoundException;
import com.prateek.exceptions.DuplicateUsernameException;

public interface StudentService {

	//this method can be accessed by anyone without any authorization
	public Student registerAsStudent(Student student, String courseName) throws CourseNotFoundException, DuplicateUsernameException;
	
	//this method can only be used by registered users
	public boolean loginAsUser(String username, String password);
	
	
}
