package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	// autowired -> implicit dependency injection 
	// *ProductResource* -> ProductService -> ProductRepository
	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> findAll(){		
		List<Product> list = productService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	// value = "/{id}" indicates that we're going to pass a value ( id ) inside the url 
	@GetMapping(value = "/{id}")
	// @PathVariable indicates that the args is the value we're going to pass inside the url
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product object = productService.findById(id);
		return ResponseEntity.ok().body(object);
	}
	
}