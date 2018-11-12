package com.scerp.customerservicedepartment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scerp.customerservicedepartment.domain.ToDoEvent;
import com.scerp.customerservicedepartment.service.ToDoService;


@RestController
@RequestMapping("/todo")
public class ToDoController {
	@Autowired
	private ToDoService toDoService;

	@GetMapping
	public Iterable<ToDoEvent> getToDoEvent() {
		return toDoService.getAllnonDoneEvents();
	}
	
	@GetMapping
	@RequestMapping("/hello")
	public String getHello() {
		return "hello world";
	}
}