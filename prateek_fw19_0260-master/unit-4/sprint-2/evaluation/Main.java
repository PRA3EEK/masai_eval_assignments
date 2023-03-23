package sprint2evaluation;

import java.util.Scanner;

public class Main {
   public static void main (String[] args) {
	   try (Scanner sc = new Scanner(System.in)) {
		System.out.println("Enter roll number");
		   int rollNumber = sc.nextInt();
		   System.out.println("Enter name");
		
		   
		   String name = sc.next();
		   sc.next();
		   System.out.println("Enter marks");
		   int marks = sc.nextInt();
		   
		   
		   
		 Students S = new Students(rollNumber, name, marks);
		 System.out.println(S.getRollNumber());
		 System.out.println(S.getStudentName());;
		 System.out.println(S.getMarks());
	}
   }
}
