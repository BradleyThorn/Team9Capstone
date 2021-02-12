package com.meritamerica.teamnine.bankapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.teamnine.bankapp.models.DepositTransaction;
import com.meritamerica.teamnine.bankapp.models.Transaction;

//import com.assignments.assignment7.models.AccountHolder;
//import com.assignments.assignment7.models.CDOffering;
//import com.assignments.assignment7.models.DepositTransaction;
//import com.assignments.assignment7.models.Transaction;

public interface DepositTransactionRepository extends JpaRepository<DepositTransaction, Integer>{

	List<Transaction> findByLocation(String location);
	
}
