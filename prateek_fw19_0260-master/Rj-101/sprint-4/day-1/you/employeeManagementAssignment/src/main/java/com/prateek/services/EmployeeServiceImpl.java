package com.prateek.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prateek.exceptions.EmployeeException;
import com.prateek.model.Employee;
import com.prateek.repos.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public Employee addEmployee(Employee employee, String departmentName) throws EmployeeException {
		// TODO Auto-generated method stub
		if(employeeRepo.findByUsername(employee.getUsername())==null)
				{ 
			    return employeeRepo.save(employee);
				}
       throw new EmployeeException("Employee is already present with the username "+employee.getUsername());
	}

	@Override
	public Employee deleteEmployee(Long employeeId) throws EmployeeException {
		// TODO Auto-generated method stub
	  if(employeeRepo.findById(employeeId).isPresent())
	  {
		  Employee e = employeeRepo.findById(employeeId).get();
		  employeeRepo.delete(e);
         return e;
	  }
	  throw new EmployeeException("No employee found with the id "+employeeId);
	}

	@Override
	public Employee updateEmployeeUsername(Long employeeId, String updatedUsername) throws EmployeeException {
		// TODO Auto-generated method stub
		if(employeeRepo.findById(employeeId).isPresent())
		{
			Employee e = employeeRepo.findById(employeeId).get();
			e.setUsername(updatedUsername);
			return employeeRepo.save(e);
		}
		throw new EmployeeException("No employee found with the id "+employeeId);
	}

	@Override
	public Employee updateEmployeePassword(Long employeeId, String updatedPassword) throws EmployeeException {
		// TODO Auto-generated method stub
		if(employeeRepo.findById(employeeId).isPresent())
		{
			Employee e = employeeRepo.findById(employeeId).get();
			e.setPassword(updatedPassword);
			return employeeRepo.save(e);
		}
		throw new EmployeeException("No employee found with the id "+employeeId);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}

}
