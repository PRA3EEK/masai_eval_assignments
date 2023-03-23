package com.prateek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prateek.entity.Course;
import com.prateek.entity.Student;
import com.prateek.repos.CourseRepo;
import com.prateek.repos.StudentRepo;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private CourseRepo courseRepo;
	@Autowired
	private StudentRepo studentRepo;
	
	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		return courseRepo.save(course);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return courseRepo.findAll();
	}

}
