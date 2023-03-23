package com.prateek.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.prateek.DTO.EmployeeDTO;
import com.prateek.dao.EmployeeDao;
import com.prateek.entities.Employee;
import com.prateek.exceptions.EmployeeException;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	@Autowired
	private EmployeeDao eDao;
	
	@Override
	public Employee registerEmployee(Employee emp) throws EmployeeException {
		// TODO Auto-generated method stub
		
		Employee e = eDao.save(emp);
		
		return e;
	}

	@Override
	public Employee getEmployeeById(Integer empId) throws EmployeeException {
		// TODO Auto-generated method stub
		Optional<Employee> opt = eDao.findById(empId);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new EmployeeException("No Employee is present with the id "+empId);
	}

	@Override
	public List<Employee> getAllEmployeeDetails() throws EmployeeException {
		// TODO Auto-generated method stub
		List<Employee> employees = eDao.findAll();
		if(employees.size()!=0) {
			return employees;
		}else {
		throw new EmployeeException("No employee is present");	
		}
		
	}

	@Override
	public Employee deleteEmployeeById(Integer empId) throws EmployeeException {
		// TODO Auto-generated method stub
		
		Optional<Employee> opt = eDao.findById(empId);
		
		if(opt.isPresent()) {
			eDao.delete(opt.get());
			return opt.get();
		}
		throw new EmployeeException("No Employee Present with the id "+empId);
	}

	@Override
	public Employee loginEmployee(String email, String password) throws EmployeeException {
		// TODO Auto-generated method stub
		
		List<Employee> employees =  eDao.findAll();
		
		for(Employee e:employees) {
			if(e.getEmail().equals(email) && e.getPassword().equals(password)) {
				return e;
			}
		}
		
      throw new EmployeeException("No employee found with email "+email+" and password "+password);
	}

	@Override
	public List<Employee> getEmployeeDetailsByAddress(String address) throws EmployeeException {
		// TODO Auto-generated method stub
		List<Employee> employees = eDao.findByAddress(address);
		
		if(employees.size()!=0) {
			return employees;
		}
     throw new EmployeeException("No employee is present with the address "+address);
	}

	@Override
	public Employee updateEmployee(Employee emp) throws EmployeeException {
		// TODO Auto-generated method stub
		
		Optional<Employee> opt = eDao.findById(emp.getEmpId());
		
		if(opt.isPresent()) {
			
			eDao.save(emp);
			return emp;
		}
		throw new EmployeeException("No employee is present with id "+emp.getEmpId());
	}

	@Override
	public String getNameAndAddressOfEmployeeById(Integer empId) throws EmployeeException {
		// TODO Auto-generated method stub
//		Optional<Employee> opt = eDao.findById(empId);
//		
//		if(opt.isPresent()) {
//			
//			String res = eDao.getNameAndAddressById(empId);
//			return res;
//		}
//		throw new EmployeeException("No employee present with id "+empId);
		return null;
	}

	@Override
	public List<EmployeeDTO> getNameAddressSalaryOfAllEmployee() throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

}
