package extraAssignment;
import java.time.LocalDate;
//import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
//import java.time.Period;

public class CalculateWages {
	
	public static int calculateWage(long daysBetween) {
		long wage = daysBetween*1200;
		int x = (int)wage;
		
		return x;
	}

	public static void main(String[] args) {
		
	
//		Period p = Period.between(sd, ld);
		
	try {
		DateTimeFormatter day = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Start date in pattern dd-MM-yyyy");
		LocalDate sd = LocalDate.parse(sc.next(), day);
		System.out.println("Enter End date in pattern dd-MM-yyyy");
		
		LocalDate ld = LocalDate.parse(sc.next(), day);
		if(sd.isAfter(ld)){
			System.out.println("Start date should be smaller than End date");
		}else {
			long daysBetween = ChronoUnit.DAYS.between(sd, ld);
			System.out.println(calculateWage(daysBetween));
		}
	}catch(Exception e) {
		System.out.println("Please enter date in dd-MM-yyyy” format");
	}
		
		
	}
	
}
