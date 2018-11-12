package com.scerp.salesdepartment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scerp.salesdepartment.domain.ToDoEvent;
import com.scerp.salesdepartment.repository.ToDoRepository;

@Service
public class ToDoService {
	@Autowired
	private ToDoRepository todoRepository;

	public Iterable<ToDoEvent> getAllnonDoneEvents() {
		return todoRepository.findAll();
	}

}