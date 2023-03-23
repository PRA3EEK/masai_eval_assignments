package usecases;

import java.util.Scanner;

import dao.EmployeeDaoImpl;
import exceptions.DepartmentException;
import exceptions.EmployeeException;

public class AddEmployeeInDepartment {
  
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Department Id");
		int did = sc.nextInt();
		
		System.out.println("Enter Employee Id");
		int eid = sc.nextInt();
		
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		try {
			edi.registerEmployeeTODepartment(eid, did);
			System.out.println("Employee Added Successfully...");
		} catch (EmployeeException | DepartmentException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		
		
	}
	
}
