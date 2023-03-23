package com.prateek;

import static org.assertj.core.api.Assertions.assertThatException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.prateek.exceptions.EmployeeException;
import com.prateek.model.Employee;
import com.prateek.repos.EmployeeRepo;
import com.prateek.services.EmployeeService;

@SpringBootTest
class EmployeeManagementAssignmentApplicationTests {

	@MockBean
	private EmployeeRepo employeeRepo;
	@Autowired
	private EmployeeService employeeService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void getAllEmployeeTest()
	{
		when(employeeRepo.findAll()).thenReturn(Stream.of(new Employee(), new Employee()).collect(Collectors.toList()));
	   assertEquals(2, employeeService.getAllEmployee().size());
	}

	@Test
    public void employeeExceptionTest() throws EmployeeException
    {

    	assertThrows(EmployeeException.class,() -> employeeService.updateEmployeePassword((long) -1, "adsjshkdhfks"));
    }
	
}
