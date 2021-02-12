package com.meritamerica.teamnine.bankapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.teamnine.bankapp.models.SavingsAccount;


//import com.assignments.assignment7.models.SavingsAccount;

public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Integer> {

}
