package com.prateek.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prateek.models.Post;

public interface PostRepo extends JpaRepository<Post, Long>{

}
