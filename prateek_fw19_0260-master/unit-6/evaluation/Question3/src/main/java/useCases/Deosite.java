package useCases;

import java.util.Scanner;

import daoClasses.AccountDaoImpl;

public class Deosite {
 
	public static void main(String[] args) {
		
       Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account Id");
		int id = sc.nextInt();
		
		System.out.println("Enter ammount to Deposite");
		double am = sc.nextDouble();
		
		AccountDaoImpl adi = new AccountDaoImpl();
		System.out.println(adi.deposit(am, id));
	}
	
}
