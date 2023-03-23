package com.prateek.controller;

import java.util.List;

//import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prateek.entities.Employee;
import com.prateek.exceptions.EmployeeException;
import com.prateek.services.EmployeeServiceImpl;

@RestController
@RequestMapping("/employeeApp")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl esi;
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee empl) throws EmployeeException{
		
		Employee e = esi.registerEmployee(empl);
		
		
		return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}

	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer empId) throws EmployeeException{
	
		Employee resE = esi.getEmployeeById(empId);
		
		
		return new ResponseEntity<Employee>(resE, HttpStatus.OK);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getListOfEmployees() throws EmployeeException{
	
		List<Employee> employees = esi.getAllEmployeeDetails();
		
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Employee> deleteEmployeeById(@PathVariable ("id") Integer id) throws EmployeeException{
		
		return new ResponseEntity<Employee>(esi.deleteEmployeeById(id), HttpStatus.OK);
		
	}
	
	@GetMapping("/employee")
	public ResponseEntity<Employee> loginIN(@RequestBody Employee e) throws EmployeeException{
		
	return new ResponseEntity<Employee>(esi.loginEmployee(e.getEmail(), e.getPassword()), HttpStatus.OK);
		
	}
	
	@GetMapping("/employeeByAddress")
	public ResponseEntity<List<Employee>> findEmployeesByAddress(@RequestParam("add") String address) throws EmployeeException{
		
		return new ResponseEntity<List<Employee>> (esi.getEmployeeDetailsByAddress(address), HttpStatus.OK);
		
	}
	
	@PutMapping("/employee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee e) throws EmployeeException{
		
		return new ResponseEntity<Employee>(esi.updateEmployee(e), HttpStatus.OK);
	}
	
	
}
