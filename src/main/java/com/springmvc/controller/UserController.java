package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springmvc.model.User;
import com.springmvc.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
		@GetMapping({"/login","/"})
		public String getLogin() {
			
			return "login";
		}
		
		@PostMapping("/login")
		public String postLogin(@ModelAttribute User user,Model model,HttpSession session) {
			
			
			User u= userService.userLogin(user.getEmail(),user.getPassword());
			
			if(u!=null) {
				
				session.setAttribute("validUser", u);
				session.setMaxInactiveInterval(200);
			return "home";}
			else {
			
				
				
			//	model.addAttribute("message","Wrong Login Credentials");
				
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
		
		
		//---------------------------------To Logout
		
		
		@GetMapping("/logout")
		public String logout(HttpSession session) {
			
			session.invalidate();//kills session
			return "login";
			
		}
		
		
		
		
		
		
		//----------------------------------About Page
		
		@GetMapping("/about")
		public String getProfile() {
			return "about";
		}
		
		
		
}
