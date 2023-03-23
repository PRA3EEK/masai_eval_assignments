package com.prateek.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prateek.models.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

	public Employee findByUsername(String name);
	
}
