package com.prateek.mainClasses;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.prateek.configurations.AppConfig;
import com.prateek.presentations.Presentation;

public class ProductDemo {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		Presentation p = ctx.getBean("presentation", Presentation.class);
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		
		while(flag) {
			System.out.println("Choose a number");
			System.out.println("1. For Inserting a product");
	        System.out.println("2. For searching a product with id");
	        System.out.println("3. For printing the list of all products");
	        System.out.println("4. For printing products within a giving price range");
	        int c = sc.nextInt();
	        if(c == 1) {
	        	p.insertProduct();
	        	
	        }else if(c == 2) {
	        	p.searchProduct();
	        	
	        }else if(c== 3) {
	        	
	        	p.printAllProduct();
	        }else if(c == 4) {
	        	p.findProductsWithinGivenRange();
	        }else {
	        	System.out.println("Enter a number from above");
	        }
	        
	        System.out.println("Continue using this app? (Y/N)");
	        String r = sc.next();
	        if(r.toLowerCase().equals("n")) {
	        	flag = false;
	        }
		}
		
	}
	
}
