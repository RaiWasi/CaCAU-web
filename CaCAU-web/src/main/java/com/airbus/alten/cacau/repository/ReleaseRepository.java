package com.airbus.alten.cacau.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airbus.alten.cacau.model.Release;
import com.airbus.alten.cacau.model.UseCaseConfiguration;

public interface ReleaseRepository extends JpaRepository<Release, Long>{

	@Transactional
	public Release findByUseCaseConfiguration(UseCaseConfiguration useCaseConfiguration);
}
