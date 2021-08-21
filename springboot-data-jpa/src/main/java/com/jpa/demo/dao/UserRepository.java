package com.jpa.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.jpa.demo.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer>{

}
