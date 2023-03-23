package useCases;

import java.util.Scanner;

import dao.EmployeeDaoImpl;

public class GiveBonus {

	
	public static void excFun() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter employee Id");
		int id = sc.nextInt();
		System.out.println("Enter Bonus");
		int bon = sc.nextInt();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		System.out.println(edi.giveBonusToEmployee(id, bon));
		
	}
}
