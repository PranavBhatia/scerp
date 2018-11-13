package com.scerp.customerservicedepartment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.scerp.customerservicedepartment.domain.ToDoEvent;
import com.scerp.customerservicedepartment.service.ToDoService;


@RestController
@RequestMapping("/")
public class ToDoController {
	@Autowired
	private ToDoService toDoService;

	@GetMapping
	public Iterable<ToDoEvent> getToDoEvent() {
		return toDoService.getAllnonDoneEvents();
	}
	
	@GetMapping
	@RequestMapping("/getProduct")
	public String getToDoCustomerEvent() {
		ResponseEntity<String> responseEntity = new RestTemplate()
				.getForEntity("http://localhost:8083/sales/hello", String.class);
		return responseEntity.getBody();
	}
}