package dao;

import java.util.List;

import entities.Department;
import entities.Employee;
import exceptions.DepartmentException;
import exceptions.EmployeeException;

public interface EmployeeDao {
   
	public void addDepartment (Department d);

	public void addEmployee (Employee e);
	
	public void registerEmployeeTODepartment(int empId, int deptId)throws
	EmployeeException, DepartmentException;
	
	public List<Employee> getAllEmployeeWithDeptName(String deptName)throws
	EmployeeException;
	
	public Department getDepartmentDetailsByEmployeeId(int empId)throws
	DepartmentException;


}
