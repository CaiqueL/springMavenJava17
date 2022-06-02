package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Category;
import com.example.demo.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	// CategoryResource -> *CategoryService* -> CategoryRepository
	
	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> findAll(){
		return categoryRepository.findAll();
		
	}
	
	public Category findById(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		// .get retorna o objeto do tipo inserido dentro do Optional , ou seja , um category 
		// retornar só o category retornaria um Optional , category.get() retorna um Category
		return category.get();
	}
}
