package com.airbus.alten.cacau.presentation.ui.view;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.airbus.alten.cacau.model.UseCaseConfiguration;
import com.airbus.alten.cacau.model.business.UseCaseConfigurationBusinessContext;
import com.airbus.alten.cacau.model.business.UserCaCAUContext;
import com.airbus.alten.cacau.presentation.ui.manager.CaCAUUIManager;
import com.airbus.alten.cacau.presentation.ui.manager.GenericCaCAUHorizontalLayout;
import com.airbus.alten.cacau.service.ManageUseCaseConfigurationService;
import com.airbus.alten.cacau.service.ManageUserInfoService;
import com.vaadin.annotations.Theme;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = CaCAUAirlinesEquipmentView.MAIN_URL, ui = CaCAUUIManager.class)
@Theme("cacau")
public class CaCAUAirlinesEquipmentView extends GenericCaCAUHorizontalLayout implements View {

	private static final long serialVersionUID = 8392442034382750867L;

	public static final String MAIN_URL = "airlinesEqipment";

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private CaCAUUIManager caCAUUIManager;
	
	@Autowired
	private ManageUseCaseConfigurationService manageUseCaseConfigurationService;
	
	@Autowired
	private ManageUserInfoService manageUserInfoService;

	private static final int SIZE = 200;
	private static final int SHORT_FIELD_WIDTH = 100;
	private static final int LONG_FIELD_WIDTH = 280;
	private static final int FIELD_HEIGHT = 30;
	
	private Panel airlinesPanel = new Panel("Airlines Information");
	private Panel equipmentPanel = new Panel("Equipment Information");
	
	private final TextField tfAirlinesIcaoCode = new TextField("ICAO Code");
	private final TextField tfAirlinesTailNum = new TextField("Tail Number");
	private final TextField tfEquipmentName = new TextField("Name");
	private final TextField tfEquipmentFin = new TextField("Fin");
	private final TextField tfEquipmentFd = new TextField("Fd");
	private final TextField tfEquipmentSwpn = new TextField("SWPN");
	private final TextField tfEquipmentHwpn = new TextField("HWPN");
	
	private final String warrning = "PLEASE ENTER VALUE";
	
	private UseCaseConfiguration useCaseConfiguration = new UseCaseConfiguration();
		
