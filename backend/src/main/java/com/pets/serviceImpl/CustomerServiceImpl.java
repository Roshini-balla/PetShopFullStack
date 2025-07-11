package com.pets.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pets.entity.Customers;
import com.pets.exceptions.DuplicateIdFoundException;
import com.pets.exceptions.NoSuchDataFoundException;
import com.pets.exceptions.NoSuchIdFoundException;
import com.pets.repository.CustomerRepo;
import com.pets.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo customerRepo;
      
	@Override
	public List<Customers> retreiveAllCustomers() throws NoSuchDataFoundException
	{
		List<Customers> customers = customerRepo.findAll();
		if(customers.isEmpty())
		{
			throw new NoSuchDataFoundException("No customers data found");
		}
		return customers;
		
	}
	
	@Override
	public Customers getCustomerById(int customer_id) throws NoSuchIdFoundException
	{
		try
		{
			Customers customers = customerRepo.findById(customer_id).get();
			return customers;
		}
		catch(NoSuchElementException ex)
		{
			throw new NoSuchIdFoundException("No customer found with this Id");
		}
		
	}

	@Override
	public Customers updateCustomerById(int customerId,Customers updatedCustomers) throws NoSuchIdFoundException
	{
		try
		{
			Customers customers=customerRepo.findById(customerId).get();
			
			customers.setFirstName(updatedCustomers.getFirstName());
			customers.setLastName(updatedCustomers.getLastName());
			customers.setPhoneNumber(updatedCustomers.getPhoneNumber());
			customers.setEmail(updatedCustomers.getEmail());
			customers.setStreet(updatedCustomers.getStreet());
			customers.setCity(updatedCustomers.getCity());
			customers.setState(updatedCustomers.getState());
			customers.setZipCode(updatedCustomers.getZipCode());
			//System.out.println("Data updated successfully");
			return customerRepo.save(customers);
		}
		catch(NoSuchElementException ex)
		{
			throw new NoSuchIdFoundException("No customer found with this Id so customer cannot be updated");
		}
		
	}		


	
	@Override
	public Customers addCustomers(Customers customers) throws DuplicateIdFoundException
	{
		if(customerRepo.existsById(customers.getCustomerId()))
		{
			throw new DuplicateIdFoundException("Customer with Id already exists");
		}
		//System.out.println("Data added successfully");
		return customerRepo.save(customers);		
	}
	
	@Override
	public Customers deleteByCustomerId(int customer_id) throws NoSuchIdFoundException
	{
		try
		{
			Customers customer=customerRepo.findById(customer_id).get();
		    customerRepo.deleteById(customer_id);
		    //System.out.println("Data deleted successfully");
		    return customer;
		}
		catch(NoSuchElementException ex)
		{
			throw new NoSuchIdFoundException("No customer found with this Id so customer cannot be deleted");
		}
	}
	

	
}
