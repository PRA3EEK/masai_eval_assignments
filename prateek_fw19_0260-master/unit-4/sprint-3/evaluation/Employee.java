package sprint3Evaluation;

public class Employee {
	private int id;
	private String name;
	private int Salary;
	
	
	
	
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		this.Salary = salary;
	}


   public Employee(int id, String name, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.Salary = salary;
	}
public Employee() {
	   
   }
//	Id;
//	Name;
//	Salary;
	
}
