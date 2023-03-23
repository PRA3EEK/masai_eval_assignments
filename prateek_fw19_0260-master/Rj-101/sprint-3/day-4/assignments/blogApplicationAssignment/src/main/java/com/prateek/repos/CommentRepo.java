package com.prateek.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prateek.models.Comment;

public interface CommentRepo extends JpaRepository<Comment, Long>{

}
