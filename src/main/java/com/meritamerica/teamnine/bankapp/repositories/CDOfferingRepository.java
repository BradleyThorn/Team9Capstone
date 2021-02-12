package com.meritamerica.teamnine.bankapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.meritamerica.teamnine.bankapp.models.CDOffering;



public interface CDOfferingRepository extends JpaRepository<CDOffering, Integer> {

	CDOffering findByTerm(Integer term);
}
