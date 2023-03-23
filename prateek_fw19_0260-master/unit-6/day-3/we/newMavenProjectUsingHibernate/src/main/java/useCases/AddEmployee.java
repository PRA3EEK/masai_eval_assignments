package useCases;

import java.util.Scanner;

import beanClassed.Employee;
import dao.EmployeeDaoImpl;

public class AddEmployee {

	public static void excFun() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter employee Id");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Entere employee name");
		String name = sc.nextLine();
		
		System.out.println("Enter address");
		String add = sc.nextLine();
		
		System.out.println("Enter salary");
		int sal = sc.nextInt();
		
		Employee e = new Employee(id, name, add, sal);
		
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.save(e);
	}
	
}
