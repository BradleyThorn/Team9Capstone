package com.meritamerica.teamnine.bankapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.teamnine.bankapp.models.DepositTransaction;
import com.meritamerica.teamnine.bankapp.models.Transaction;



public interface DepositTransactionRepository extends JpaRepository<DepositTransaction, Integer>{

	List<Transaction> findByLocation(String location);
	
}
