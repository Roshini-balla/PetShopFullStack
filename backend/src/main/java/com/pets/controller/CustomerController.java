package com.pets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pets.entity.Customers;
import com.pets.serviceImpl.CustomerServiceImpl;

@RestController
@CrossOrigin(allowedHeaders="*",origins="*")

@RequestMapping("/api/v1/customers")
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl customer_service;
	
	
	@GetMapping
	public List<Customers> retreiveAllCustomers(){
		return customer_service.retreiveAllCustomers();
	}

	@GetMapping("/{customer_id}")
	public Customers getCustomerById(@PathVariable int customer_id)
	{
		return customer_service.getCustomerById(customer_id);
	}
	
	@PutMapping("/update/{customers_id}")
	public Customers updateCustomers(@PathVariable("customers_id") Integer customers_id,@RequestBody Customers customers) 
	{
		return customer_service.updateCustomerById(customers_id,customers);
	}
	
	@PostMapping("/add")
	public Customers addCustomers(@RequestBody Customers customers)
	{
		return customer_service.addCustomers(customers);
	}
	
	@DeleteMapping("/delete/{customer_id}")
	public Customers deleteCustomer(@PathVariable("customer_id") Integer customer_id)
	{
	   return customer_service.deleteByCustomerId(customer_id);
	}

}
