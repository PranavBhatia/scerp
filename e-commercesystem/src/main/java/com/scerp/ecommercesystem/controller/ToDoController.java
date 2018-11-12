package com.scerp.ecommercesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scerp.ecommercesystem.domain.ToDoEvent;
import com.scerp.ecommercesystem.service.ToDoService;


@RestController
@RequestMapping("/todo")
public class ToDoController {
	@Autowired
	private ToDoService toDoService;

	@GetMapping
	public Iterable<ToDoEvent> getToDoEvent() {
		return toDoService.getAllnonDoneEvents();
	}
}