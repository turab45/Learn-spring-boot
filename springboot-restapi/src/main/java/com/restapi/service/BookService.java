package com.restapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.restapi.entities.BookEntity;

@Service
public class BookService {

	static List<BookEntity> books = new ArrayList<>();

	static {
		try {
			books.add(new BookEntity(2, "Python", "Guido", 10));
			books.add(new BookEntity(3, "Html", "hmul", 8));
			books.add(new BookEntity(4, "Css", "Guhusido", 7));
			books.add(new BookEntity(5, "JavaScript", "jonh", 3));
			books.add(new BookEntity(6, "Spring boot", "bujie", 34));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<BookEntity> getAllBooks() {
		return books;
	}

	public BookEntity getBookById(Integer id) {
		BookEntity b = null;
		try {
			b = books.stream().filter(e -> e.getId() == id).findFirst().get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public BookEntity addBook(BookEntity book) {
		books.add(book);
		return book;
	}

	public boolean deleteBook(Integer bookId) {

		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getId() == bookId) {
				books.remove(i);
				return true;
			}
		}

		return false;
	}

	public BookEntity updateBook(BookEntity book, Integer id) {

		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getId() == id) {
				book.setId(id);
				books.set(i, book);
				
			}
		}
		return book;

	}

}
