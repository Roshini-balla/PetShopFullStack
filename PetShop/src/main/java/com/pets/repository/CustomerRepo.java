package com.pets.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pets.entity.Customers;
import com.pets.entity.Transactions;
import com.pets.enums.transaction_status;

@Repository
public interface CustomerRepo extends JpaRepository<Customers, Integer> {
	
}
