package com.scerp.salesdepartment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scerp.salesdepartment.domain.ProductEntity;
import com.scerp.salesdepartment.domain.ToDoEvent;
import com.scerp.salesdepartment.repository.OrderRepository;
import com.scerp.salesdepartment.repository.ProductRepository;
import com.scerp.salesdepartment.repository.SalesQueryRepository;
import com.scerp.salesdepartment.repository.ShipmentRepository;
import com.scerp.salesdepartment.service.ToDoService;


@RestController
@RequestMapping("/")
public class ToDoController {
	@Autowired
	private ToDoService toDoService;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private SalesQueryRepository salesQueryRepository;
	
	@Autowired
	private ShipmentRepository shipmentRepository;
	


	@GetMapping
	public Iterable<ToDoEvent> getToDoEvent() {
		return toDoService.getAllnonDoneEvents();
	}
	
	@GetMapping
	@RequestMapping("/getProducts")
	public String getHello() {
		return productRepository.findAll().toString();
//		return "hello prodcut, we just did inter project communication!";
	}
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(@RequestBody ProductEntity productInfo){
		productRepository.save(productInfo);
		return "Product Added Succesfully";
	}
	
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
	public String deleteProduct(@RequestBody ProductEntity productInfo) {
		productRepository.deleteByproductId(productInfo.getProductId());
		return "Product Deleted Successfully";
	}
	
	/*@RequestMapping(value = "/monitorInventory", method = RequestMethod.POST)
	public String modifyProduct(@RequestBody ProductEntity productInfo) {
		productRepository.setNewQuantityForProduct(productInfo.getQuantity(), productInfo.getProductId());
		return "Product Modified Successfully";
	}*/
	
}