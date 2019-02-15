package com.airbus.alten.cacau.presentation.ui.login;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@SpringUI(path=SignupUICaCAU.PATH)
@Theme("valo")
public class SignupUICaCAU extends UI {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String PATH = "/signup";

	@Autowired
	private SignupFormCaCAUFactory signupFormFactory;
	
	@Override
	protected void init(VaadinRequest request) {
		setContent(signupFormFactory.createComponent());
	}
}
