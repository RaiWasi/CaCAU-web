package com.airbus.alten.cacau.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbus.alten.cacau.model.ACEngine;
import com.airbus.alten.cacau.repository.ACEngineRepository;
import com.airbus.alten.cacau.service.ManageACEngineService;

@Service
public class ManageACEngineServiceImpl implements ManageACEngineService{

	@Autowired
	private ACEngineRepository acEngineRepository;

	@Override
	public void saveUserConfigurationACEngine(ACEngine acEngine) {
		acEngineRepository.save(acEngine);
	}

	@Override
	public void deleteUserConfigurationACEngine(ACEngine acEngine) {
		acEngineRepository.delete(acEngine);
	}
}
