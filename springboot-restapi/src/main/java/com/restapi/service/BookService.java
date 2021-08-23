package com.restapi.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.dao.BookRepository;
import com.restapi.entities.BookEntity;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<BookEntity> getAllBooks() {
		List<BookEntity> iterator = (List<BookEntity>) this.bookRepository.findAll();
		return iterator;
	}

	public BookEntity getBookById(Integer id) {
		BookEntity b = null;
		try {
			b = this.bookRepository.findById(id).get();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public BookEntity addBook(BookEntity book) {
		BookEntity bookEntity = bookRepository.save(book);
		return bookEntity;
	}

	public String deleteBook(Integer bookId) {

		bookRepository.deleteById(bookId);
		return "deleted";
	}

	public BookEntity updateBook(BookEntity book, Integer id) {

		BookEntity bookEntity = bookRepository.save(book);
		return bookEntity;

	}

}
