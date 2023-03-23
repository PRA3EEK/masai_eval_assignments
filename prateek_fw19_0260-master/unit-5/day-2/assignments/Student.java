package day2Assignment;

public class Student {
   private int roll;
   private String name;
   private double marks;
public int getRoll() {
	return roll;
}
public void setRoll(int roll) {
	this.roll = roll;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getMarks() {
	return marks;
}
public void setMarks(double marks) {
	this.marks = marks;
}
public Student(int roll, String name, double marks) {
	super();
	this.roll = roll;
	this.name = name;
	this.marks = marks;
}
   public Student() {
	// TODO Auto-generated constructor stub
}

   @Override
   public int hashCode() {
   	// TODO Auto-generated method stub
   	return this.roll;
   }
   @Override
   public boolean equals(Object obj) {
   	// TODO Auto-generated method stub
   	Student s = (Student)obj;
   	if(this.roll == s.getRoll()) {
   		return true;
   }else {
   	return false;
   }
   }
@Override
public String toString() {
	return "Student [roll=" + roll + ", name=" + name + ", marks=" + marks +"]";
}
}


