package com.airbus.alten.cacau.service.impl;

import javax.validation.ConstraintViolationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbus.alten.cacau.model.UseCaseConfiguration;
import com.airbus.alten.cacau.model.UserDummyParameter;
import com.airbus.alten.cacau.repository.UserDummyParameterRepository;
import com.airbus.alten.cacau.service.ManageUserDummyParameterService;
import com.airbus.alten.cacau.service.envelope.UserDummyServiceEnveloperesponse;
import com.airbus.alten.cacau.utils.ServiceEnum;

@Service
public class ManageUserDummyParameterServiceImpl implements ManageUserDummyParameterService{

	private static Logger LOGGER = LogManager.getLogger(ManageUserDummyParameterServiceImpl.class.getName());
	
	@Autowired
	private UserDummyParameterRepository userDummyParameterRepository;
	
	private String errorID = " ID-MUDPSI ";
	

	@Override
	public UserDummyServiceEnveloperesponse saveUserDummyParameter(UserDummyParameter userDummyParameter) {
		
		UserDummyServiceEnveloperesponse response = new UserDummyServiceEnveloperesponse();
		
		if(userDummyParameter != null) {			
			try { 
				
				userDummyParameterRepository.save(userDummyParameter);
				response.setDB_SAVE_STATUS(ServiceEnum.OK);
				
			} catch (ConstraintViolationException e) { 
				LOGGER.error(e.getMessage() + "error saving Dummy Parameter" + errorID, e);
				response.setMessage("error saving Dummy Parameter" + errorID);
			}
		}
		
		return response;
	}
	
	@Override
	public UserDummyServiceEnveloperesponse deleteUserDummyParameter(UserDummyParameter userDummyParameter, UseCaseConfiguration useCaseConfiguration) {
		
		UserDummyServiceEnveloperesponse response = new UserDummyServiceEnveloperesponse();

		if(userDummyParameter != null) {
			try { 
					
				userDummyParameterRepository.delete(userDummyParameter);
				response.setDB_SAVE_STATUS(ServiceEnum.OK);
				
			} catch (ConstraintViolationException e) { 
					LOGGER.error(e.getMessage() + "error deleting Dummy Parameter" + errorID, e);
					response.setMessage("error deleting Dummy Parameter" + errorID);
				}
			}
		
		return response;
	}


	@Override
	public UserDummyServiceEnveloperesponse getAllUserDummyParameter() {
		
		UserDummyServiceEnveloperesponse response = new UserDummyServiceEnveloperesponse();
		
		response.setUserDummyParameters(userDummyParameterRepository.findAll());
		response.setDB_SAVE_STATUS(ServiceEnum.OK);
		
		return response;
	}

	


}
