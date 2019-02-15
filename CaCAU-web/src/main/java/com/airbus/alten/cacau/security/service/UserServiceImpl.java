package com.airbus.alten.cacau.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.airbus.alten.cacau.model.User;
import com.airbus.alten.cacau.model.business.UserCaCAUContext;
import com.airbus.alten.cacau.model.repository.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		
		if(user!= null && user.getRole() != null && user.isEnabled()){
			
			applicationContext.getBean(UserCaCAUContext.class).setUser(user);
			applicationContext.getBean(UserCaCAUContext.class).setSurname(user.getSurname());
			applicationContext.getBean(UserCaCAUContext.class).setUserRole(user.getRole());
			applicationContext.getBean(UserCaCAUContext.class).setUsername(user.getUsername());
			applicationContext.getBean(UserCaCAUContext.class).setName(user.getName());
			applicationContext.getBean(UserCaCAUContext.class).setDepartment(user.getDepartment());
			applicationContext.getBean(UserCaCAUContext.class).setFunction(user.getFunction());
			
			return new CustomUserDetails(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, user.isEnabled(), user.getAuthorities());
		}
		else{
			
			return new CustomUserDetails(user.getUsername(), user.getPassword(), false, false, false, false, user.getAuthorities());
		}
	}
	
	public User findUsername(String username){
		return userRepository.findByUsername(username);
	}
	
	/*
	 * 
	 */
	public List<User> loadAllUsersInfo(){
		return userRepository.findAll();
	}
	
	
	/*
	 *  Service to Delete User from the Application
	 *  @ Input: user seleceted to be deleted. User.class
	 *  @ return: void
	 */
	public void deleteUser(User user){
		userRepository.delete(user);
	}
}