	public void entreCaCAU(ViewChangeEvent event) {

		setSizeFull();
		setSpacing(true);
		setMargin(true);
		
		caCAUUIManager.getNewConfigProjectBT().setEnabled(true);
		caCAUUIManager.getNewConfigProjectBT().setStyleName("buttonNormale");
		
		caCAUUIManager.getSearchByCriteriaBT().setEnabled(true);
		caCAUUIManager.getSearchByCriteriaBT().setStyleName("buttonNormale");
		
		caCAUUIManager.getDummyBT().setEnabled(true);
		caCAUUIManager.getDummyBT().setStyleName("buttonNormale");
		
		caCAUUIManager.getAuthorInfoBT().setEnabled(true);
		caCAUUIManager.getAuthorInfoBT().setStyleName("buttonNormale");
		
		caCAUUIManager.getTemporaryParameterBT().setEnabled(true);
		caCAUUIManager.getTemporaryParameterBT().setStyleName("buttonNormale");
		
		caCAUUIManager.getAirlineEquipmentInfoBT().setEnabled(false);
		caCAUUIManager.getAirlineEquipmentInfoBT().setStyleName("buttonSelected");
		
		useCaseConfiguration = manageUseCaseConfigurationService.getUserUseCaseConfigurationTitle(applicationContext.getBean(UserCaCAUContext.class).getUser().getId(), applicationContext.getBean(UseCaseConfigurationBusinessContext.class).getUseCaseConfiguration().getTitle());
		applicationContext.getBean(UseCaseConfigurationBusinessContext.class).setUseCaseConfiguration(useCaseConfiguration);
		
//		authorName.setValue("Name: " + applicationContext.getBean(UserCaCAUContext.class).getSurname() + " " + applicationContext.getBean(UserCaCAUContext.class).getName());
//		authorDepartment.setValue("Department: " + applicationContext.getBean(UserCaCAUContext.class).getDepartment());
//		authorFunction.setValue("Funtion: " + applicationContext.getBean(UserCaCAUContext.class).getFunction());
//		
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
		// all text fields property		
		
		tfAirlinesIcaoCode.setRequired(true);
		tfAirlinesIcaoCode.addValidator(new RegexpValidator("[0-9][\\s0-9]{0,19}", warrning));
		tfAirlinesIcaoCode.setWidth(SHORT_FIELD_WIDTH, Unit.PIXELS);
		tfAirlinesIcaoCode.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfAirlinesIcaoCode.setImmediate(true);
		
		tfAirlinesTailNum.setRequired(true);
		tfAirlinesTailNum.addValidator(new RegexpValidator("[0-9][\\s0-9]{0,19}", warrning));
		tfAirlinesTailNum.setWidth(SHORT_FIELD_WIDTH, Unit.PIXELS);
		tfAirlinesTailNum.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfAirlinesTailNum.setImmediate(true);

		tfEquipmentName.addValidator(new RegexpValidator("[a-zA-Z0-9][\\sa-zA-Z0-9]{0,99}", warrning));
		tfEquipmentName.setWidth(LONG_FIELD_WIDTH, Unit.PIXELS);
		tfEquipmentName.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfEquipmentName.setImmediate(true);

		tfEquipmentFd.addValidator(new RegexpValidator("[a-zA-Z0-9][\\sa-zA-Z0-9]{0,99}", warrning));
		tfEquipmentFd.setWidth(SHORT_FIELD_WIDTH, Unit.PIXELS);
		tfEquipmentFd.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfEquipmentFd.setImmediate(true);
		
		tfEquipmentFin.setRequired(true);
		tfEquipmentFin.addValidator(new RegexpValidator("[a-zA-Z0-9][\\sa-zA-Z0-9]{0,99}", warrning));
		tfEquipmentFin.setWidth(SHORT_FIELD_WIDTH, Unit.PIXELS);
		tfEquipmentFin.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfEquipmentFin.setImmediate(true);
		
		tfEquipmentSwpn.setRequired(true);
		tfEquipmentSwpn.addValidator(new RegexpValidator("[a-zA-Z0-9][\\sa-zA-Z0-9]{0,99}", warrning));
		tfEquipmentSwpn.setWidth(SHORT_FIELD_WIDTH, Unit.PIXELS);
		tfEquipmentSwpn.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfEquipmentSwpn.setImmediate(true);
		
		tfEquipmentHwpn.setRequired(true);
		tfEquipmentHwpn.addValidator(new RegexpValidator("[0-9][\\s0-9]{0,19}", warrning));
		tfEquipmentHwpn.setWidth(LONG_FIELD_WIDTH, Unit.PIXELS);
		tfEquipmentHwpn.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfEquipmentHwpn.setImmediate(true);
		
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
		// all layouts for contents
		
		VerticalLayout contentLeftVLayout = new VerticalLayout();
		contentLeftVLayout.setSpacing(true);
		contentLeftVLayout.setMargin(true);
		
		VerticalLayout contentRightVLayout = new VerticalLayout();
		contentRightVLayout.setSpacing(true);
		contentRightVLayout.setMargin(true);
		

		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		//Airlines Info All Layouts
		VerticalLayout airlinesVLayout = new VerticalLayout();
		airlinesVLayout.setSpacing(true);
		airlinesVLayout.setMargin(true);
		
		HorizontalLayout airlinesInfoHLayout = new HorizontalLayout ();
		airlinesInfoHLayout.setSizeFull();
		airlinesInfoHLayout.setSpacing(true);
		airlinesInfoHLayout.setMargin(true);
		
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		//Equipment Info All Layouts
		VerticalLayout equipmentVLayout = new VerticalLayout();
		equipmentVLayout.setSpacing(true);
		equipmentVLayout.setMargin(true);

		HorizontalLayout equipmentInfo1HLayout = new HorizontalLayout ();
		equipmentInfo1HLayout.setSizeFull();
		equipmentInfo1HLayout.setSpacing(true);
		
		HorizontalLayout equipmentInfo2HLayout = new HorizontalLayout ();
		equipmentInfo2HLayout.setSizeFull();
		equipmentInfo2HLayout.setSpacing(true);
		
		HorizontalLayout equipmentInfo3HLayout = new HorizontalLayout ();
		equipmentInfo3HLayout.setSizeFull();
		equipmentInfo3HLayout.setSpacing(true);
		
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
		//style to all 4 panels	
		
		airlinesPanel.setStyleName("cacauProjectMain");
		airlinesPanel.setWidth(80, Unit.PERCENTAGE);
		airlinesPanel.setHeight(300, Unit.PIXELS);
		
		equipmentPanel.setStyleName("cacauProjectMain");
		equipmentPanel.setWidth(80, Unit.PERCENTAGE);
		equipmentPanel.setHeight(300, Unit.PIXELS);
		
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------/	
		tfAirlinesIcaoCode.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfAirlinesIcaoCode.isValid();
			}
		});
		
		tfAirlinesTailNum.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfAirlinesTailNum.isValid();
			}
		});
		
		tfEquipmentName.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfEquipmentName.isValid();
			}
		});
		
		tfEquipmentFd.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfEquipmentFd.isValid();
			}
		});
		
		tfEquipmentFin.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfEquipmentFin.isValid();
			}
		});
		
		tfEquipmentSwpn.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfEquipmentSwpn.isValid();
			}
		});
		
		tfEquipmentHwpn.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfEquipmentHwpn.isValid();
			}
		});
		
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
		// Save Button Functionality
		final Button bSave = new Button("Save", FontAwesome.FORWARD);
		bSave.setWidth(SIZE, Unit.PIXELS);
		bSave.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = -5666247399646245663L;

			public void buttonClick(ClickEvent event) {
				
				if(!tfAirlinesIcaoCode.isValid()) {
					tfAirlinesIcaoCode.setRequiredError("PLEASE ENTER VALUE");
				}
				
				if(!tfAirlinesTailNum.isValid()) {
					tfAirlinesTailNum.setRequiredError("PLEASE ENTER VALUE");
				}

				if(!tfEquipmentSwpn.isValid()) {
					tfEquipmentSwpn.setRequiredError("PLEASE ENTER VALUE");
				}
				
				if(!tfEquipmentHwpn.isValid()) {
					tfEquipmentHwpn.setRequiredError("PLEASE ENTER VALUE");
				}
				
				if(!tfEquipmentFin.isValid()) {
					tfEquipmentFin.setRequiredError("PLEASE ENTER VALUE");
				}
		
				useCaseConfiguration = manageUseCaseConfigurationService.getUserUseCaseConfigurationTitle(applicationContext.getBean(UserCaCAUContext.class).getUser().getId(), applicationContext.getBean(UseCaseConfigurationBusinessContext.class).getUseCaseConfiguration().getTitle());
			}
		});
			
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
		//adding all components to layout and panel 
		airlinesPanel.setContent(airlinesVLayout);
		equipmentPanel.setContent(equipmentVLayout);
		
		airlinesVLayout.addComponent(airlinesInfoHLayout);
		
		equipmentVLayout.addComponent(equipmentInfo1HLayout);
		equipmentVLayout.addComponent(equipmentInfo2HLayout);
		equipmentVLayout.addComponent(equipmentInfo3HLayout);
		
		airlinesInfoHLayout.addComponent(tfAirlinesIcaoCode);
		airlinesInfoHLayout.addComponent(tfAirlinesTailNum);
		
		equipmentInfo1HLayout.addComponent(tfEquipmentName);
		equipmentInfo2HLayout.addComponent(tfEquipmentHwpn);
		equipmentInfo2HLayout.addComponent(tfEquipmentSwpn);
		equipmentInfo3HLayout.addComponent(tfEquipmentFd);
		equipmentInfo3HLayout.addComponent(tfEquipmentFin);

		contentLeftVLayout.addComponent(airlinesPanel);

		contentLeftVLayout.setComponentAlignment(airlinesPanel, Alignment.TOP_RIGHT);

		contentRightVLayout.addComponent(equipmentPanel);
		contentRightVLayout.addComponent(bSave);

		contentRightVLayout.setComponentAlignment(equipmentPanel, Alignment.TOP_LEFT);
		contentRightVLayout.setComponentAlignment(bSave, Alignment.MIDDLE_CENTER);
		
		addComponent(contentLeftVLayout);
		addComponent(contentRightVLayout);
	}
}
