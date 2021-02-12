package com.meritamerica.teamnine.bankapp.repositories;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.teamnine.bankapp.models.User;



public interface UserRepository extends JpaRepository<User,Integer>{

	Optional<User> findByUsername(String username);
	
	Boolean existsByUsername(String username);
	
}
