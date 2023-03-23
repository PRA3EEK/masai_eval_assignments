package com.prateek.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prateek.enitites.Email;

public interface EmailRepo extends JpaRepository<Email, Long>{

}
