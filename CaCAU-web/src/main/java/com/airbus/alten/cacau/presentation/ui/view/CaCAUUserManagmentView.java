package com.airbus.alten.cacau.presentation.ui.view;


import org.springframework.beans.factory.annotation.Autowired;

import com.airbus.alten.cacau.model.User;
import com.airbus.alten.cacau.presentation.ui.manager.CaCAUUIManager;
import com.airbus.alten.cacau.presentation.ui.manager.GenericCaCAUVerticalLayout;
import com.airbus.alten.cacau.security.service.RegisterUserService;
import com.airbus.alten.cacau.security.service.UserServiceImpl;
import com.airbus.alten.cacau.utils.UserRole;
import com.airbus.alten.cacau.utils.UserStatus;
import com.vaadin.annotations.Theme;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
*
* @author  Lazzeri Steve
* @since   2018-05-12
*  
*/

@SpringView(name = CaCAUUserManagmentView.URL_PATH, ui = CaCAUUIManager.class)
@Theme("cacau")
public class CaCAUUserManagmentView extends GenericCaCAUVerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String URL_PATH = "manage-user";
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private RegisterUserService registerUserService;
	
	private static final int BUTTON_WIDTH = 200;
	private static final int BUTTON_HEIGHT = 200;
	
	// Vertical layout in  main content Panel
	private final VerticalLayout mainContentVL = new VerticalLayout();
	
	// user info table and container
	private Table usersInfoTable;
	private BeanContainer<Integer, User> usersInfoTableContainer = new BeanContainer<Integer, User>(User.class);
	
	// Horizontal layout to contain command to change user status, role ore to delete user
	private HorizontalLayout modifificationContentHL = new HorizontalLayout();
	
	private VerticalLayout mod_1_VL = new VerticalLayout();
	private VerticalLayout mod_2_VL = new VerticalLayout();
		
	private final TextField usernameTF = new TextField("Username");
	private final TextField nameTF = new TextField("Name");
	private final TextField surnameTF = new TextField("Surname");
	private final TextField departmentTF = new TextField("Department");
	private final TextField functionTF = new TextField("Function");
	
	private final ComboBox cbStatus = new ComboBox("User status");
	private final ComboBox cbRole = new ComboBox("User Role");
	
	// Confirm and delete button to made change in DB by the Admin
	private final Button confirmBT = new Button("CONFIRM", FontAwesome.CHECK);
	private final Button deleteBT = new Button("DELETE USER", FontAwesome.REMOVE);
	
	// User selectec from table
	private User userOnFocus;

	@Override
	public void entreCaCAU(ViewChangeEvent event) {

		mainContentVL.setMargin(new MarginInfo(true, true, false, true));
		mainContentVL.setSpacing(true);
		
		usersInfoTable = new Table("Users registered");
		usersInfoTable.setSelectable(true);
		usersInfoTable.setWidth(100, Unit.PERCENTAGE);
		usersInfoTable.setMultiSelect(false);
		usersInfoTable.setImmediate(true);
		usersInfoTable.addStyleName("rowheight");
		usersInfoTable.setPageLength(10);
		
		modifificationContentHL.setSpacing(true);
		modifificationContentHL.setWidth(100, Unit.PERCENTAGE);
		modifificationContentHL.setMargin(new MarginInfo(true, true, false, false));
		mod_1_VL.setSpacing(true);
		mod_2_VL.setSpacing(true);

		
		usernameTF.setEnabled(false);
		nameTF.setEnabled(false);
		surnameTF.setEnabled(false);
		functionTF.setEnabled(false);
		departmentTF.setEnabled(false);
		
		cbStatus.setRequired(true);
		cbStatus.setWidth("25%");
		cbStatus.setTextInputAllowed(false);
		cbStatus.setNullSelectionAllowed(true);
		cbStatus.addItems(UserStatus.ENABLE, UserStatus.DISABLE);
		cbStatus.select("");
		cbStatus.setEnabled(false);
		
		cbRole.setRequired(true);
		cbRole.setWidth("25%");
		cbRole.setTextInputAllowed(false);
		cbRole.setNullSelectionAllowed(true);
		cbRole.addItems(UserRole.ADMIN, UserRole.READ_WRITE, UserRole.BASIC);
		cbRole.select("");
		cbRole.setEnabled(false);
		
		confirmBT.setWidth(BUTTON_WIDTH, Unit.PIXELS);
		confirmBT.setHeight(BUTTON_HEIGHT, Unit.PIXELS);
		confirmBT.setEnabled(false);
		confirmBT.addStyleName("friendly");

		
		
		deleteBT.setWidth(BUTTON_WIDTH, Unit.PIXELS);
		deleteBT.setHeight(BUTTON_HEIGHT, Unit.PIXELS);
		deleteBT.setEnabled(false);
		deleteBT.addStyleName("danger");
		
		usersInfoTableContainer.setBeanIdProperty("id");
		usersInfoTableContainer.removeAllItems();
		
		for (User u : userService.loadAllUsersInfo()) {
			usersInfoTableContainer.addBean(u);
		}

		setUsersInfoTableStyleAndFormat();
		
		// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		usersInfoTable.addValueChangeListener(new Property.ValueChangeListener() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
								
				if(event != null && event.getProperty().getValue() != null){
					
					String selectedUserId = event.getProperty().getValue().toString();
					

					if(selectedUserId != null && !selectedUserId.isEmpty()){
						
						for (User u : userService.loadAllUsersInfo()) {

							Integer userId = u.getId();
							
							if(selectedUserId.equals(String.valueOf(userId))){
								
								userOnFocus = u;
								
								usernameTF.setValue(u.getUsername());
								nameTF.setValue(u.getName());
								surnameTF.setValue(u.getSurname());
								departmentTF.setValue(u.getDepartment());
								functionTF.setValue(u.getFunction());
								
								cbRole.setNullSelectionAllowed(false);
								cbStatus.setEnabled(true);
								
								if(UserRole.ADMIN.toString().equals(u.getRole())){
									cbRole.select(UserRole.ADMIN);
								}
								else if(UserRole.READ_WRITE.toString().equals(u.getRole())){
									cbRole.select(UserRole.READ_WRITE);
								}
								else if(UserRole.BASIC.toString().equals(u.getRole())){
									cbRole.select(UserRole.BASIC);
								}
								cbRole.setEnabled(true);
									
								cbStatus.setNullSelectionAllowed(false);
								cbStatus.setEnabled(true);
		
								if(u.isEnabled())
									cbStatus.select(UserStatus.ENABLE);
								else
									cbStatus.select(UserStatus.DISABLE);
								
								
								confirmBT.setEnabled(true);
								deleteBT.setEnabled(true);
								
								Notification.show(u.getUsername() + " has bin selected");
								
								break;
							}
						}	
					}
				}
				else{
					resetMoificationComandStatus();
				}
				
				
			}
		});


		cbStatus.addValueChangeListener(new ValueChangeListener() {
			private static final long serialVersionUID = 1L;
			
			@Override
			public void valueChange(ValueChangeEvent event) {
			}
		});
		
		cbRole.addValueChangeListener(new ValueChangeListener() {
			private static final long serialVersionUID = 1L;
			
			@Override
			public void valueChange(ValueChangeEvent event) {

			}
		});
		
		confirmBT.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;
			
			public void buttonClick(ClickEvent event) {

				if(userOnFocus != null){
					
					userOnFocus.setName(nameTF.getValue());
					userOnFocus.setUsername(usernameTF.getValue());
					userOnFocus.setSurname(surnameTF.getValue());
					userOnFocus.setDepartment(departmentTF.getValue());
					userOnFocus.setFunction(functionTF.getValue());
					userOnFocus.setRole(cbRole.getValue().toString());
					
					if(UserStatus.ENABLE.toString().equals(cbStatus.getValue().toString())){
						userOnFocus.setEnabled(true);
					}
					else
						userOnFocus.setEnabled(false);
					
					registerUserService.updateUserInfo(userOnFocus);
					
					usersInfoTableContainer.removeAllItems();
					
					for (User u : userService.loadAllUsersInfo()) {
						usersInfoTableContainer.addBean(u);
					}

					setUsersInfoTableStyleAndFormat();
					
					
				}
				resetMoificationComandStatus();
				userOnFocus = new User();
				

		    }
		});
		
		
		deleteBT.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;
			
			public void buttonClick(ClickEvent event) {

				if(userOnFocus != null){
					
					userService.deleteUser(userOnFocus);
					
					usersInfoTableContainer.removeAllItems();
					
					for (User u : userService.loadAllUsersInfo()) {
						usersInfoTableContainer.addBean(u);
					}

					setUsersInfoTableStyleAndFormat();
				}
				
				resetMoificationComandStatus();
				userOnFocus = new User();
				
		    }
		});
		

		mod_1_VL.addComponents(usernameTF, nameTF, surnameTF, departmentTF, functionTF);
		mod_2_VL.addComponents(cbStatus, cbRole);
		
		modifificationContentHL.addComponents(mod_1_VL, mod_2_VL, confirmBT, deleteBT);
		modifificationContentHL.setExpandRatio(mod_1_VL, 1);
		modifificationContentHL.setExpandRatio(mod_2_VL, 3);
		modifificationContentHL.setExpandRatio(confirmBT, 1);
		modifificationContentHL.setExpandRatio(deleteBT, 1);

		addComponents(usersInfoTable, modifificationContentHL);
		
		setMargin(true);
		setSpacing(true);
		
	}
	
	private void setUsersInfoTableStyleAndFormat(){
		
		usersInfoTable.setContainerDataSource(usersInfoTableContainer);
		usersInfoTable.setVisibleColumns("username", "name", "surname", "department", "function", "role", "enabled");
		usersInfoTable.setColumnHeaders("USERNAME", "NAME", "SURNAME", "Department", "Function", "ROLE", "STATUS");
		
	}
	
	private void resetMoificationComandStatus(){
		
		confirmBT.setEnabled(false);
		deleteBT.setEnabled(false);
		usernameTF.clear();
		nameTF.clear();
		surnameTF.clear();
		departmentTF.clear();
		functionTF.clear();
		
		cbStatus.setNullSelectionAllowed(true);
		cbStatus.select("");
		cbStatus.setEnabled(false);
		
		cbRole.setNullSelectionAllowed(true);
		cbRole.select("");
		cbRole.setEnabled(false);
		cbStatus.setEnabled(false);

	}
}
