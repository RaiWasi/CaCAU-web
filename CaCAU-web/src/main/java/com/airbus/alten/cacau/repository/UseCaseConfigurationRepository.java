package com.airbus.alten.cacau.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airbus.alten.cacau.model.UseCaseConfiguration;

@Repository
public interface UseCaseConfigurationRepository extends JpaRepository<UseCaseConfiguration, Long>{

	public List<UseCaseConfiguration> findByUserId(int userId);
	
	public UseCaseConfiguration findByUserIdAndTitle(int userId, String title);
	
	public void deleteByUserIdAndTitle(int userId, String title);
	
}
