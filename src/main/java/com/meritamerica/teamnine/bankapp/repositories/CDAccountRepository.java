package com.meritamerica.teamnine.bankapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.teamnine.bankapp.models.CDAccount;


//import com.assignments.assignment7.models.CDAccount;

public interface CDAccountRepository extends JpaRepository<CDAccount, Integer>{

}
