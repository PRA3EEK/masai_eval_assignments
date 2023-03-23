package useCases;

import java.util.Scanner;

import dao.EmployeeDaoImpl;
import exceptions.EmployeeException;

public class GetEmployee {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter employee id");
		int id = sc.nextInt();
		
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		
		try {
			System.out.println(edi.getEmployeeById(id));
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
