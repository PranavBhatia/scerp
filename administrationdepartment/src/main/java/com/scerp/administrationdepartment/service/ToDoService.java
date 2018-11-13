package com.scerp.administrationdepartment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.scerp.administrationdepartment.domain.EmployeeEntity;
import com.scerp.administrationdepartment.domain.ToDoEvent;
import com.scerp.administrationdepartment.repository.ToDoRepository;

@Service
public class ToDoService {
	@Autowired
	private ToDoRepository todoRepository;

	@Autowired
	private ToDoRepository employeeRepository;

	public Iterable<ToDoEvent> getAllnonDoneEvents() {
		return todoRepository.findAll();
	}

//	public String save(EmployeeEntity employeeInfo) {
//		employeeRepository.save(employeeInfo);
//		return "Employee added";
//	}

}