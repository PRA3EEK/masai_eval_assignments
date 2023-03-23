package usecases;

import java.util.Scanner;

import dao.EmployeeDaoImpl;
import entities.Department;

public class AddDepartment {
  
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter department name");
		String name = sc.next();
		sc.nextLine();
		System.out.println("Enter Department Location");
		String loc = sc.nextLine();
		
		Department d= new Department();
		d.setDeptName(name);
		d.setLocation(loc);
		
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.addDepartment(d);
		
	}
	
}
