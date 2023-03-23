package day2Assignment;

public class Employee extends Member{

    @Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName +"]";
	}


	private int employeeId;
    private String employeeName;
	
	public Employee(int employeeId, String employeeName) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
}
