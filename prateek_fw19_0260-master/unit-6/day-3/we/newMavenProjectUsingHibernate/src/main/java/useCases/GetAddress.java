package useCases;

import java.util.Scanner;

import dao.EmployeeDaoImpl;

public class GetAddress {

	public static void excFun() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter employee Id");
		int id = sc.nextInt();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		System.out.println(edi.getAddressOfEmployee(id));
	}
}
