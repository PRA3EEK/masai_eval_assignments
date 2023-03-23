package day8Assignment;

public class Student {
//	roll: Integer
//	name: String
//	address: String
//	marks: Integer
	private int roll;
	private String name;
	private String address;
	private int marks;
	
	public void setRoll (int roll) {
		this.roll = roll;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public void setAddress (String address) { 
		this.address = address;
	}
	
	public void setMarks (int marks) {
		this.marks = marks;
	}
	
	public int getRoll () {
		return roll;
	}
	
	public String getName () {
		return name;
	}
	public String getAddress () {
		return address;
	}
	public int getMarks () {
		return marks;
	}
}
