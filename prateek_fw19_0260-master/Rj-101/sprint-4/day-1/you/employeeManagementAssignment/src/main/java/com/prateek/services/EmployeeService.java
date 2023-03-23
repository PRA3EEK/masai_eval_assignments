package com.prateek.services;

import java.util.List;

import com.prateek.exceptions.EmployeeException;
import com.prateek.model.Employee;

public interface EmployeeService {

	
	public Employee addEmployee(Employee employee, String departmentName) throws EmployeeException;
	
	public Employee deleteEmployee(Long employeeId) throws EmployeeException;
	
	public Employee updateEmployeeUsername(Long employeeId, String updatedUsername) throws EmployeeException;
	
	public Employee updateEmployeePassword(Long employeeId, String updatedPassword) throws EmployeeException;
	
	public List<Employee> getAllEmployee();
}
