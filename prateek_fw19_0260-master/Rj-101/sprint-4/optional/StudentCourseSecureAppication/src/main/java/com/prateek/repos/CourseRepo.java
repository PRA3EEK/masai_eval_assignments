package com.prateek.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prateek.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Long>{

	public Course findByName(String name);
	
}
