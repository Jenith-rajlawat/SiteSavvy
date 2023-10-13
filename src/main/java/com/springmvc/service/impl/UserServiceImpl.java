package com.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.model.User;
import com.springmvc.repository.UserRepository;
import com.springmvc.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void userSignup(User user) {
		
		userRepository.save(user);
		
	}

	@Override
	public User userLogin(String email, String password) {
		
		return userRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public User isUserExist(String email) {
		
		return userRepository.findByEmail(email);
	}

}
