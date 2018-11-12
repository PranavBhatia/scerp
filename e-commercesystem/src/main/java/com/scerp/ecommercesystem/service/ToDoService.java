package com.scerp.ecommercesystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scerp.ecommercesystem.domain.ToDoEvent;
import com.scerp.ecommercesystem.repository.ToDoRepository;

@Service
public class ToDoService {
	@Autowired
	private ToDoRepository todoRepository;

	public Iterable<ToDoEvent> getAllnonDoneEvents() {
		return todoRepository.findAll();
	}

}