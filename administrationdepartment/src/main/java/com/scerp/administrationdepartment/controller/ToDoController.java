package com.scerp.administrationdepartment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.scerp.administrationdepartment.domain.AdminEntity;
import com.scerp.administrationdepartment.domain.EmployeeEntity;
import com.scerp.administrationdepartment.domain.ToDoEvent;
import com.scerp.administrationdepartment.repository.AdminRepository;
import com.scerp.administrationdepartment.repository.EmployeeRepository;
import com.scerp.administrationdepartment.service.ToDoService;

@RestController
@RequestMapping("/")
public class ToDoController {
	@Autowired
	private ToDoService toDoService;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AdminRepository adminRepository;

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
	@RequestMapping("/getProducts")
	public String getProducts() {
		ResponseEntity<String> responseEntity = new RestTemplate()
				.getForEntity("http://localhost:8083/sales/getProducts", String.class);
		return responseEntity.getBody();
	}

	@RequestMapping(value = "/addEmplpoyee", method = RequestMethod.POST)
	public String addEmployee(@RequestBody EmployeeEntity employeeInfo) {
		System.out.println(employeeInfo.getName());
		System.out.println(employeeInfo.getUsername());
		System.out.println(employeeInfo.getPassword());
		System.out.println(employeeInfo.getPhone_number());
		System.out.println(employeeInfo.getEmployeetype());
		System.out.println(employeeInfo.getAddress());
		System.out.println(employeeInfo.getDesignation());
		System.out.println(employeeInfo.getSin_number());
		employeeRepository.save(employeeInfo);
		return "Employee added";
	}
	
	@RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
	public String addAdmin(@RequestBody AdminEntity admin) {
		System.out.println(admin.getUsername());
		System.out.println(admin.getPassword());
		adminRepository.save(admin);
		return "Admin Successfully Added";
		
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
	public String deleteEmployee(@RequestBody EmployeeEntity employeeInfo) {
		System.out.println(employeeInfo.getName());
		System.out.println(employeeInfo.getPassword());
		System.out.println(employeeInfo.getUsername());
		employeeRepository.deleteByUsername(employeeInfo.getUsername());
		return "Employee Deleted";
	}

	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
	public String adminLogin(@RequestBody AdminEntity adminEntity) {
		AdminEntity admin = adminRepository.findByUsername(adminEntity.getUsername());
		if (admin.getPassword().equals(adminEntity.getPassword()))
			return "Login Successful";
		else
			return "Login Un-successful";
	}
	
	@RequestMapping(value = "/employeeLogin", method = RequestMethod.POST)
	public String employeeLogin(@RequestBody EmployeeEntity employeeEntity) {
		EmployeeEntity employee = employeeRepository.findByUsername(employeeEntity.getUsername());
		if (employee.getPassword().equals(employeeEntity.getPassword()))
			return "Login Successful";
		else
			return "Login Un-successful";
	}

	@GetMapping
	@RequestMapping("/signup")
	public String test() {
		System.out.println("Anchit");
		return "Anchit";
	}
}