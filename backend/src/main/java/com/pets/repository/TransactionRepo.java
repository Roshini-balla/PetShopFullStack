package com.pets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pets.entity.Transactions;
import com.pets.enums.transaction_status;

@Repository
public interface TransactionRepo extends JpaRepository<Transactions, Integer>{

	
}
