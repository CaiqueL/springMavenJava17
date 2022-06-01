package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Order;
import com.example.demo.repositories.OrderRepository;

@Service
public class OrderService {
	
	// OrderResource -> *OrderService* -> OrderRepository
	
	@Autowired
	private OrderRepository orderRepository;

	public List<Order> findAll(){
		return orderRepository.findAll();
		
	}
	
	public Order findById(Long id) {
		Optional<Order> order = orderRepository.findById(id);
		// .get retorna o objeto do tipo inserido dentro do Optional , ou seja , um user 
		// retornar só o order retornaria um Optional , user.get() retorna um Order
		return order.get();
	}
}
