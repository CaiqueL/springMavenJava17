package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService {
	
	// ProductResource -> *ProductService* -> ProductRepository
	
	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll(){
		return productRepository.findAll();
		
	}
	
	public Product findById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		// .get retorna o objeto do tipo inserido dentro do Optional , ou seja , um product 
		// retornar só o product retornaria um Optional , product.get() retorna um Product
		return product.get();
	}
}
