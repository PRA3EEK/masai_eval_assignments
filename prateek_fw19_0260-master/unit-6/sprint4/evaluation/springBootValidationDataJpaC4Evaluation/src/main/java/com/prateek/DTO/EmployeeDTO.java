package com.prateek.DTO;

public class EmployeeDTO {

	private String name;
	private String address;
	private Integer salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public EmployeeDTO(String name, String address, Integer salary) {
		super();
		this.name = name;
		this.address = address;
		this.salary = salary;
	}
	
	public EmployeeDTO() {
		// TODO Auto-generated constructor stub
	}
	
}
