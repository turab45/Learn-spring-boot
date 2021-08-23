package com.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@PostMapping("/book/add")
	public BookEntity addBook(@RequestBody BookEntity book) {
		bookService.addBook(book);
		return book;
	}
	@DeleteMapping("/books/delete/{id}")
	public String deleteBook(@PathVariable("id") Integer id) {
		bookService.deleteBook(id);
		return "book deleted";
	}
	
	@PutMapping("/books/update/{id}")
	public BookEntity updateBook(@RequestBody BookEntity book, @PathVariable("id") Integer id) {
		
		return bookService.updateBook(book, id);
	}

}
