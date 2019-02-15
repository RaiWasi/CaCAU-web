package com.airbus.alten.cacau.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbus.alten.cacau.model.UseCaseConfiguration;
import com.airbus.alten.cacau.repository.ACApuRepository;
import com.airbus.alten.cacau.repository.ACEngineRepository;
import com.airbus.alten.cacau.repository.ACVersionRepository;
import com.airbus.alten.cacau.repository.UseCaseConfigurationRepository;
import com.airbus.alten.cacau.service.ManageUseCaseConfigurationService;

@Service
public class ManageUseCaseConfigurationServiceImpl implements ManageUseCaseConfigurationService{

	@Autowired
	private UseCaseConfigurationRepository useCaseConfigurationRepository;
	
	@Autowired
	private ACApuRepository acApuRepository;
	
	@Autowired
	private ACVersionRepository acVersionRepository;
	
	@Autowired
	private ACEngineRepository acEngineRepository;
	
	@Override
	public List<UseCaseConfiguration> getAllUserUseCaseConfiguration(int userId) {
		return useCaseConfigurationRepository.findByUserId(userId);
	}

	@Override
	public void saveUserUseCaseConfiguration(UseCaseConfiguration useCaseConfiguration) {
		
		UseCaseConfiguration result = useCaseConfigurationRepository.findByUserIdAndTitle(useCaseConfiguration.getUserId(), useCaseConfiguration.getTitle());
		
		if(result != null){
			return;
		}
		useCaseConfigurationRepository.save(useCaseConfiguration);
		
		acApuRepository.save(useCaseConfiguration.getApus());
		acVersionRepository.save(useCaseConfiguration.getVersions());
		acEngineRepository.save(useCaseConfiguration.getEngines());
	}

	@Override
	public void deleteUserUseCaseConfiguration(int userId, UseCaseConfiguration useCaseConfiguration) {
		
		UseCaseConfiguration result = useCaseConfigurationRepository.findByUserIdAndTitle(userId, useCaseConfiguration.getTitle());
		
		if(result != null){
			useCaseConfigurationRepository.delete(result);
		}
	}

	@Override
	public UseCaseConfiguration getUserUseCaseConfigurationTitle(int userId, String title) {
		
		return useCaseConfigurationRepository.findByUserIdAndTitle(userId, title);
	}


}
