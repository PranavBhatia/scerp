package com.scerp.customerservicedepartment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scerp.customerservicedepartment.domain.ToDoEvent;
import com.scerp.customerservicedepartment.dto.Product;
import com.scerp.customerservicedepartment.repository.ToDoRepository;

@Service
public class ToDoService {
	@Autowired
	private ToDoRepository todoRepository;

	public Iterable<ToDoEvent> getAllnonDoneEvents() {
		return todoRepository.findAll();
	}

}