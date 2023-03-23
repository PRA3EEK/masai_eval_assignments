package day1Assignment;

import java.util.Set;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
public class LibraryMain {

	public static void main(String[] args) {
		
	   HashSet<Library> set = new HashSet<>();
	   HashSet<Members> set2 = new HashSet<>();
	   
	   
	   Scanner sc = new Scanner(System.in);
	   boolean flag = true;
	   while(flag) {
		   System.out.println("Add member details");
		   try {
			   System.out.println("Enter Member Id");
			   int id = sc.nextInt();
			   sc.nextLine();
			   System.out.println("Enter Member name");
			   String name = sc.nextLine();
			   System.out.println("Enter Membership Number");
			   int memNum = sc.nextInt();
			   System.out.println("Enter Membership end date only in the format dd-MM-yyyy)");
			   String date = sc.next();
			   DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			   LocalDate l = LocalDate.parse(date,df);
			   Members m = new Members(id, name, memNum, date);
			   set2.add(m);
		   }
		   catch(Exception e){
			   System.out.println("Above details are not added please, Enter valid details in valid manner");
		   }
		   System.out.println("Continue Adding? (Y/N)");
		   String s = sc.next();
		   if(s.equals("Y")) {
			   flag = true;
		   }else if(s.equals("N")) {
			   flag = false;
		   }
	   }
	 
	  
	   
	   List<Members> l = new ArrayList<>(set2);
	   Collections.sort(l);
		
	}
	
}
