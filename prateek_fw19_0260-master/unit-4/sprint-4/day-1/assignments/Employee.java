package day13Assignment;

public abstract class Employee {
//	employeeId: Integer
//	employeeName: String
//	salary: double
	protected int employeeId;
	protected String employeeName;
	protected double salary;
	
	public Employee(int id, String name) {
		this.employeeId = id;
		this.employeeName = name;
		}
	public Employee() {
		
	}
	public abstract void calculateSalary();
}
