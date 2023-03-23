package com.prateek.useCase;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.prateek.DAO.StudentService;

@Controller
public class AddStudent {
   
	@Autowired
	private StudentService ss;
	
	public void insertStudent() {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter student roll");
		int roll = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter student name");
	    String name = sc.nextLine();
	    
	    System.out.println("Enter student address");
	    String address = sc.nextLine();
	    
	    System.out.println(ss.addStudent(roll, name, address));
		
	}
	
	
	
}
