package com.airbus.alten.cacau.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbus.alten.cacau.model.ACVersion;
import com.airbus.alten.cacau.repository.ACVersionRepository;
import com.airbus.alten.cacau.service.ManageACVersionService;

@Service
public class ManageACVersionServiceImpl implements ManageACVersionService{

	@Autowired
	private ACVersionRepository acVersionRepository;

	@Override
	public void saveUserConfigurationACVersion(ACVersion acVersion) {
		acVersionRepository.save(acVersion);
	}

	@Override
	public void deleteUserConfigurationACVersion(ACVersion acVersion) {
		acVersionRepository.delete(acVersion);
	}
}
