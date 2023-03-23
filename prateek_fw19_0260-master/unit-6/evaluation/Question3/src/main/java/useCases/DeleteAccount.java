package useCases;

import java.util.Scanner;

import daoClasses.AccountDaoImpl;

public class DeleteAccount {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter account id");
		int id = sc.nextInt();
		
		AccountDaoImpl adi = new AccountDaoImpl();
		System.out.println(adi.deleteAccountById(id));
	}
	
}
