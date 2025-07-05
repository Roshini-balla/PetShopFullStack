package com.pets.service;

import java.util.List;

import com.pets.entity.Customers;

public interface CustomerService {

	public List<Customers> retreiveAllCustomers();

	public Customers getCustomerById(int customer_id); 

	public Customers addCustomers(Customers customers); 

	public Customers updateCustomerById(int customerId,Customers updatedCustomers);

	public Customers deleteByCustomerId(int customer_id);
	
}
