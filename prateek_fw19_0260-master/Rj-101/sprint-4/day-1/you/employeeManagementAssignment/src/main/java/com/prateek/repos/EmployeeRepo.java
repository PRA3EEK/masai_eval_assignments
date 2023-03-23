package com.prateek.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prateek.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

	public Employee findByUsername(String username);
	
}
