package com.airbus.alten.cacau.service;

import com.airbus.alten.cacau.model.ACApu;

public interface ManageACApuService {

	public void saveUserConfigurationACApu(ACApu acApu);
	
	public void deleteUserConfigurationACApu(ACApu acApu);
}
