package com.prateek.services;

import java.util.List;

import com.prateek.dto.AdminDTO;
import com.prateek.dto.EmployeeDTO;
import com.prateek.exceptions.AdminException;
import com.prateek.exceptions.DuplicateUsernameException;
import com.prateek.exceptions.EmployeeException;
import com.prateek.exceptions.ReportingManagerException;
import com.prateek.models.Admin;
import com.prateek.models.AdminCurrentSession;
import com.prateek.models.Employee;
import com.prateek.models.ReportingManager;

public interface AdminService {

	
	public Admin adminRegister(Long loggedInEmployeeId, Long loggedInAmdinId) throws EmployeeException, AdminException;
	public AdminCurrentSession adminLogin(AdminDTO adminDetails) throws AdminException;
	public EmployeeDTO registerEmployee(Employee employee, Long reportingManagerId, Long loggedInAdminId) throws DuplicateUsernameException, AdminException, ReportingManagerException;
    public ReportingManager registerRepostingManager(Long employeeId, Long loggedInAdminId) throws EmployeeException, AdminException;
    public Employee getEmployeeDetails(Long employeeId, Long loggedInAdminId) throws AdminException, EmployeeException;
    public ReportingManager getReportingManagerOfEmployee(Long employeeId, Long loggedInAdminId) throws EmployeeException, AdminException;
    public List<Employee> getAllEmployeeReportees(Long reportingManagerId, Long loggedInAdminId) throws ReportingManagerException, AdminException, EmployeeException;
    
}
