package com.pets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pets.entity.Transactions;
import com.pets.serviceImpl.TransactionServiceImpl;

@RestController
@CrossOrigin(allowedHeaders="*",origins="*")
@RequestMapping("/api/v1/transactions")
public class TransactionController {
	
	@Autowired
	TransactionServiceImpl transaction_service;
	
    //get all
	@GetMapping
	public List<Transactions> retreiveAll(){
		return transaction_service.retreiveAllTransactions();
	}
	
	//get trans_id
	@GetMapping("/{transaction_id}")
	public Transactions retrieveTransactionId(@PathVariable("transaction_id") int transactionId)
	{
		return transaction_service.retreiveTransById(transactionId);
	}
	
	//get failed
	@GetMapping("/failed")
    public List<Transactions> retrieveCancelledTransactions()
	{
        return transaction_service.retrieveAllFailedTransactions();
    } 
	
	//GET successful
	@GetMapping("/successful")
    public List<Transactions> retrieveSuccessfulTransactions()
	{
        return transaction_service.retrieveAllSuccessfulTransactions();
    } 
	
    //POST
	@PostMapping("/add")
	public Transactions addTransaction(@RequestBody Transactions transaction)
	{
	     return transaction_service.addTransaction(transaction);
	}
	 
	@DeleteMapping("/delete/{transaction_id}")
	public Transactions deleteTransaction(@PathVariable("transaction_id") Integer transaction_id)
	{
	   return transaction_service.deleteByTransactionId(transaction_id);
	}
	
}
