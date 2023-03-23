package com.prateek.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prateek.exceptions.PostNotFoundException;
import com.prateek.exceptions.UserException;
import com.prateek.models.Post;
import com.prateek.models.User;
import com.prateek.models.UserSession;
import com.prateek.repos.PostRepo;
import com.prateek.repos.UserRepo;
import com.prateek.repos.UserSessionRepo;

@Service
public class PostServiceImpl implements PostService{

	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserSessionRepo sessionRepo;

	@Override
	public List<Post> getAllPosts() throws PostNotFoundException {
		// TODO Auto-generated method stub
		List<Post> posts = postRepo.findAll();
		
		if(posts.size()==0)
		{
			throw new PostNotFoundException("No post present");
		}
		return posts;
	}

	@Override
	public Post getPost(Long postId) throws PostNotFoundException {
		// TODO Auto-generated method stub
		Optional<Post> op = postRepo.findById(postId);
		if(!op.isPresent())
		{
			throw new PostNotFoundException("No post found with the id "+postId);
		}
		return op.get();
	}

	@Override
	public Post createPost(Post post, Long userId) throws UserException {
		// TODO Auto-generated method stub
		Optional<User> ou=userRepo.findById(userId);
		if(ou.get()!=null)
		{
			 UserSession us =  sessionRepo.findById(userId).get();
					 if(us!=null)
					 {
						 User u = ou.get();
						 u.getPosts().add(post);
						 post.setUser(u);
						 post.setPostCreationDate(LocalDateTime.now());
						return  postRepo.save(post);
					 }
					 throw new UserException("You are not logged in");
		}
		throw new UserException("Invalid user");
	}

	@Override
	public Post deletePost(Long postId) throws PostNotFoundException {
		// TODO Auto-generated method stub
		Optional<Post> op = postRepo.findById(postId);
		if(!op.isPresent())
		{
			throw new PostNotFoundException("No post found with the id "+postId);
		}
        postRepo.delete(op.get());
        return op.get();
	}
	
	
	
}
