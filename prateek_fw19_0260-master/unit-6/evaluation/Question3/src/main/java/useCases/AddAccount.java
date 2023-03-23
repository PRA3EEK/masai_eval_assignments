package useCases;

import java.util.Scanner;

import classes.Account;
import daoClasses.AccountDaoImpl;

public class AddAccount {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Id");
		int id = sc.nextInt();
		
		System.out.println("Enter email");
		String mail = sc.next();
		sc.nextLine();
		System.out.println("Enter Address");
		String add = sc.nextLine();
		System.out.println("Enter Balance");
		double bal = sc.nextDouble();
		
		Account a = new Account(id, mail, add, bal);
		
		AccountDaoImpl adi = new AccountDaoImpl();
          System.out.println(adi.save(a));
	
	}
	
}
