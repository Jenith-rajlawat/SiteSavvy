package com.springmvc.model;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import jakarta.persistence.Table;

@Entity
@Table
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique =true)
	private String title;
	private String subTitle;
	private String content;
	@DateTimeFormat(iso=ISO.DATE)//YYYY-MM-DD 
	private LocalDate joinDate;
	private Date createdDate;
	@OneToOne
	@JoinColumn(name="userId")//Creates a column in Post named userId with onetoone relation with User
	private User user;
	
	
	
	
	

}
