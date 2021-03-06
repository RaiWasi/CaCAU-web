package com.airbus.alten.cacau.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airbus.alten.cacau.model.ACEngine;

@Repository
public interface ACEngineRepository extends JpaRepository<ACEngine, Long>{

}
