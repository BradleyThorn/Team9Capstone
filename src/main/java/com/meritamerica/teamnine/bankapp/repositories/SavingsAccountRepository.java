package com.meritamerica.teamnine.bankapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.teamnine.bankapp.models.SavingsAccount;



public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Integer> {

}
