package com.scerp.administrationdepartment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.scerp.administrationdepartment.domain.ToDoEvent;
import com.scerp.administrationdepartment.domain.UserEntity;
import com.scerp.administrationdepartment.repository.UserRepository;
import com.scerp.administrationdepartment.service.ToDoService;

@RestController
@RequestMapping("/todo")
public class ToDoController {
	@Autowired
	private ToDoService toDoService;
	
	@Autowired
	private UserRepository userRepository;

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

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String persistPerson(@RequestBody UserEntity userInfo) {
        System.out.println(userInfo.getFirstName());
        System.out.println(userInfo.getLastName());
        System.out.println(userInfo.getPassword());
        System.out.println(userInfo.getUsername());
        userRepository.save(userInfo);
//        todoservice.saveuserinfo(userInfo); this must be the way to insert data using service
        return "success";
    }

	
	@GetMapping
	@RequestMapping("/signup")
	public String test() {
		System.out.println("Anchit");
		return "Anchit";
	}
}