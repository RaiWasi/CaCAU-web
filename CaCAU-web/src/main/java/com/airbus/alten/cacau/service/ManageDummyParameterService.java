package com.airbus.alten.cacau.service;

import java.util.List;

import com.airbus.alten.cacau.model.DummyParameter;
import com.airbus.alten.cacau.service.envelope.DBEnvelopeResponse;

public interface ManageDummyParameterService {

	public DBEnvelopeResponse saveDummyParameter(DummyParameter dummyParameter); 
	
	public DBEnvelopeResponse deleteDummyParameter(DummyParameter dummyParameter);
	
	public List<DummyParameter> getAllDummyParameter();


}
