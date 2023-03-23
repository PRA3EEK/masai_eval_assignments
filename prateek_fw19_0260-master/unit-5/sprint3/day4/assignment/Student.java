package day11Assignment;

import java.io.Serializable;

public class Student implements Serializable{
  
	private int roll;
	private double marks;
	private String name;
	private Address address;
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Student(int roll, double marks, String name, Address address) {
		super();
		this.roll = roll;
		this.marks = marks;
		this.name = name;
		this.address = address;
	}
	
//	public Student() {
//		// TODO Auto-generated constructor stub
//	}
//	@Override
//	public String toString() {
//		return "Student [roll=" + roll + ", marks=" + marks + ", name=" + name + ", address=" + address + "]";
//	}
	
	
}
