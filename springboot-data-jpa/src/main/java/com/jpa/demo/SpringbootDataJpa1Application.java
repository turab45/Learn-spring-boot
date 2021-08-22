package com.jpa.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.jpa.demo.dao.UserRepository;
import com.jpa.demo.entities.UserEntity;

@SpringBootApplication
public class SpringbootDataJpa1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootDataJpa1Application.class, args);
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		// Save the user
//		UserEntity user = new UserEntity();
//		user.setName("Turab");
//		user.setCity("Islamkot");
//		user.setStatus("Programmer");
//		
//		UserEntity entity = userRepository.save(user);
//		System.out.println(entity);
		
		// update the user
//		UserEntity user = userRepository.findById(2).get();
//		user.setName("Ayoob");
//		user.setCity("Nawbshah");
//		
//		userRepository.save(user);
		//System.out.println(user);
		
		// get all
		
//		Iterable<UserEntity> all = userRepository.findAll();
//		all.forEach(user->{
//			System.out.println(user);
//		}
//		);
//		
		
		// delete the record by id
		
//		userRepository.deleteById(2);
//		
//		System.out.println("Deleted....");
		
		// custom finder methods
		
//		List<UserEntity> list = userRepository.findByCity("uk");
//		
//		list.forEach(user -> {
//			System.out.println(user);
//		});
		
		
		// JPQL
//		List<UserEntity> list = userRepository.getAllUsers();		
//		list.forEach(user -> {
//			System.out.println(user);
//		});
		
		List<UserEntity> list = userRepository.getUserByName("turab");		
		list.forEach(user -> {
			System.out.println(user);
		});
		
		
		
		
		
		
		
		
		
		
		
	}

}
