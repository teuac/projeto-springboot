package com.udemy.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.udemy.course.entities.User;
import com.udemy.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1  = new User(null, "Maria Brown", "maria@gmail.com", "9999999999", "2223323");
		User u2  = new User(null, "Pedro White", "pedro@hotmail.com", "8888888888", "12345567890");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}

}
