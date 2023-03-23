package day4Assignment;

import java.util.Scanner;

public class Question4 {
	public static void fun(int a, int b) {
		try {
			double x = a;
			double y = b;
			
			double res = x/y;
			System.out.println("The quotient of "+a+"/"+b+" is "+res);
		}
		catch(ArithmeticException e) {
			System.out.println("DivideByZeroException caught");
		}
		finally {
			System.out.println("Inside finally block");
		}
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	    
		System.out.println("Enter the two numbers");
		
		String[] s = sc.nextLine().split(" ");
		int a = Integer.parseInt(s[0]);
		int b = Integer.parseInt(s[1]);
		fun(a, b);
		
	}
	
}
