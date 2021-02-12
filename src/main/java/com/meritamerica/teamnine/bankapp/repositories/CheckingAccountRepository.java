package com.meritamerica.teamnine.bankapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.teamnine.bankapp.models.CheckingAccount;


//import com.assignments.assignment7.models.CheckingAccount;


public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Integer>{


}
