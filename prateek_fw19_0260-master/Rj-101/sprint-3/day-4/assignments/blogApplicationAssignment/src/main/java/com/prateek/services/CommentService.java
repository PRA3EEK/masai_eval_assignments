package com.prateek.services;

import java.util.List;

import com.prateek.DTO.CommentDTO;
import com.prateek.exceptions.CommentNotFoundException;
import com.prateek.exceptions.PostNotFoundException;
import com.prateek.exceptions.UserException;
import com.prateek.models.Comment;

public interface CommentService {

	public CommentDTO addComment(Long postId, Comment comment, Long Id) throws PostNotFoundException, UserException;
	
	public CommentDTO getComment(Long postId, Long commentId) throws PostNotFoundException, CommentNotFoundException;
	
	public List<Comment> getAllComments(Long postId) throws PostNotFoundException;
	
	public CommentDTO updateComment(Long postId, Long commentId, String msg) throws PostNotFoundException, CommentNotFoundException;
	
	public CommentDTO deleteComment(Long postId, Long commentId) throws PostNotFoundException, CommentNotFoundException;
}
