package com.prateek.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prateek.entities.Account;

public interface AccountRepo extends JpaRepository<Account, Integer>{

}
