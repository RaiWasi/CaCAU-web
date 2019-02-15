package com.airbus.alten.cacau.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbus.alten.cacau.model.UseCaseConfiguration;
import com.airbus.alten.cacau.model.UserParameter;
import com.airbus.alten.cacau.repository.UserParameterRepository;
import com.airbus.alten.cacau.service.ManageParameterService;

@Service
public class ManageParameterServiceImpl implements ManageParameterService{

	@Autowired
	private UserParameterRepository userParameterRepository;
	
	@Override
	public void saveUserParameter(UserParameter userParameter) {

		List<UserParameter> serachTemporaryList = new ArrayList<UserParameter>();
		
		serachTemporaryList = userParameterRepository.findByParameterIdAndUseCaseConfigurationOrderByStartVersionDesc(userParameter.getParameterId(), userParameter.getUseCaseConfiguration());
		
		if(serachTemporaryList.size() == 0){
			userParameterRepository.save(userParameter);			
		}
		else{
			int tempListID = serachTemporaryList.get(0).getTempListID();
			userParameter.setTempListID(tempListID);
			userParameterRepository.save(userParameter);
		}
		
	}

	@Override
	public void deleteUserParameter(UserParameter userParameter, UseCaseConfiguration useCaseConfiguration) {

		userParameterRepository.deleteUserParameterByParameterIdAndUseCaseConfiguration(userParameter.getParameterId(), useCaseConfiguration);
	}
}
