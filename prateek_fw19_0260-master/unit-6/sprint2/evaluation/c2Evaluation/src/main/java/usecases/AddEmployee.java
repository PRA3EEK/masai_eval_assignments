package usecases;

import java.util.Scanner;

import classes.Address;
import dao.EmployeeDaoImpl;
import entities.Employee;

public class AddEmployee {
  
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter employee name");
		String name = sc.nextLine();
		
		System.out.println("Enter employee salary");
		double sal = sc.nextDouble();
		sc.nextLine();
		System.out.println("Enter state name");
		String st = sc.nextLine();
		
		System.out.println("Enter city name");
		String city = sc.nextLine();
		
		System.out.println("Enter pincode");
		String pc = sc.next();
		
		Address a = new Address(city, st, pc);
		Employee e = new Employee();
		e.setEmpName(name);
		e.setSalary(sal);
		e.setAddress(a);
		
		
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.addEmployee(e);
		
	}
	
}
