package com.airbus.alten.cacau.service;

import java.util.List;

import com.airbus.alten.cacau.model.DummyParameter;
import com.airbus.alten.cacau.model.UseCaseConfiguration;
import com.airbus.alten.cacau.model.UserDummyParameter;
import com.airbus.alten.cacau.service.envelope.DBEnvelopeResponse;
import com.airbus.alten.cacau.service.envelope.UserDummyServiceEnveloperesponse;

public interface ManageUserDummyParameterService {

	public UserDummyServiceEnveloperesponse saveUserDummyParameter(UserDummyParameter userDummyParameter); 
	
	public UserDummyServiceEnveloperesponse deleteUserDummyParameter(UserDummyParameter userDummyParameter, UseCaseConfiguration useCaseConfiguration);

	public UserDummyServiceEnveloperesponse getAllUserDummyParameter();
	
}


