package com.prateek.service;

import java.util.List;

import com.prateek.entity.Course;
import com.prateek.entity.Student;

public interface AdminService {

	//this method can only be used by the admin;
	public Course addCourse(Course course);
	
	//this method can only be accessed by the admin
	public List<Student> getAllStudents(); 
	
	
	public List<Course> getAllCourses();
	
}
