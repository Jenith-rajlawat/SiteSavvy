package com.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Post;



@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
