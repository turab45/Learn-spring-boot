package com.scm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.entities.ContactEntity;

public interface ContactRepository extends JpaRepository<ContactEntity, Integer>{

}
