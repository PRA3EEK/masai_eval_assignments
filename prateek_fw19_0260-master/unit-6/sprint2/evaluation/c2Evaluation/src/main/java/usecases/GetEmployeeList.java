package usecases;

import java.util.List;
import java.util.Scanner;

import dao.EmployeeDaoImpl;
import entities.Employee;
import exceptions.EmployeeException;

public class GetEmployeeList {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Department name");
		String name = sc.next();
		
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		try {
			List<Employee> l = edi.getAllEmployeeWithDeptName(name);
			l.forEach(e -> {
				System.out.println("Employee Id : "+e.getEmpId());
				System.out.println("Employee name : "+e.getEmpName());
				System.out.println("Employee salary : "+e.getSalary());
				System.out.println("Employee address : "+e.getAddress());
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}
	
}  
