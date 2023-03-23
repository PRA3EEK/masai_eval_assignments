package com.prateek.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.prateek.repos.AdminCurrentSessionRepo;
import com.prateek.repos.AdminRepo;
import com.prateek.repos.EmployeeRepo;
import com.prateek.repos.ReportingManagerRepo;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private EmployeeRepo employeeRepo;
	@Autowired 
	private AdminRepo adminRepo;
	@Autowired
	private AdminCurrentSessionRepo adminCurrentSessionRepo;
	@Autowired
	private ReportingManagerRepo rmRepo;
	@Override
	public Admin adminRegister(Long employeeId, Long loggedInAdminId) throws EmployeeException, AdminException {
		// TODO Auto-generated method stub
		if(adminCurrentSessionRepo.findById(loggedInAdminId).isPresent())
        {
		Optional<Employee> oe = employeeRepo.findById(employeeId);
		if(oe.isPresent())
		{
			Employee e = oe.get();
			Admin admin = new Admin();
			admin.setEmployee(e);
			return adminRepo.save(admin);
		}
		
		throw new EmployeeException("Invalid employeeId");
        }
		throw new AdminException("Admin is not logged in");
	}

	@Override
	public AdminCurrentSession adminLogin(AdminDTO adminDetails) throws AdminException {
		// TODO Auto-generated method stub
		Optional<Admin> oa = adminRepo.findById(adminDetails.getAdminId());
		if(oa.isPresent())
		{
			Admin a = oa.get();
			if(a.getEmployee().getUsername().equals(adminDetails.getUsername()))
			{
				if(a.getEmployee().getPassword().equals(adminDetails.getPassword()))
				{
					AdminCurrentSession currentSession = new AdminCurrentSession(adminDetails.getAdminId(), LocalDateTime.now(), UUID.randomUUID().toString());
					return adminCurrentSessionRepo.save(currentSession);
				}
				throw new AdminException("Wrong password");
			}
			throw new AdminException("Wrong Username");
		}
		throw new AdminException("Invalid admin");
	}

	public EmployeeDTO registerEmployee(Employee employee, Long reportingManagerId, Long loggedInAdminId) throws DuplicateUsernameException, AdminException, ReportingManagerException{
		
		if(adminCurrentSessionRepo.findById(loggedInAdminId).isPresent())
              {
	           if(employeeRepo.findByUsername(employee.getUsername())==null)
	           {
	        	   
	        	    if(rmRepo.findById(reportingManagerId).isPresent())
	        	    {	        	    	
	        	    	ReportingManager rm = rmRepo.findById(reportingManagerId).get();
	        	    	if(employee.getRole().equalsIgnoreCase("ceo") || employee.getRole().equalsIgnoreCase("cto"))
	        	    	{
	        	    		employee.setDirectReportee(null);
	        	    	}else
	        	    	{	        	    		
	        	    		employee.setDirectReportee(rm);
	        	    		rm.getEmployees().add(employee);
	        	    	}
	        	    	employeeRepo.save(employee);
	        	    	EmployeeDTO edt = new EmployeeDTO(employee.getEmployeeId(), employee.getUsername(), employee.getPassword());
	        	    	return edt;	        	   
	        	    }
	        	    throw new ReportingManagerException("Reporting manager not found");
	           }
	           throw new DuplicateUsernameException("Username is not available");
              }
		throw new AdminException("Admin is not logged in");
	}

	@Override
	public ReportingManager registerRepostingManager(Long employeeId, Long loggedInAdminId)
			throws EmployeeException, AdminException {
		// TODO Auto-generated method stub
	    if(adminCurrentSessionRepo.findById(loggedInAdminId).isPresent())
	    {
	    	if(employeeRepo.findById(employeeId).isPresent())
	    	{
	    		Employee em = employeeRepo.findById(employeeId).get();
	    		ReportingManager rm = new ReportingManager();
	    		rm.setEmployee(em);
	    		return rmRepo.save(rm);
	    	}
	    	throw new EmployeeException("Invalid Employee");
	    }
	    throw new AdminException("Admin is not logged in");
	}
	
	public Employee getEmployeeDetails(Long employeeId, Long loggedInAdminId) throws AdminException, EmployeeException {
		if(adminCurrentSessionRepo.findById(loggedInAdminId).isPresent())
	    {
			if(employeeRepo.findById(employeeId).isPresent())
	    	{
				return employeeRepo.findById(employeeId).get();
	    	}
			throw new EmployeeException("Invalid Employee");
	    }
	    throw new AdminException("Admin is not logged in");
	}
	
	public ReportingManager getReportingManagerOfEmployee(Long employeeId, Long loggedInAdminId) throws EmployeeException, AdminException {
		if(adminCurrentSessionRepo.findById(loggedInAdminId).isPresent())
	    {
			if(employeeRepo.findById(employeeId).isPresent())
	    	{
				Employee e = employeeRepo.findById(employeeId).get();
				 return e.getDirectReportee();
				
	    	}
			throw new EmployeeException("Invalid Employee");
	    }
	    throw new AdminException("Admin is not logged in");
	}
	
	public List<Employee> getAllEmployeeReportees(Long employeeId, Long loggedInAdminId) throws ReportingManagerException, AdminException, EmployeeException{
		
		
		if(adminCurrentSessionRepo.findById(loggedInAdminId).isPresent())
	    {
			
				if(employeeRepo.findById(employeeId).isPresent())
				{
					List<ReportingManager> rms = rmRepo.findAll();
					
					ReportingManager foundrm =  rms.stream().filter(rm -> rm.getEmployee().getEmployeeId()==employeeId).findAny().get();
					if(foundrm!=null)
					{
						
						return foundrm.getEmployees();
					}
               throw new ReportingManagerException("This employee is not a reporting manager");					
				}
				
				throw new EmployeeException("Invalid Employee");
	    	}
	  
	    throw new AdminException("Admin is not logged in");
		
	}
}
