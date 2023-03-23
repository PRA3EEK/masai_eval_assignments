package useCases;

import java.util.Scanner;

import dao.EmployeeDaoImpl;

public class DeleteEmployee {

	public static void excFun() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter employee id");
		int id = sc.nextInt();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		if(edi.deleteEmployee(id)) {
			System.out.println("Employee deleted successfully...");
		}else {
		System.out.println("Employee not found...");
		}
		
	}
	
}
