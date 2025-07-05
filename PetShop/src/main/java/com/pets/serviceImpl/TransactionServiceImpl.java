package com.pets.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pets.entity.Transactions;
import com.pets.enums.transaction_status;
import com.pets.exceptions.DuplicateIdFoundException;
import com.pets.exceptions.NoFailedTransactionsFoundException;
import com.pets.exceptions.NoSuccessfulTransactionsFoundException;
import com.pets.exceptions.NoSuchDataFoundException;
import com.pets.exceptions.NoSuchIdFoundException;
import com.pets.repository.TransactionRepo;
import com.pets.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepo transaction_repo;
	
	@Override
	public List<Transactions> retreiveAllTransactions() throws NoSuchDataFoundException
	{
		//return transaction_repo.findAll();
		List<Transactions> trans = transaction_repo.findAll();
		if(trans.isEmpty())
		{
			throw new NoSuchDataFoundException("No transactions data found with this Id");
		}
		return trans;
	}
			
	
	//get by transId
	@Override
	public Transactions retreiveTransById(int transactionId) throws NoSuchIdFoundException
	{
		try
		{
			Transactions trans = transaction_repo.findById(transactionId).get();
			return trans;
		}
		catch(NoSuchElementException ex)
		{
			throw new NoSuchIdFoundException("No transaction found with this Id");
		}
	}
	
	@Override
	public List<Transactions> retrieveAllFailedTransactions() throws NoFailedTransactionsFoundException  
	{
        List<Transactions> FailedTransactions = new ArrayList<>();
        //List<Transactions> allTransactions = transactionRepo.findAll();
        for (Transactions transaction : retreiveAllTransactions()) {
            if (transaction.getTransactionStatus() == transaction_status.Failed) {
            	FailedTransactions.add(transaction);
            }
        }
        if (FailedTransactions.isEmpty()) {
       	 throw new NoFailedTransactionsFoundException("No failed transactions found");
       }
        return FailedTransactions;
    }

	

	
	//success
	@Override
	public List<Transactions> retrieveAllSuccessfulTransactions() throws NoSuccessfulTransactionsFoundException  
	{
        List<Transactions> successfulTransactions = new ArrayList<>();
        
        for (Transactions transaction : retreiveAllTransactions()) {
            if (transaction.getTransactionStatus() == transaction_status.Success) {
                successfulTransactions.add(transaction);
            }
        }
        if (successfulTransactions.isEmpty()) {
            throw new NoSuccessfulTransactionsFoundException("No successful transactions found");
        }
        return successfulTransactions;
    }


	@Override
	public Transactions addTransaction(Transactions transaction) throws DuplicateIdFoundException
	{
		if(transaction_repo.existsById(transaction.getTransactionId()))
		{
			throw new DuplicateIdFoundException("Transaction with Id already exists");
		}
	    Transactions t = transaction_repo.save(transaction); 
	    //System.out.println("Data added successfully");
	    return t;
	}
	
	@Override
	public Transactions deleteByTransactionId(int transaction_id) throws NoSuchIdFoundException
	{
		try
		{
			Transactions transaction=transaction_repo.findById(transaction_id).get();
		    transaction_repo.deleteById(transaction_id);
		    //System.out.println("Data deleted successfully");
		    return transaction;
		}
		catch(NoSuchElementException ex)
		{
			throw new NoSuchIdFoundException("No transaction found with this Id so transaction cannot be deleted");
		}
	    
	}
	
}
