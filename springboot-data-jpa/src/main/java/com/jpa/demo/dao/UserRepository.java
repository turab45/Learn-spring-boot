package com.jpa.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jpa.demo.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer>{
	
	public List<UserEntity> findByName(String name);
	public List<UserEntity> findByStatus(String status);
	public List<UserEntity> findByCity(String city);
	

}
