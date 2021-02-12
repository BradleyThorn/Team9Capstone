package com.meritamerica.teamnine.bankapp.repositories;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meritamerica.teamnine.bankapp.models.ERole;
import com.meritamerica.teamnine.bankapp.models.Role;

//import com.assignments.assignment7.models.ERole;
//import com.assignments.assignment7.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

	Optional<Role> findByName(ERole name);
}
