package com.scerp.administrationdepartment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scerp.administrationdepartment.domain.ToDoEvent;
import com.scerp.administrationdepartment.repository.ToDoRepository;

@Service
public class ToDoService {
	@Autowired
	private ToDoRepository todoRepository;

	public Iterable<ToDoEvent> getAllnonDoneEvents() {
		return todoRepository.findAll();
	}

}