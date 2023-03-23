package com.prateek.services;

import java.util.List;

import com.prateek.DTO.EmployeeDTO;
import com.prateek.entities.Employee;
import com.prateek.exceptions.EmployeeException;

public interface EmployeeService {

	public Employee registerEmployee(Employee emp)throws EmployeeException;
	
	public Employee getEmployeeById(Integer empId)throws EmployeeException;
	
	public List<Employee> getAllEmployeeDetails()throws EmployeeException;
	
	public Employee deleteEmployeeById(Integer empId)throws EmployeeException;
	
	public Employee loginEmployee(String email, String password)throws EmployeeException;
	
	public List<Employee> getEmployeeDetailsByAddress(String address)throws EmployeeException;
	
	public Employee updateEmployee(Employee emp)throws EmployeeException;
	
	public String getNameAndAddressOfEmployeeById(Integer empId)throws EmployeeException;
	
	public List<EmployeeDTO> getNameAddressSalaryOfAllEmployee()throws EmployeeException;
	
}
