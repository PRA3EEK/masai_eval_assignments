package useCases;

import java.util.Scanner;

import daoClasses.AccountDaoImpl;

public class FindAccount {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter account Id");
		int id = sc.nextInt();
		
		AccountDaoImpl adi = new AccountDaoImpl();
		if(adi.findById(id)!=null) {
			System.out.println(adi.findById(id));
		}else {
			System.out.println("No account found...");
		}
	}
}
