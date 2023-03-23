package com.prateek.services;

import java.util.List;

import com.prateek.exceptions.PostNotFoundException;
import com.prateek.exceptions.UserException;
import com.prateek.models.Post;

public interface PostService {

   
	public List<Post> getAllPosts() throws PostNotFoundException;
	
	public Post getPost(Long postId) throws PostNotFoundException;
	
	public Post createPost(Post post, Long userId) throws UserException; 

	public Post deletePost(Long postId) throws PostNotFoundException;
}
