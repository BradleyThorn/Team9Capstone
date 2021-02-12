package com.meritamerica.teamnine.bankapp.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.teamnine.bankapp.models.DBAChecking;




public interface DBACheckingRepository extends JpaRepository<DBAChecking, Integer>{

	void deleteById(Integer id);
}