package com.airbus.alten.cacau.service;

import com.airbus.alten.cacau.model.UseCaseConfiguration;
import com.airbus.alten.cacau.model.UserParameter;

public interface ManageParameterService {

	public void saveUserParameter(UserParameter userParameter);
	
	public void deleteUserParameter(UserParameter userParameter, UseCaseConfiguration useCaseConfiguration);
}
