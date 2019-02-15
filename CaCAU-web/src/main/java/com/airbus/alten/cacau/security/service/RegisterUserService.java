package com.airbus.alten.cacau.security.service;

import com.airbus.alten.cacau.model.User;

public interface RegisterUserService {
	
	public void save(String username, String password, String name, String surname, String function, String department);
	
	public void updateUserInfo(User user);
	
}
