package com.restapi.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.restapi.entities.BookEntity;

public interface BookRepository extends CrudRepository<BookEntity, Integer>{
	public Optional<BookEntity> findById(Integer id);
}
