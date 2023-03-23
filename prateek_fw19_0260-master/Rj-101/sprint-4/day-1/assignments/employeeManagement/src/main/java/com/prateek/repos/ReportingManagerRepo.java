package com.prateek.repos;

import javax.swing.RepaintManager;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prateek.models.ReportingManager;

public interface ReportingManagerRepo extends JpaRepository<ReportingManager, Long>{

}
