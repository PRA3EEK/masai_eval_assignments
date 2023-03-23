package mainApp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import useCases.AddEmployee;
import useCases.DeleteEmployee;
import useCases.GetAddress;
import useCases.GiveBonus;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
boolean flag = true;
Scanner sc = new Scanner(System.in);

while(flag) {
	
	System.out.println("1. Add Employee");
	System.out.println("2. Delete Employee");
	System.out.println("3. Get Address of employee");
	System.out.println("4. Give Bonus");
	int n = sc.nextInt();
	if(n == 1) {
		AddEmployee.excFun();
	}else if(n == 2) {
		DeleteEmployee.excFun();
	}else if(n==3) {
		GetAddress.excFun();
	}else {
		GiveBonus.excFun();
	}
	System.out.println("Continue ? (Y/N)");
	String res = sc.next();
	if(res.toLowerCase().equals("y")) {
		flag = true;
	}else {
		flag = false;
	}
}
	
		
		
		
	}

}
