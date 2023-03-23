package day13Assignment;

public class PermenantEmployee extends Employee{
//	basicPay: double
	private double basicPay;
	
	public PermenantEmployee(int id, String name, double basicPay) {
		this.employeeId = id;
		this.employeeName = name;
		this.basicPay = basicPay;
	}
	@Override 
	public void calculateSalary() {
		
		double PF = this.basicPay * 0.12;
		double salary = this.basicPay - PF;
		this.salary = salary;
	}
	public double getBasicPay() {
		return basicPay;
	}
	public void setBasicPay(double basicPay) {
		this.basicPay = basicPay;
	}
	
	public PermenantEmployee() {
		
	}
}
