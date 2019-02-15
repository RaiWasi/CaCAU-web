package com.airbus.alten.cacau.service;

import com.airbus.alten.cacau.model.ACVersion;

public interface ManageACVersionService {

	public void saveUserConfigurationACVersion(ACVersion acVersion);
	
	public void deleteUserConfigurationACVersion(ACVersion acVersion);
}
