package com.airbus.alten.cacau.service;

import com.airbus.alten.cacau.model.ACEngine;

public interface ManageACEngineService {

	public void saveUserConfigurationACEngine(ACEngine acEngine);
	
	public void deleteUserConfigurationACEngine(ACEngine acEngine);
}
