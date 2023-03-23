package day4Assignment;

import java.util.Scanner;

public class Question1 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number");
		String s = sc.next();
		try {
			int inp = Integer.parseInt(s);
			int res = inp * inp;
			System.out.println("The square of the number is "+res);
		}
		catch(NumberFormatException e){
			System.out.println("Entered input is not a valid format for an integer");
		}
		System.out.println("The work has been done successfully");
	}
}
