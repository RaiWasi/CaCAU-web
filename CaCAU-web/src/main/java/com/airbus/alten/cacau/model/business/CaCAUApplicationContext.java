package com.airbus.alten.cacau.model.business;

import org.springframework.context.annotation.Bean;

public class CaCAUApplicationContext {

	//add a parameter here (add to the table and to this class)
	// this is a temporary saving before the user press the save button
	private String name = "Steve";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
