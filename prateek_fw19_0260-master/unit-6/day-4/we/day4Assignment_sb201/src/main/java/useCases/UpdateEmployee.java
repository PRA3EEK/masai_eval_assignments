package useCases;

import java.util.Scanner;

import classes.Employee;
import dao.EmployeeDaoImpl;
import exceptions.EmployeeException;

public class UpdateEmployee {

	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter new name");
		String name = sc.nextLine();
		
		System.out.println("Enter new Address");
		String ad = sc.nextLine();
		
		System.out.println("Enter new sal");
		int sal = sc.nextInt();
		
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		try {
		Employee e = edi.getEmployeeById(id);
		
		e.setName(name);
		e.setAddress(ad);
		e.setSalary(sal);
		System.out.println(edi.updateEmployee(e));   
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
}
