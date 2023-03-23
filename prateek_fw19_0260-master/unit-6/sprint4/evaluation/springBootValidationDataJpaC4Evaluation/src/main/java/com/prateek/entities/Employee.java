package com.prateek.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;
	@NotNull(message = "Name cannot be null")
	@NotBlank(message = "Name cannot be blank")
	@Size(min = 3, max = 20, message = "Name length should be in the range from 3 to 20")
	private String empName;
	
	@NotNull(message = "Salary cannot be null")
	@Min(value = 50000, message = "Min salary can be 50000")
	@Max(value = 400000, message = "Max salary can be 400000")
	private Integer salary;
	
	@NotNull(message = "Address cannot be null")
    @NotBlank(message = "Address cannot be blank")
	@Size(min = 5, max = 50, message = "Address length should be in the range from 5 to 50")
	private String address;
	
	@Email
	@NotNull(message = "Email cannot be null")
	@NotBlank(message = "Blank email is not allowed")
	private String email;
	
	@NotNull(message = "Mobile number cannot be null")
	@NotBlank(message = "Blank number is not allowed")
//	@Size(min = 10, max = 10, message = "Number should be of 10 digits")
	private String mobile;
	
	@NotNull(message = "Password cannot be null")
	@NotBlank(message = "Blank password is not allowed")
	@Size(min = 5, max = 10, message = "Password length should be in the range of 8 to 16")
	private String password;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEmpId() {
		return empId;
	}

	public Employee(
			@NotNull(message = "Name cannot be null") @NotBlank(message = "Name cannot be blank") @Size(min = 3, max = 20, message = "Name length should be in the range from 3 to 20") String empName,
			@NotNull(message = "Salary cannot be null") @Min(value = 50000, message = "Min salary can be 50000") @Max(value = 400000, message = "Max salary can be 400000") Integer salary,
			@NotNull(message = "Address cannot be null") @NotBlank(message = "Address cannot be blank") @Size(min = 5, max = 50, message = "Address length should be in the range from 5 to 50") String address,
			@Email @NotNull(message = "Email cannot be null") @NotBlank(message = "Blank email is not allowed") String email,
			@NotNull(message = "Mobile number cannot be null") @NotBlank(message = "Blank number is not allowed")  String mobile,
			@NotNull(message = "Password cannot be null") @NotBlank(message = "Blank password is not allowed") @Size(min = 5, max = 10, message = "Password length should be in the range of 8 to 16") String password) {
		super();
		this.empName = empName;
		this.salary = salary;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", address=" + address
				+ ", email=" + email + ", mobile=" + mobile + ", password=" + password + "]";
	}
	
	
	
	
}
