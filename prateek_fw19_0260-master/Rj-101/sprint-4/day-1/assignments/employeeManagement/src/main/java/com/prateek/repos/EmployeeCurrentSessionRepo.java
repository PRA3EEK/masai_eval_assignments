package com.prateek.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prateek.models.EmployeeCurrentSession;

public interface EmployeeCurrentSessionRepo extends JpaRepository<EmployeeCurrentSession, Long>{

}
