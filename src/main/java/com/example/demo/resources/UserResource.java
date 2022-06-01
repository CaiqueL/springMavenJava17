package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	// autowired -> implicit dependency injection 
	// *UserResource* -> UserService -> UserRepository
	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> findAll(){		
		List<User> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	// value = "/{id}" indicates that we're going to pass a value ( id ) inside the url 
	@GetMapping(value = "/{id}")
	// @PathVariable indicates that the args is the value we're going to pass inside the url
	public ResponseEntity<User> findById(@PathVariable Long id){
		User object = userService.findById(id);
		return ResponseEntity.ok().body(object);
	}
	
}