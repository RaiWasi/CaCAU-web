package com.airbus.alten.cacau.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.airbus.alten.cacau.model.User;
import com.airbus.alten.cacau.repository.UserDAO;


@Service
@Repository
public class UserRepositoryImpl {

	@Autowired
	private UserDAO userDAO;
	
	private User userDemo = new User();
	
	@Transactional
	public User getUserByUsername(String username){
		
//		userDemo.setFirstName("Steve");
//		userDemo.setLastName("lastName");
//		userDemo.setEmail("email");
//		userDemo.setHostCode("Host code");
		
//		return userDAO.findByUsername(username);
		
		return userDemo;
	}
	
	@Transactional
	public List<User> getAllUser(){
		return userDAO.findAll();
	}
}
