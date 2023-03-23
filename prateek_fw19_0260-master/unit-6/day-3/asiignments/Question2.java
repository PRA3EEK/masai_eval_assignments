package day3Assignment;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Question2 {
	
	public static int fun(String date) {
       DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		LocalDate dob = LocalDate.parse(date, df);
		
		LocalDate today = LocalDate.now();
		
		if(dob.isAfter(today)) {
			System.out.println("Date should not be in Future");
			return 0;
		}else {
			Period p = Period.between(dob, today);
			return p.getYears();
		}
	}
 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your date of birth in the format (dd-MM-yyyy)");
		
		String date = sc.next();
		try {
			
			DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate dob = LocalDate.parse(date, df);
			if(fun(date)!=0) {
			System.out.println("Your age is "+fun(date));
			}

		}catch(DateTimeParseException e) {
			System.out.println("Please enter the date in correct format");
		}
		
		
	}
	
}
