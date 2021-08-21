package com.jpa.demo;

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
		
		UserEntity user = new UserEntity();
		user.setName("Turab");
		user.setCity("Islamkot");
		user.setStatus("Programmer");
		
		UserEntity entity = userRepository.save(user);
		System.out.println(entity);
	}

}
