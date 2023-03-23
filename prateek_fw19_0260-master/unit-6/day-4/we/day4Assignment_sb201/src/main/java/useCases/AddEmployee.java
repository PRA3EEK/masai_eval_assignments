package useCases;

import java.util.Scanner;

import classes.Employee;
import dao.EmployeeDaoImpl;
import exceptions.EmployeeException;

public class AddEmployee {

	public static void main(String[] args) {
		
	  Scanner sc = new Scanner (System.in);
	 
	  System.out.println("Enter name");
	  String name = sc.nextLine();
	  
	  System.out.println("Enter address");
	  String ad = sc.nextLine();
	  
	  System.out.println("Enter salary");
	  int sal = sc.nextInt();
	  
	  Employee e = new Employee(name, ad, sal);
	  
	  EmployeeDaoImpl edi = new EmployeeDaoImpl();
	  try {
		System.out.println(edi.registerEmployee(e));
	} catch (EmployeeException e1) {
		// TODO Auto-generated catch block
		
		System.out.println(e1.getMessage());
	}
	  
	}
	
}
