package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Post;

public interface PostService {

	void postSave(Post post);
	void deletePost(Long id);
	void editPost(Post post);
	Post getById(Long id);
	List<Post> getAllPost();
	
	
}
