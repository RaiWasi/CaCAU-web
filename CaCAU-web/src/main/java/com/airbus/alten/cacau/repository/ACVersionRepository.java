package com.airbus.alten.cacau.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airbus.alten.cacau.model.ACVersion;

@Repository
public interface ACVersionRepository extends JpaRepository<ACVersion, Long>{

}
