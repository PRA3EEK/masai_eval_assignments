package com.prateek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prateek.entity.Course;
import com.prateek.entity.Student;
import com.prateek.exceptions.CourseNotFoundException;
import com.prateek.exceptions.DuplicateUsernameException;
import com.prateek.repos.CourseRepo;
import com.prateek.repos.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Override
	public Student registerAsStudent(Student student, String courseName) throws CourseNotFoundException, DuplicateUsernameException {
		// TODO Auto-generated method stub
		
		Student s = studentRepo.findByUsername(student.getUsername());
		if(s == null)
		{
			
			Course c = courseRepo.findByName(courseName);
			if(c!=null)
			{
				student.setCourse(c);
				c.getStudents().add(student);
				return studentRepo.save(student);
			}
			
			throw new CourseNotFoundException("No course found with the name "+courseName);
		}
		throw new DuplicateUsernameException("Username not available");
	}

	@Override
	public boolean loginAsUser(String username, String password) {
		// TODO Auto-generated method stub
		Student s = studentRepo.findByUsername(username);
		if(s != null)
		{
			if(s.getPassword().equals(password))
			{
				return true;
			}
			return false;
		}
		return false;
	}

	
	
}
