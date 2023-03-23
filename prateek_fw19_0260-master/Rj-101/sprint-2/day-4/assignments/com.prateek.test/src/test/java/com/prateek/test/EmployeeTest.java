package com.prateek.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeTest {
	
	static EmployeeServiceImpl es = null;
	
	@BeforeAll
	public static void firstFunction() {
		System.out.println("started");
		es = new EmployeeServiceImpl();
	}

 @Test
  public void addEmployeeTest() {
	  System.out.println("started fssfs");
	  Employee e = new Employee(3, "aniket");
	  
		assertEquals("aniket",  es.addEmployee(e).getName());
	
//	  return e;
  }
 @Test
 public void addEmployeeFailTest() {
	 Employee e = new Employee(3, "aniket");
		assertNull(es.addEmployee(e));
 }
 
 @Test
 public void deleteEmployeeTest() throws EmployeeException {
	 
	 assertTrue(es.deleteEmployee(3)) ;
 }
 
 @Test
 public void deleteEmployeeFailTest() throws EmployeeException {
	 
	 assertThrows(EmployeeException.class,()-> es.deleteEmployee(8)) ;
 }
// public 
 
}
