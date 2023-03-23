package com.prateek.test;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
	List<Employee> lists = new ArrayList<Employee>();
	public EmployeeServiceImpl() {
		// TODO Auto-generated constructor stub
		lists.add(new Employee(1,"prateek chauhan"));
		lists.add(new Employee(2,"pratham chauhan"));
		lists.add(new Employee(3,"sunil chauhan"));
		
	}
    
  
	public Employee addEmployee(Employee employee){
		// TODO Auto-generated method stub
		for(Employee e:lists) {
			if(e.getId() == employee.getId()) {
				return null;
			}
		}
		lists.add(employee);
		return employee;
//		return null;
	}

	public boolean deleteEmployee(int employeeid) throws EmployeeException {
		// TODO Auto-generated method stub

		Employee res = null;
		
     for(Employee e:lists) {
    	 if(e.getId() == employeeid) {
    		 
    		 res = e;
    	 }
     }
		if(res!=null) {
			lists.remove(res);
			return true;
		}
		throw new EmployeeException("No employee present with the empid "+employeeid);
	}

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return lists;
//		return null;
	}

	public Employee getEmployee(int emplId) throws EmployeeException {
		// TODO Auto-generated method stub
		for(Employee e:lists) {
			if(e.getId() == emplId) {
				return e;
			}
		}
		throw new EmployeeException("No employee present with the empid "+emplId);
	}
 
}
