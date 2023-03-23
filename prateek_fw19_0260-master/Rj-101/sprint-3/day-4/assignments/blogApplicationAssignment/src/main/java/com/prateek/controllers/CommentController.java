package com.prateek.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prateek.DTO.CommentDTO;
import com.prateek.exceptions.CommentNotFoundException;
import com.prateek.exceptions.PostNotFoundException;
import com.prateek.exceptions.UserException;
import com.prateek.models.Comment;
import com.prateek.services.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("{postId}")
	public ResponseEntity<CommentDTO> addComment(@RequestBody Comment comment, @PathVariable("postId") Long postId, @RequestParam("userId") Long userId) throws PostNotFoundException, UserException
	{
		return new ResponseEntity<CommentDTO>(commentService.addComment(postId, comment, userId), HttpStatus.OK);
	}
	
	@DeleteMapping("{postId}")
	public ResponseEntity<CommentDTO> deleteComment(@PathVariable("postId") Long postId, @RequestParam("commentId") Long commentId) throws PostNotFoundException, CommentNotFoundException
	{
		return new ResponseEntity<CommentDTO>(commentService.deleteComment(postId, commentId), HttpStatus.OK);
	}
	
	@GetMapping("/{postId}")
	public ResponseEntity<List<Comment>> getAllComments(@PathVariable("postId") Long id) throws PostNotFoundException, CommentNotFoundException
	{
		return new ResponseEntity<List<Comment>>(commentService.getAllComments(id), HttpStatus.OK);
	}
	
	@PutMapping("{postId}/{commentId}")
	public ResponseEntity<CommentDTO> updateComment(@PathVariable("postId") Long postId, @PathVariable("commentId") Long commentId,  @RequestParam("newMessage") String msg) throws PostNotFoundException, CommentNotFoundException
	{
		return new ResponseEntity<CommentDTO>(commentService.updateComment(postId, commentId, msg), HttpStatus.OK);
	}
	
	@DeleteMapping("{postId}/{commentId}")
	public ResponseEntity<CommentDTO> getComment(@PathVariable("postId") Long postId, @PathVariable("commentId") Long commentId) throws PostNotFoundException, CommentNotFoundException
	{
		return new ResponseEntity<CommentDTO>(commentService.getComment(postId, commentId), HttpStatus.OK);
	}
	
}
