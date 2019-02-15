package com.airbus.alten.cacau.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.airbus.alten.cacau.model.UseCaseConfiguration;
import com.airbus.alten.cacau.model.UserParameter;

@Repository
public interface UserParameterRepository extends JpaRepository<UserParameter, Long>{

    @Transactional
	public List<UserParameter> findByParameterIdAndUseCaseConfigurationOrderByStartVersionDesc(int parameterId, UseCaseConfiguration useCaseConfiguration);
    
    @Modifying
    @Transactional
    public void deleteUserParameterByParameterIdAndUseCaseConfiguration(int parameterId, UseCaseConfiguration useCaseConfiguration);
}
