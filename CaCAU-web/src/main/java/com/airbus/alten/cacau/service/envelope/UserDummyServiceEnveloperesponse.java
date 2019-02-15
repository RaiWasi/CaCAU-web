package com.airbus.alten.cacau.service.envelope;

import java.util.List;

import com.airbus.alten.cacau.model.UserDummyParameter;

public class UserDummyServiceEnveloperesponse extends DBEnvelopeResponse{

	private List<UserDummyParameter> userDummyParameters;

	public List<UserDummyParameter> getUserDummyParameters() {
		return userDummyParameters;
	}

	public void setUserDummyParameters(List<UserDummyParameter> userDummyParameters) {
		this.userDummyParameters = userDummyParameters;
	}
}
