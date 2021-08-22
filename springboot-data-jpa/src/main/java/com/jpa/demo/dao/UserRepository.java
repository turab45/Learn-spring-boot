package com.jpa.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.demo.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer>{
	
	public List<UserEntity> findByName(String name);
	public List<UserEntity> findByStatus(String status);
	public List<UserEntity> findByCity(String city);
	
	@Query("select u from UserEntity u")
	public List<UserEntity> getAllUsers();
	
	@Query("select u from UserEntity u where u.name=:n")
	public List<UserEntity> getUserByName(@Param("n") String name);
	

}
