package com.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.model.Post;
import com.springmvc.repository.PostRepository;
import com.springmvc.service.PostService;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	PostRepository postRepository;
	
	
	@Override
	public void postSave(Post post) {
			postRepository.save(post);
		
	}

	@Override
	public void deletePost(Long id) {
			postRepository.deleteById(id);
		
	}

	@Override
	public void editPost(Post post) {
		postRepository.save(post);
		
	}

	@Override
	public Post getById(Long id) {
		return postRepository.findById(id).get();//Optional pathauxa so to get object we do .get()
	}

	@Override
	public List<Post> getAllPost() {
			
		return postRepository.findAll();
	}

}
