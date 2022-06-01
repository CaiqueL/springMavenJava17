package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
	
	// UserResource -> *UserService* -> UserRepository
	
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll(){
		return userRepository.findAll();
		
	}
	
	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		// .get retorna o objeto do tipo inserido dentro do Optional , ou seja , um user 
		// retornar só o user retornaria um Optional , user.get() retorna um User
		return user.get();
	}
}
