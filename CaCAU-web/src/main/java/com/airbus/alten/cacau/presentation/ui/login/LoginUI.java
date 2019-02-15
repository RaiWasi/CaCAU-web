package com.airbus.alten.cacau.presentation.ui.login;

import java.io.File;

//import org.apache.log4j.Logger;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path=LoginUI.LOGIN_URL)
@Title("CaCAU Application")
@Theme("valo")
public class LoginUI extends UI{

	private static final long serialVersionUID = 820214523891851218L;
	public static final String LOGIN_URL = "/cacau-login";
	private static final int SIZE = 250;
	private static final int PANEL_WIDTH_SIZE = 700;
	private static final int PANEL_HEIGHT_SIZE = 450;

	@Override
	protected void init(VaadinRequest request) {
		
		VerticalLayout loginWindowsVLayout = new VerticalLayout();
		loginWindowsVLayout.setSizeFull();
		loginWindowsVLayout.setMargin(true);
		
		Panel loginPanel = new Panel("Airbus Digital Solution Login");
		loginPanel.setWidth(PANEL_WIDTH_SIZE, Unit.PIXELS);
		loginPanel.setHeight(PANEL_HEIGHT_SIZE, Unit.PIXELS);
		
		VerticalLayout loginRootVLayout = new VerticalLayout();
		loginRootVLayout.setSizeFull();
		loginRootVLayout.setSpacing(true);
		
		String winUser = "";
		
		TextField userInput = new TextField("Username");
		userInput.setWidth(SIZE, Unit.PIXELS);
		userInput.setValue(winUser = System.getenv("USERNAME"));
		userInput.setEnabled(false);
				
		PasswordField passwordInput = new PasswordField("Password");
		passwordInput.setWidth(SIZE, Unit.PIXELS);
		passwordInput.focus();
		
		Button bLogin = new Button("Login");
		bLogin.setWidth(SIZE, Unit.PIXELS);
		
		loginRootVLayout.addComponent(userInput);
		loginRootVLayout.addComponent(passwordInput);
		loginRootVLayout.addComponent(bLogin);
		
		loginRootVLayout.setComponentAlignment(userInput, Alignment.MIDDLE_CENTER);
		loginRootVLayout.setComponentAlignment(passwordInput, Alignment.MIDDLE_CENTER);
		loginRootVLayout.setComponentAlignment(bLogin, Alignment.MIDDLE_CENTER);
		loginRootVLayout.setExpandRatio(userInput, 2);
		loginRootVLayout.setExpandRatio(passwordInput, 2);
		loginRootVLayout.setExpandRatio(bLogin, 1);
		
		loginPanel.setContent(loginRootVLayout);
		
		// Find the application directory
		String basepath = VaadinService.getCurrent()
		                  .getBaseDirectory().getAbsolutePath();

		FileResource resource = new FileResource(new File(basepath +
						"/WEB-INF/images/CaCAU_Logo.png"));

		// Show the image in the application
		Image logo = new Image(null, resource);
		logo.setWidth(PANEL_WIDTH_SIZE, Unit.PIXELS);
		logo.setWidth(SIZE, Unit.PIXELS);
		
		Label lTitle = new Label("Airbus Digital Solution");
		lTitle.setStyleName("title-style");
		
		loginWindowsVLayout.addComponent(logo);
		loginWindowsVLayout.addComponent(loginPanel);
		
		loginWindowsVLayout.setComponentAlignment(logo,  Alignment.TOP_CENTER);
		loginWindowsVLayout.setComponentAlignment(loginPanel,  Alignment.TOP_CENTER);
		loginWindowsVLayout.setExpandRatio(logo, 1);
		loginWindowsVLayout.setExpandRatio(loginPanel, 3);
	
		setContent(loginWindowsVLayout);
		
	}
}
