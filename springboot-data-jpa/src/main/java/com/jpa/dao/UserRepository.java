package com.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.jpa.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer>{

}
