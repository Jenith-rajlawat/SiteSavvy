package com.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.model.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	
	User findByEmailAndPassword(String email,String password);
	
	User findByEmail(String email);
	

}
