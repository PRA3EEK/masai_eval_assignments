package sprint2Evaluation;

public class Employee {
private int emplId;
private String name;
private double salary;
private String address;
public int getEmplId() {
	return emplId;
}
public void setEmplId(int emplId) {
	this.emplId = emplId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Employee(int emplId, String name, double salary, String address) {
	super();
	this.emplId = emplId;
	this.name = name;
	this.salary = salary;
	this.address = address;
}

public Employee() {
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Employee [emplId=" + emplId + ", name=" + name + ", salary=" + salary + ", address=" + address + "]";
}
}
