package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springmvc.model.Post;
import com.springmvc.service.PostService;

@Controller
public class PostController {

	@Autowired
	PostService postService;
	
	@GetMapping("/postform")
	public String getPostForm() {
		
		return "postForm";
	}
	
	@PostMapping("/postform")
	public String postPostForm(@ModelAttribute Post post,Model model) {
		
	if(post!=null) {
		
		postService.postSave(post);
		return "home";}
		
	else {
		
		return "postForm";
	}
	
	}
	
	
	//--------------Displaying all post
	@GetMapping("/posts")
	public String getAllPost(Model model) {
		
		model.addAttribute("pList",postService.getAllPost());
		return "home";
	}

	
}
