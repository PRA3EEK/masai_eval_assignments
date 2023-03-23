package extraAssignment;

import java.time.LocalDate;
import java.time.LocalTime;


public class DateTimeAPI {
 
	
	
	public static void main(String[] args) {
		LocalDate ld = LocalDate.now();
//		LocalTime lt = LocalTime.now();
//		System.out.println(lt);
//		System.out.println(ld);
		LocalDate tomorrow = ld.plusDays(1);
		LocalDate addAMonth = ld.plusMonths(1);
		LocalDate addAWeek = ld.plusWeeks(1);
		LocalDate addAYear = ld.plusYears(1);
		System.out.println(addAYear);
	}
}
