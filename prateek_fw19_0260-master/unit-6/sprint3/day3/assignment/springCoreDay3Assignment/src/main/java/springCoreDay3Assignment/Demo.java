package springCoreDay3Assignment;

import java.util.Map;
import java.util.Map.Entry;

public class Demo {

	private Map<Department, Employee> theMap;
	//use setter injection to inject theMap;
	
	public void myInit(){
	System.out.println("inside myInit method");
	}
	
	public Map<Department, Employee> getTheMap() {
		return theMap;
	}

	public void setTheMap(Map<Department, Employee> theMap) {
		this.theMap = theMap;
	}

	public void cleanUp(){
	System.out.println("inside cleanUp method");
	
	
	}
	public void showDetails(){
	System.out.println("inside showDetails of Demo class");
	for(Entry<Department, Employee> e: theMap.entrySet()) {
		System.out.println("Department Id : "+e.getKey().getDeptId());
		System.out.println("Department name :"+e.getKey().getDeptName());
		System.out.println("Department location :"+e.getKey().getLocation());
		System.out.println("Employee Id of Employee from department : "+e.getKey().getDeptName()+" is : "+e.getValue().getEmpId());
		System.out.println("Employee name of Employee from department : "+e.getKey().getDeptName()+" is : "+e.getValue().getName());
		System.out.println("Employee address of Employee from department : "+e.getKey().getDeptName()+" is : "+e.getValue().getAddress());
		System.out.println("Employee salary of Employee from department : "+e.getKey().getDeptName()+" is : "+e.getValue().getSalary());
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	//print all the details of all the employees department-wise.
	}
	
}
