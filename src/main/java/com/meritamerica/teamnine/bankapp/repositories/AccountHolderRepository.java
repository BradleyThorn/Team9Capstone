package com.meritamerica.teamnine.bankapp.repositories;


import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.teamnine.bankapp.models.AccountHolder;


public interface AccountHolderRepository extends JpaRepository<AccountHolder, Integer>{

	Optional<AccountHolder> findById(Integer Id);
}
