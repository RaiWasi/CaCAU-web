package com.airbus.alten.cacau.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbus.alten.cacau.model.DummyParameter;
import com.airbus.alten.cacau.repository.DummyParameterRepository;
import com.airbus.alten.cacau.service.ManageDummyParameterService;
import com.airbus.alten.cacau.service.envelope.DBEnvelopeResponse;
import com.airbus.alten.cacau.utils.ServiceEnum;

@Service
public class ManageDummyParameterServiceImpl implements ManageDummyParameterService{

	private static Logger LOGGER = LogManager.getLogger(ManageDummyParameterServiceImpl.class.getName());
	
	@Autowired
	private DummyParameterRepository dummyParameterRepository;

	private String errorID = " ID-MDPSI ";
	
	@Override
	public DBEnvelopeResponse saveDummyParameter(DummyParameter dummyParameter) {
		
		DBEnvelopeResponse response = new DBEnvelopeResponse();
		
		try { 
			
			dummyParameterRepository.save(dummyParameter);
			response.setDB_SAVE_STATUS(ServiceEnum.OK);

			} catch (ConstraintViolationException ex) { 
				LOGGER.error(ex.getMessage() + "File Not Found Error" + errorID, ex);
			} catch(HibernateException ex) {
				LOGGER.error(ex.getMessage() + "File Not Found Error" + errorID, ex);
			} finally{
				response.setMessage("error saving Dummy Parameter" + errorID);
			}

		return response;
	}
	
	@Override
	public DBEnvelopeResponse deleteDummyParameter(DummyParameter dummyParameter) {
		
		DBEnvelopeResponse response = new DBEnvelopeResponse();
		
		try { 
			
			dummyParameterRepository.delete(dummyParameter);
			response.setDB_SAVE_STATUS(ServiceEnum.OK);

			} catch (ConstraintViolationException ex) { 
				LOGGER.error(ex.getMessage() + "File Not Found Error" + errorID, ex);
			} catch(HibernateException ex) {
				LOGGER.error(ex.getMessage() + "File Not Found Error" + errorID, ex);
			} finally{
				response.setMessage("error deleting Dummy Parameter" + errorID);
			}

		return response;
	}

	@Override
	public List<DummyParameter> getAllDummyParameter() {
		return dummyParameterRepository.findAll();
	}


}

