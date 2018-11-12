package com.scerp.administrationdepartment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.scerp.administrationdepartment.domain.ToDoEvent;
import com.scerp.administrationdepartment.service.ToDoService;

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
	@RequestMapping("/customertodo")
	public String getToDoCustomerEvent() {
		ResponseEntity<String> responseEntity = new RestTemplate()
				.getForEntity("http://localhost:8081/customer/todo/hello", String.class);
		return responseEntity.getBody();
	}

	@GetMapping
	@RequestMapping("/test")
	public String test() {
		System.out.println("Anchit");
		return "Anchit";
	}
}