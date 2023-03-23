package day11Assignment;

public class Student {
//	roll,
//	name,
//	marks,
//	grade:char,
	private int roll;
	private String name;
	private int marks;
	private char grade;
	public Student (int roll, String name, int marks, char grade) {
		this.roll = roll;
		this.name = name;
		this.marks = marks;
		this.grade = grade;
		
	}
	public Student () {
		
	}
	
	public void displayDetails(int roll, String name, int marks) {
//		display details only
		char grade = calculateGrade(marks);
		Student S = new Student(roll, name, marks, grade);
		System.out.println(S);
	}
	private char calculateGrade(int marks) {
//		calculate grade
		char grade = 'E';
		if(marks>= 500) {
			 grade = 'A';
			
		}
		else if(marks<500 && marks>=400) {
		   grade = 'B';
			
		}else if(marks<400) {
			grade = 'C';
			
		}
		return grade;
	}
	
}
