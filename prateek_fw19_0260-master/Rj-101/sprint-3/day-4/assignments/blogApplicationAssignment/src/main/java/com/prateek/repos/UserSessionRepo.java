package com.prateek.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prateek.models.UserSession;

public interface UserSessionRepo extends JpaRepository<UserSession, Long>{

}
