package com.airbus.alten.cacau.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airbus.alten.cacau.model.User;

	
@Transactional
public interface UserDAO extends JpaRepository<User, Long>{

	public User findByUsername(String username);
}
