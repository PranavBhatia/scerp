package com.scerp.salesdepartment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scerp.salesdepartment.domain.ToDoEvent;
import com.scerp.salesdepartment.repository.OrderRepository;
import com.scerp.salesdepartment.repository.ProductRepository;
import com.scerp.salesdepartment.repository.SalesQueryRepository;
import com.scerp.salesdepartment.repository.ShipmentRepository;
import com.scerp.salesdepartment.repository.ToDoRepository;

@Service
public class ToDoService {
	@Autowired
	private ToDoRepository todoRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private SalesQueryRepository salesQueryRepository;
	
	@Autowired
	private ShipmentRepository shipmentRepository;
	

	public Iterable<ToDoEvent> getAllnonDoneEvents() {
		return todoRepository.findAll();
	}

	
}