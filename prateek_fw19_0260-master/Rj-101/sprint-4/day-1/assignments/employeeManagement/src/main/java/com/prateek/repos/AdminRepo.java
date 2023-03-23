package com.prateek.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prateek.models.Admin;
import com.prateek.services.AdminService;

public interface AdminRepo extends JpaRepository<Admin, Long>{

}
