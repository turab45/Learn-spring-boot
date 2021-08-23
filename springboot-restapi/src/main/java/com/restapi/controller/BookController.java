package com.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<BookEntity>> getBooks() {
	
		List<BookEntity> allBooks = bookService.getAllBooks();
		
		if(allBooks.size() <= 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		return ResponseEntity.of(Optional.of(allBooks));
	}
	
	
	@GetMapping("/book/{id}")
	public ResponseEntity<BookEntity> getBook(@PathVariable("id") Integer id) {
		
		BookEntity entity = bookService.getBookById(id);
		
		if(entity != null)
			return ResponseEntity.of(Optional.of(entity));
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}
	
	@PostMapping("/book/add")
	public ResponseEntity<BookEntity> addBook(@RequestBody BookEntity book) {
		try {
			bookService.addBook(book);
			return ResponseEntity.ok().body(book);
		} catch (Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
	}
	@DeleteMapping("/books/delete/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") Integer id) {
		try {
			bookService.deleteBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/books/update/{id}")
	public ResponseEntity<BookEntity> updateBook(@RequestBody BookEntity book, @PathVariable("id") Integer id) {
		
		try {
			BookEntity updateBook = bookService.updateBook(book, id);
			return ResponseEntity.ok().body(updateBook);
		} catch (Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}

