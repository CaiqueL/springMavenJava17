package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Order;
import com.example.demo.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	// autowired -> implicit dependency injection 
	// *OrderResource* -> OrderService -> OrderRepository
	@Autowired
	private OrderService orderService;

	@GetMapping
	public ResponseEntity<List<Order>> findAll(){		
		List<Order> list = orderService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	// value = "/{id}" indicates that we're going to pass a value ( id ) inside the url 
	@GetMapping(value = "/{id}")
	// @PathVariable indicates that the args is the value we're going to pass inside the url
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order object = orderService.findById(id);
		return ResponseEntity.ok().body(object);
	}
	
}