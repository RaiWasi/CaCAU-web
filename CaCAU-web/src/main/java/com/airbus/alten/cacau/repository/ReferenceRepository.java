package com.airbus.alten.cacau.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airbus.alten.cacau.model.Reference;
import com.airbus.alten.cacau.model.UseCaseConfiguration;

public interface ReferenceRepository extends JpaRepository<Reference, Long>{
	
	@Transactional
	public Reference findByUseCaseConfiguration(UseCaseConfiguration useCaseConfiguration);
}
