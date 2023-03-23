package com.prateek.test;

import java.util.List;

public interface EmployeeService {

	public Employee addEmployee(Employee employee) throws EmployeeException;
	
	public boolean deleteEmployee(int employee) throws EmployeeException;
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployee(int emplId) throws EmployeeException;
}
