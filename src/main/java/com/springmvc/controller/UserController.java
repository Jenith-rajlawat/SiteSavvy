package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springmvc.model.User;
import com.springmvc.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
		@GetMapping({"/login","/"})
		public String getLogin() {
			
			return "login";
		}
		
		@PostMapping("/login")
		public String postLogin(@ModelAttribute User user,Model model) {
			
			
			User u= userService.userLogin(user.getEmail(),user.getPassword());
			
			if(u!=null) {
			return "home";}
			else {
			
				model.addAttribute("message","Wrong Login Credentials");
				
				return "login";}
		}
		
		
		@GetMapping("/signup")
		public String getSignup() {
			
			return "signup";
		}
		
		@PostMapping("/signup")
		public String postSignup(@ModelAttribute User user,Model model) {
			
			User u =userService.isUserExist(user.getEmail());
			
			if(u==null) {
				userService.userSignup(user);
				return "login";
			}
			
			else {
				model.addAttribute("message", "User already exists!!");
				return "signup";
			}
			
		}
}
