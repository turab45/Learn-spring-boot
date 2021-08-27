package com.scm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	public List<UserEntity> findByEmail(String email);
}
