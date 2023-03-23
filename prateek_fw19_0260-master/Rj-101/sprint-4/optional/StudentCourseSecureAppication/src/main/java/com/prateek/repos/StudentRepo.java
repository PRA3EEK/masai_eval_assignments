package com.prateek.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prateek.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long>{

	
	public Student findByUsername(String username);
}
