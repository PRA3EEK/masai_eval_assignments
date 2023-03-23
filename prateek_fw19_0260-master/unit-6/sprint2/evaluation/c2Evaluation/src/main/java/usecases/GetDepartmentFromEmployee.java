package usecases;

import java.util.Scanner;

import dao.EmployeeDaoImpl;
import entities.Department;
import exceptions.DepartmentException;

public class GetDepartmentFromEmployee {
  
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee Id");
		int id = sc.nextInt();
		
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		try {
			Department d = edi.getDepartmentDetailsByEmployeeId(id);
			
			System.out.println("Department id : "+d.getDeptId());
			System.out.println("Department name : "+d.getDeptName());
			System.out.println("Department Location "+d.getLocation());
			
		} catch (DepartmentException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	
}
