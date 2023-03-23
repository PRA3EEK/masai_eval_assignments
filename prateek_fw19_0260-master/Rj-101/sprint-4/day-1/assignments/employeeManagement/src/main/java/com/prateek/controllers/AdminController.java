package com.prateek.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prateek.dto.AdminDTO;
import com.prateek.dto.EmployeeDTO;
import com.prateek.exceptions.AdminException;
import com.prateek.exceptions.DuplicateUsernameException;
import com.prateek.exceptions.EmployeeException;
import com.prateek.exceptions.ReportingManagerException;
import com.prateek.models.Admin;
import com.prateek.models.AdminCurrentSession;
import com.prateek.models.Employee;
import com.prateek.models.EmployeeCurrentSession;
import com.prateek.models.ReportingManager;
import com.prateek.services.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	@PostMapping("/employee/register")
	public ResponseEntity<EmployeeDTO> registerEmployee(@Valid@RequestBody Employee employee, @RequestParam("rmId") Long reportingManagerId, @RequestParam("loggedInAdminId") Long adminId) throws DuplicateUsernameException, AdminException, ReportingManagerException{
		return new ResponseEntity<EmployeeDTO>(adminService.registerEmployee(employee,reportingManagerId, adminId), HttpStatus.OK);
	}
	@PostMapping("/register")
	public ResponseEntity<Admin> adminRegister(@RequestParam("employeeId") Long employeeId, @RequestParam("loggedInAdminId") Long adminId) throws EmployeeException, AdminException
	{
		return new ResponseEntity<Admin>(adminService.adminRegister(employeeId, adminId), HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<AdminCurrentSession> adminLogin(@RequestBody AdminDTO adminDetails) throws AdminException{ 
		return new ResponseEntity<AdminCurrentSession>(adminService.adminLogin(adminDetails), HttpStatus.OK);
	}
	
	@PostMapping("/manager/register")
	public ResponseEntity<ReportingManager> addReportingManager(@RequestParam("employeeId") Long employeeId, @RequestParam("loggedInAdminId") Long adminId) throws EmployeeException, AdminException{
		return new ResponseEntity<ReportingManager>(adminService.registerRepostingManager(employeeId, adminId), HttpStatus.OK);
	}
	
	@GetMapping("/get-employee/{employeeId}")
	public ResponseEntity<Employee> getEmployeeDetails(@PathVariable("employeeId") Long employeeId, @RequestParam("loggedInAdminId") Long adminId) throws AdminException, EmployeeException{
		return new ResponseEntity<Employee>(adminService.getEmployeeDetails(employeeId, adminId), HttpStatus.OK);
	}
	
	@GetMapping("/get-employee-manager/{employeeId}")
	public ResponseEntity<ReportingManager> getReportingMangerFromEmployee(@PathVariable("employeeId") Long employeeId, @RequestParam("loggedInAdminId") Long adminId) throws EmployeeException, AdminException{
		return new ResponseEntity<ReportingManager>(adminService.getReportingManagerOfEmployee(employeeId, adminId), HttpStatus.OK);
	}
	
	@GetMapping("/get-all-reportees/{employeeId}")
	public ResponseEntity<List<Employee>> getAllReportees(@PathVariable("employeeId") Long employeeId, @RequestParam("loggedInAdminId") Long adminId) throws ReportingManagerException, AdminException, EmployeeException
	{
		return new ResponseEntity<List<Employee>>(adminService.getAllEmployeeReportees(employeeId, adminId), HttpStatus.OK);
	}
}
