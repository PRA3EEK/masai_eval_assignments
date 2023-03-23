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
import org.springframework.web.bind.annotation.RestController;

import com.prateek.exceptions.PostNotFoundException;
import com.prateek.exceptions.UserException;
import com.prateek.models.Post;
import com.prateek.services.PostService;

import jakarta.validation.Valid;

@RestController
public class PostController {

	@Autowired
	private PostService postService;
	
	@GetMapping("/posts")
	public ResponseEntity<List<Post>> getAllPost() throws PostNotFoundException
	{
		return new ResponseEntity<List<Post>>(postService.getAllPosts(), HttpStatus.OK);
	}
//	
	@GetMapping("/posts/{postId}")
	public ResponseEntity<Post> getPostById(@PathVariable("postId") Long id) throws PostNotFoundException
	{
	return new ResponseEntity<Post>(postService.getPost(id), HttpStatus.OK);
	}
//	
	@PostMapping("/posts/{userId}")
	public ResponseEntity<Post> createNewPost(@Valid @RequestBody Post post, @PathVariable("userId") Long id) throws UserException
	{
		return  new ResponseEntity<Post>(postService.createPost(post, id), HttpStatus.OK);
	}
//	
//	@PutMapping("/posts/{postId}")
//	public ResponseEntity<Post> updatePost(@PathVariable("postId") Long id)
//	{
//		
//	}
    @DeleteMapping("/posts/{postId}")	
	public ResponseEntity<Post> deletePost(@PathVariable("postid") Long id) throws PostNotFoundException
	{
    	return new ResponseEntity<Post>(postService.deletePost(id), HttpStatus.OK);
	}
	
}
