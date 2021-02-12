package com.meritamerica.teamnine.bankapp.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.teamnine.bankapp.models.Transaction;
import com.meritamerica.teamnine.bankapp.models.WithdrawTransaction;



public interface WithdrawTransactionRepository extends JpaRepository<WithdrawTransaction, Integer>{

	List<Transaction> findByLocation(String location);
}
