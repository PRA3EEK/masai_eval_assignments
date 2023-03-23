package useCases;

import java.util.Scanner;

import dao.EmployeeDaoImpl;
import exceptions.EmployeeException;

public class DeleteEmployee {
  
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id");
		int id = sc.nextInt();
		
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		try {
			System.out.println(edi.deleteEmployeeById(id));

		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
          System.out.println(e.getMessage());
		}
		
	}
}
