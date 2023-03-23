package day8Assignment;
import java.util.Scanner;
public class Demo {
  public static void main (String[] args) {
	  Scanner sc = new Scanner(System.in);
	  System.out.println("Enter the number of students");
	int S = sc.nextInt();
	Student[] Sarr = new Student[S];
	for(int i=0 ; i<Sarr.length ; i++) {
		System.out.println("Enter the roll number for student "+(i+1));
		int roll = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the name for student "+(i+1));
		String name = sc.nextLine();
		System.out.println("Enter the address for student "+(i+1));
		String address = sc.nextLine();
		System.out.println("Enter the marks for student "+(i+1));
		int marks = sc.nextInt();
	    Student Stu = new Student();
	    Stu.setRoll(roll);
	    Stu.setName(name);
	    Stu.setAddress(address);
	    Stu.setMarks(marks);
	    Sarr[i] = Stu;
	}
	
	int sum = 0;
	
	for(int i=0 ; i<Sarr.length ; i++) {
		System.out.println(Sarr[i].getRoll());
		System.out.println(Sarr[i].getName());
		System.out.println(Sarr[i].getAddress());
		System.out.println(Sarr[i].getMarks());
		sum = sum + Sarr[i].getMarks();
	}
	double av = sum/Sarr.length;
	System.out.println(av);
	
  }
}
