package com.airbus.alten.cacau.service;

import java.util.List;

import com.airbus.alten.cacau.model.UseCaseConfiguration;

public interface ManageUseCaseConfigurationService {

	public List<UseCaseConfiguration> getAllUserUseCaseConfiguration(int userId);
	
	public void saveUserUseCaseConfiguration(UseCaseConfiguration useCaseConfiguration);
	
	public void deleteUserUseCaseConfiguration(int userId, UseCaseConfiguration useCaseConfiguration);
		
	public UseCaseConfiguration getUserUseCaseConfigurationTitle(int userId, String title);
}
