package day11Assignment;
import java.util.Scanner;
public class AverageAge {
	public double calculateAverage(int[] age){
		double sum = 0;
		for(int i=0 ; i<age.length ; i++) {
			sum = sum + age[i];
		}
		return sum/age.length;
	}
  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter total number of employees");
	int emp = sc.nextInt();
	int[] ageArr = new int[emp];
	if(ageArr.length<2) {
		System.out.println("Please enter a valid employee count");
	}else {
		System.out.println("Enter the age for "+ageArr.length+" Employees");
		for(int i=0 ; i<ageArr.length ; i++) {
			int age = sc.nextInt();
			ageArr[i] = age;
		}
		AverageAge AA = new AverageAge();
		System.out.println("The average is "+AA.calculateAverage(ageArr));
	}
	
}
}
