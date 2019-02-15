package com.airbus.alten.cacau.presentation.ui.login;

import org.springframework.beans.factory.annotation.Autowired;

import com.airbus.alten.cacau.security.service.RegisterUserService;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.themes.ValoTheme;

@org.springframework.stereotype.Component
public class SignupFormCaCAUFactory {

	@Autowired
	private RegisterUserService registerUserService;
	
	private class SignupForm {
		
		private VerticalLayout root;
		private Panel panel;
		private TextField usernameTF;
		private TextField nameTF;
		private TextField surnameTF;
		private TextField functionTF;
		private TextField departmentTF;
		private PasswordField passwordFieldTF;
		private PasswordField passwordAgainFieldTF;
		private Button saveButton;
		
		public SignupForm init() {
			
			root = new VerticalLayout();
			root.setMargin(true);
			root.setHeight("100%");
			
			panel = new Panel("Signup");
			panel.setSizeUndefined();
			
			saveButton = new Button("Save");
			saveButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
			
			usernameTF = new TextField("Username");
			usernameTF.isRequired();
			
			nameTF = new TextField("Name");
			nameTF.isRequired();
			
			surnameTF = new TextField("Surname");
			surnameTF.isRequired();
			
			functionTF = new TextField("Function");
			functionTF.isRequired();
			
			departmentTF = new TextField("Department");
			departmentTF.isRequired();
			
			passwordFieldTF = new PasswordField("Password");
			passwordFieldTF.isRequired();
			
			passwordAgainFieldTF = new PasswordField("Password again");
			passwordAgainFieldTF.isRequired();
			
			saveButton.addClickListener(new ClickListener() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void buttonClick(ClickEvent event) {
					
					String username = usernameTF.getValue();
					username = username.trim();
					
					String name = nameTF.getValue();
					name = name.trim();
					
					String surname = surnameTF.getValue();
					surname = surname.trim();
					
					String function = functionTF.getValue();
					function = function.trim();
					
					String department = departmentTF.getValue();
					department = department.trim();
					
					if(username != null && !username.isEmpty() && name != null && !name.isEmpty() && surname != null && !surname.isEmpty() && function != null && !function.isEmpty() && department != null && !department.isEmpty()){
						
						if( !passwordAgainFieldTF.getValue().equals(passwordFieldTF.getValue()) ) {
							Notification.show("Error", "Passwords do not match!", Type.ERROR_MESSAGE);
							return;
						}
						
						registerUserService.save(username, passwordFieldTF.getValue(), name, surname, function, department);
						UI.getCurrent().getPage().setLocation("/CaCAU-App/login");
					}

				}
			});
			
			return this;
		}
		
		
		public Component layout() {
			
			root.addComponent(panel);
			root.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
			
			FormLayout signupLayout = new FormLayout();
			signupLayout.addComponent(usernameTF);
			signupLayout.addComponent(nameTF);
			signupLayout.addComponent(surnameTF);
			signupLayout.addComponent(departmentTF);
			signupLayout.addComponent(functionTF);
			signupLayout.addComponent(passwordFieldTF);
			signupLayout.addComponent(passwordAgainFieldTF);
			
			signupLayout.addComponent(saveButton);
			signupLayout.setSizeUndefined();
			signupLayout.setMargin(true);
			
			panel.setContent(signupLayout);
			
			return root;
		}
	}
	
	public Component createComponent() {
		return new SignupForm().init().layout();
	}
}
