package com.udemy.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.udemy.course.entities.Order;
import com.udemy.course.entities.User;
import com.udemy.course.repositories.OrderRepository;
import com.udemy.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1  = new User(null, "Maria Brown", "maria@gmail.com", "9999999999", "2223323");
		User u2  = new User(null, "Pedro White", "pedro@hotmail.com", "8888888888", "12345567890");
		
		Order o1 = new Order(null, Instant.parse("2020-06-19T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2020-06-20T15:08:52Z"), u2);
		Order o3 = new Order(null, Instant.parse("2020-06-21T20:32:45Z"), u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}

}
