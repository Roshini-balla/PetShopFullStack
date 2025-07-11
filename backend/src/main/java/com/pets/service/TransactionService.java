package com.pets.service;

import java.util.List;

import com.pets.entity.Transactions;

public interface TransactionService {

	public List<Transactions> retreiveAllTransactions();
	public List<Transactions> retrieveAllFailedTransactions(); 

	Transactions retreiveTransById(int transactionId);
	Transactions addTransaction(Transactions transaction); 
	
	public List<Transactions> retrieveAllSuccessfulTransactions(); 
	public Transactions deleteByTransactionId(int transaction_id);

}
