package com.prateek.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prateek.models.AdminCurrentSession;

public interface AdminCurrentSessionRepo extends JpaRepository<AdminCurrentSession, Long>{

}
