package com.prateek.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prateek.DTO.CommentDTO;
import com.prateek.exceptions.CommentNotFoundException;
import com.prateek.exceptions.PostNotFoundException;
import com.prateek.exceptions.UserException;
import com.prateek.models.Comment;
import com.prateek.models.Post;
import com.prateek.models.User;
import com.prateek.models.UserSession;
import com.prateek.repos.CommentRepo;
import com.prateek.repos.PostRepo;
import com.prateek.repos.UserRepo;
import com.prateek.repos.UserSessionRepo;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private UserSessionRepo sessionRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Override
	public CommentDTO addComment(Long postId, Comment comment, Long id) throws PostNotFoundException, UserException {
		// TODO Auto-generated method stub
		Optional<User> ou = userRepo.findById(id);
		if(ou.isPresent())
		{
			Optional<UserSession> ous = sessionRepo.findById(id);
			if(ous.isPresent())
			{
				Optional<Post> op = postRepo.findById(postId);
				if(op.isPresent())
				{
					Post p = op.get();
					User u = ou.get();
					p.getComments().add(comment);
					u.getComments().add(comment);
					comment.setPost(p);
					comment.setUser(u);
					comment.setCreationDate(LocalDateTime.now());
					comment.setUserName(u.getUsername());
					commentRepo.save(comment);
					return new CommentDTO(comment.getMessage());
				}
				throw new PostNotFoundException("No post present with the id "+postId);
				
			}
			throw new UserException("You are not logged in");
		}
		throw new UserException("Invalid user");
	}

	@Override
	public CommentDTO getComment(Long postId, Long commentId) throws PostNotFoundException, CommentNotFoundException {
		// TODO Auto-generated method stub
		Optional<Post> op = postRepo.findById(postId);
		
		if(op.isPresent())
		{
			Post p = op.get();
			List<Comment> comments = p.getComments();
			for(Comment c:comments)
			{
				if(c.getId() == commentId)
				{
					return new CommentDTO(c.getMessage());
				}
			}
			throw new CommentNotFoundException("No comment found on the post with id "+commentId);
		}
		throw new PostNotFoundException("No post found with the id "+postId);
	}

	@Override
	public List<Comment> getAllComments(Long postId) throws PostNotFoundException {
		// TODO Auto-generated method stub
		Optional<Post> op = postRepo.findById(postId);
		if(op.isPresent())
		{
			Post p = op.get();
			return p.getComments();
		}
		throw new PostNotFoundException("No post found with the id "+postId);
	}

	@Override
	public CommentDTO updateComment(Long postId, Long commentId, String msg)
			throws PostNotFoundException, CommentNotFoundException {
		// TODO Auto-generated method stub
		Optional<Post> op = postRepo.findById(postId);
		if(op.isPresent())
		{
			Post p = op.get();
		    Optional<Comment> com =  commentRepo.findById(commentId);
		    if(com.isPresent())
		    {
		    	p.getComments().remove(com.get());
		    	com.get().setMessage(msg);
		    	p.getComments().add(com.get());
		    	commentRepo.save(com.get());
		    	postRepo.save(p);
		    	return new CommentDTO(com.get().getMessage());
		    }
			
			
				
			throw new CommentNotFoundException("No comment found on the post with id "+commentId);
		}
		throw new PostNotFoundException("No post found with the id "+postId);
	}

	@Override
	public CommentDTO deleteComment(Long postId, Long commentId)
			throws PostNotFoundException, CommentNotFoundException {
		// TODO Auto-generated method stub
		
			Optional<Post> op = postRepo.findById(postId);
			if(op.isPresent())
			{
				Post p = op.get();
			    Optional<Comment> com =  commentRepo.findById(commentId);
			    if(com.isPresent())
			    {
			    	List<Comment> copy = p.getComments();
			    	copy.remove(com.get());
			    	p.setComments(copy);
			    	postRepo.save(p);
			    	commentRepo.delete(com.get());
			    	return new CommentDTO(com.get().getMessage());
			    }
				
				
 				
				throw new CommentNotFoundException("No comment found on the post with id "+commentId);
			}
			throw new PostNotFoundException("No post found with the id "+postId);
		}
		
	

}
