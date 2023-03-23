package day13Assignment;

public class TemporaryEmployee extends Employee{
//	hoursWorked: Integer
//	hourlyWages: Integer
	private int hoursWorked;
	
	
	
	public int getHoursWorked() {
		return hoursWorked;
	}
	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	public int getHourlyWages() {
		return hourlyWages;
	}
	public void setHourlyWages(int hourlyWages) {
		this.hourlyWages = hourlyWages;
	}
	private int hourlyWages;
	@Override
	public void calculateSalary() {
		// TODO Auto-generated method stub
		double salary = this.hoursWorked * this.hourlyWages;
		this.salary = salary;
	}
	
	public TemporaryEmployee (int id, String name, int workHours, int wage) {
		this.employeeId = id;
		this.employeeName = name;
		this.hoursWorked = workHours;
		this.hourlyWages = wage;
	}
	public TemporaryEmployee() {
		
	}
	
	
}
