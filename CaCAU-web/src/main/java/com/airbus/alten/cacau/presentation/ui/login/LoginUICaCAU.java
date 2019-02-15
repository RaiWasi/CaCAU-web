package com.airbus.alten.cacau.presentation.ui.login;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@SpringUI(path=LoginUICaCAU.PATH)
@Theme("valo")
public class LoginUICaCAU extends UI {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String PATH = "/login";

	@Autowired
	private LoginCaCAUFactory loginFormFactory;
	
	@Override
	protected void init(VaadinRequest request) {
		setContent(loginFormFactory.createComponent());
	}
}
