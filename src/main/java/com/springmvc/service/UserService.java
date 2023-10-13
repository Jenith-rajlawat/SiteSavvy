package com.springmvc.service;

import com.springmvc.model.User;

public interface UserService {

	void userSignup(User user);
	User userLogin(String email, String password);
	User isUserExist(String email);
	
	
	
}
