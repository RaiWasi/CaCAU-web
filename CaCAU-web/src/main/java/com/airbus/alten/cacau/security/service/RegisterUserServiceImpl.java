package com.airbus.alten.cacau.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.airbus.alten.cacau.model.User;
import com.airbus.alten.cacau.model.repository.UserRepository;
import com.airbus.alten.cacau.utils.UserRole;

@Service
public class RegisterUserServiceImpl implements RegisterUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public void save(String username, String password, String name, String surname, String function, String department) {
		User user = new User();
		user.setUsername(username);
		user.setName(name);
		user.setSurname(surname);
		user.setFunction(function);
		user.setDepartment(department);
		user.setEnabled(false);
		user.setRole(UserRole.READ_WRITE);
		user.setPassword(passwordEncoder.encode(password));
		userRepository.save(user);
	}

	@Override
	public void updateUserInfo(User user) {
		userRepository.save(user);
	}

}
