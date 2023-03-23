package com.spring.models;


import lombok.Data;

@Data
@Entity
public class Book {
  
	@Id
	private Integer bookId;
	private String name;
	private String author;
	private String category;
	private Integer pages;
	private Double price;
	
}
