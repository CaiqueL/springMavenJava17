package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Category;
import com.example.demo.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	// autowired -> implicit dependency injection 
	// *CategoryResource* -> CategoryService -> CategoryRepository
	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public ResponseEntity<List<Category>> findAll(){		
		List<Category> list = categoryService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	// value = "/{id}" indicates that we're going to pass a value ( id ) inside the url 
	@GetMapping(value = "/{id}")
	// @PathVariable indicates that the args is the value we're going to pass inside the url
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category object = categoryService.findById(id);
		return ResponseEntity.ok().body(object);
	}
	
}