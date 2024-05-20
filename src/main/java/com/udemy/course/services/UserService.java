package com.udemy.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.udemy.course.entities.User;
import com.udemy.course.repositories.UserRepository;
import com.udemy.course.services.exceptions.DatabaseException;
import com.udemy.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService{
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User user) {
		return repository.save(user);
	}
	
	public void delete(Long id) {
		try {
		 repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch(RuntimeException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	public User update(Long id, User user) {
		try {
		User entity = repository.getReferenceById(id);
		updateData(entity, user);
		return repository.save(entity);
		}
		catch(RuntimeException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setFone(user.getFone());
		
	}

}
