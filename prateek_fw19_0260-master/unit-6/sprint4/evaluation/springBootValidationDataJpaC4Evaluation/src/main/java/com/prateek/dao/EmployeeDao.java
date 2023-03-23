package com.prateek.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prateek.entities.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{

	public List<Employee> findByAddress(String address);
	
//	@Query("select name, address from Employee where empId=?1")
//	public String getNameAndAddressById(Integer id);
	
}
