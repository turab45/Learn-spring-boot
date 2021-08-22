package com.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.entities.BookEntity;
import com.restapi.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public List<BookEntity> getBooks() {
		
		return bookService.getAllBooks();
	}
	
	
	@GetMapping("/books/{id}")
	public BookEntity getBook(@PathVariable("id") Integer id) {
		
		return bookService.getBookById(id);
	}
	
	

}
