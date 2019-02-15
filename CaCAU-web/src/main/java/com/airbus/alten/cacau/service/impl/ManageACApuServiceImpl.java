package com.airbus.alten.cacau.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbus.alten.cacau.model.ACApu;
import com.airbus.alten.cacau.repository.ACApuRepository;
import com.airbus.alten.cacau.service.ManageACApuService;

@Service
public class ManageACApuServiceImpl implements ManageACApuService{

	@Autowired
	private ACApuRepository acApuRepository;

	@Override
	public void saveUserConfigurationACApu(ACApu acApu) {
		acApuRepository.save(acApu);
	}

	@Override
	public void deleteUserConfigurationACApu(ACApu acApu) {
		acApuRepository.delete(acApu);
	}
}
