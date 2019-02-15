package com.airbus.alten.cacau.presentation.ui.view;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.airbus.alten.cacau.model.DummyParameter;
import com.airbus.alten.cacau.model.UseCaseConfiguration;
import com.airbus.alten.cacau.model.UserDummyParameter;
import com.airbus.alten.cacau.model.UserParameter;
import com.airbus.alten.cacau.model.business.UseCaseConfigurationBusinessContext;
import com.airbus.alten.cacau.model.business.UserCaCAUContext;
import com.airbus.alten.cacau.model.json.Parameter;
import com.airbus.alten.cacau.presentation.ui.manager.CaCAUUIManager;
import com.airbus.alten.cacau.repository.UseCaseConfigurationRepository;
import com.airbus.alten.cacau.service.ManageDummyParameterService;
import com.airbus.alten.cacau.service.ManageUseCaseConfigurationService;
import com.airbus.alten.cacau.service.ManageUserDummyParameterService;
import com.airbus.alten.cacau.service.envelope.DBEnvelopeResponse;
import com.airbus.alten.cacau.service.envelope.UserDummyServiceEnveloperesponse;
import com.airbus.alten.cacau.utils.AppilcabilityDummyParameter;
import com.airbus.alten.cacau.utils.ServiceEnum;
import com.vaadin.annotations.Theme;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = CaCAUDummyParameter.MAIN_URL, ui = CaCAUUIManager.class)
@Theme("cacau")
public class CaCAUDummyParameter extends VerticalLayout implements View {

	private static final long serialVersionUID = 8392442034382750867L;

	public static final String MAIN_URL = "dummy-parameter";

	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private CaCAUUIManager caCAUUIManager;
	
	@Autowired
	private ManageDummyParameterService manageDummyParameterService;

	@Autowired
	private ManageUserDummyParameterService manageUserDummyParameterService;
	
	private static final int MENU_BUTTONS_SIZE = 200;
	private static final int SIZE = 250; // it was 150
	private static final int HEIGHT = 40;
	private static final int SHORT_FIELD_WIDTH = 100;
	private static final int LONG_FIELD_WIDTH = 400;
	private static final int FIELD_HEIGHT = 30;

	private Panel newDummyPanel = new Panel("Create New Dummy Parameter");
	private Panel tableContentPanel = new Panel();
	
	private Table tbDummyParamaterList = new Table();
	private BeanContainer<Integer, DummyParameter> dummyParamaterListContainer = new BeanContainer<Integer, DummyParameter>(DummyParameter.class);
	
	private Table tbUserSelectedParameterList = new Table();
	private BeanContainer<Integer, UserDummyParameter> temporaryListContainer = new BeanContainer<Integer, UserDummyParameter>(UserDummyParameter.class);
	
	private DummyParameter dummyParameterSelected;
	private UserDummyParameter userDummyParameterSelected;
	
	private UseCaseConfiguration useCaseConfiguration = new UseCaseConfiguration();
	
	private final TextField tfParamName = new TextField("Parameter Name: ");
	private final TextField tfParamDesc = new TextField("Parameter Description: ");
	private final TextField tfEmitter = new TextField("Emitter: ");
	private final TextField tfFIN = new TextField("FIN: ");
	private final TextField tfEquipName = new TextField("Equipment Name: ");
	private final TextField tfSide = new TextField("Side: ");
	private final TextField tfSource = new TextField("Source: ");
	private final TextField tfAta = new TextField("ATA: ");
	private final TextField tfSystem = new TextField("System: ");
	private final TextField tfType = new TextField("Type: ");
	private final TextField tfUnit = new TextField("Unit: ");
	private final TextField tfLabel = new TextField("Label: ");
	private final TextField tfMsb = new TextField("MSB: ");
	private final TextField tfHwPn = new TextField("Hardware Part Number: ");
	private final TextField tfSwPn = new TextField("Software Part Number: ");
	
	private final ComboBox cbApplicability = new ComboBox("Applicability: ");
	
	private final Button bCreate = new Button("Create");
	private final Button bAdd = new Button("Add", FontAwesome.ARROW_DOWN);
	private final Button bDelete = new Button("Delete", FontAwesome.ARROW_UP);
	private final Button bDeleteDP = new Button("Delete DP", FontAwesome.ARROW_UP);
	
	private final String Warning = "PLEASE ENTER VALUE";
	private String parameterNameValue = "";
	private String items = "";
	
	private Item item;

	public void enter(ViewChangeEvent event) {

		setSizeFull();
		setSpacing(true);
		setMargin(true);

		caCAUUIManager.getNewConfigProjectBT().setEnabled(true);
		caCAUUIManager.getNewConfigProjectBT().setStyleName("buttonNormale");
		
		caCAUUIManager.getSearchByCriteriaBT().setEnabled(true);
		caCAUUIManager.getSearchByCriteriaBT().setStyleName("buttonNormale");
		
		caCAUUIManager.getDummyBT().setEnabled(false);
		caCAUUIManager.getDummyBT().setStyleName("buttonSelected");
		
		caCAUUIManager.getAuthorInfoBT().setEnabled(true);
		caCAUUIManager.getAuthorInfoBT().setStyleName("buttonNormale");
		
		caCAUUIManager.getTemporaryParameterBT().setEnabled(true);
		caCAUUIManager.getTemporaryParameterBT().setStyleName("buttonNormale");
		
		caCAUUIManager.getAirlineEquipmentInfoBT().setEnabled(true);
		caCAUUIManager.getAirlineEquipmentInfoBT().setStyleName("buttonNormale");

		//2 MAIN PANELS---------------------------------------------------------------------------------------------------------------------------------------------------
		newDummyPanel.setSizeFull();		
		newDummyPanel.setStyleName("cacaupanel");

		tableContentPanel.setHeight("400px");
		tableContentPanel.setStyleName("cacaupanel");
		
		//Layouts inside 2 MAIN PANELS---------------------------------------------------------------------------------------------------------------------------------------------------
		VerticalLayout mainVLayout = new VerticalLayout();
		mainVLayout.setSpacing(true);
		
		VerticalLayout newDummyVLayout = new VerticalLayout();
		newDummyVLayout.setMargin(true);
		
		VerticalLayout tableContentVLayout = new VerticalLayout();
		tableContentVLayout.setMargin(true);
		
		HorizontalLayout searchHLayout1 = new HorizontalLayout();
		HorizontalLayout searchHLayout2 = new HorizontalLayout();
		HorizontalLayout searchHLayout3 = new HorizontalLayout();
		HorizontalLayout searchHLayout4 = new HorizontalLayout();
		HorizontalLayout searchHLayout5 = new HorizontalLayout();
		HorizontalLayout addDeleteHorizontalLayout = new HorizontalLayout();

		addDeleteHorizontalLayout.setWidth(100, Unit.PERCENTAGE);
		addDeleteHorizontalLayout.setMargin(true);

		searchHLayout1.setSizeFull();
		searchHLayout1.setSpacing(false);
		searchHLayout1.setMargin(false);

		searchHLayout2.setSizeFull();
		searchHLayout2.setSpacing(false);
		searchHLayout2.setMargin(false);

		searchHLayout3.setSizeFull();
		searchHLayout3.setSpacing(false);
		searchHLayout3.setMargin(false);

		searchHLayout4.setSizeFull();
		searchHLayout4.setSpacing(false);
		searchHLayout4.setMargin(false);
		
		searchHLayout5.setSizeFull();
		searchHLayout5.setSpacing(true);
				
		tfParamName.setValue("");
		tfParamName.setWidth(LONG_FIELD_WIDTH, Unit.PIXELS);
		tfParamName.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfParamName.setImmediate(true);
		tfParamName.setRequired(true);
		tfParamName.addValidator(new RegexpValidator("[a-zA-Z][\\sa-zA-Z]{0,127}", Warning));
		
		tfParamDesc.setValue("");
		tfParamDesc.setWidth(LONG_FIELD_WIDTH, Unit.PIXELS);
		tfParamDesc.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfParamDesc.setImmediate(true);
		tfParamDesc.setRequired(true);
		tfParamDesc.addValidator(new RegexpValidator("[a-zA-Z][\\sa-zA-Z]{0,511}", Warning));
		
		tfEmitter.setValue("");
		tfEmitter.setWidth(LONG_FIELD_WIDTH, Unit.PIXELS);
		tfEmitter.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfEmitter.setImmediate(true);
		tfEmitter.setRequired(true);
		tfEmitter.addValidator(new RegexpValidator("[A-Z0-9][\\sA-Z0-9]{0,63}", Warning));
		
		tfFIN.setValue("");
		tfFIN.setWidth(LONG_FIELD_WIDTH, Unit.PIXELS);
		tfFIN.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfFIN.setImmediate(true);
		tfFIN.setRequired(true);
		tfFIN.addValidator(new RegexpValidator("[A-Z0-9][\\sA-Z0-9]{0,15}", Warning));
		
		tfEquipName.setValue("");
		tfEquipName.setWidth(SHORT_FIELD_WIDTH, Unit.PIXELS);
		tfEquipName.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfEquipName.setImmediate(true);
		tfEquipName.setRequired(true);
		tfEquipName.addValidator(new RegexpValidator("[a-zA-Z0-9][\\sa-zA-Z0-9]{0,63}", Warning));
		
		tfSide.setValue("");
		tfSide.setWidth(SHORT_FIELD_WIDTH, Unit.PIXELS);
		tfSide.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfSide.setImmediate(true);
		tfSide.setRequired(true);
		tfSide.addValidator(new RegexpValidator("[0-9][\\s0-9]{0,2}", Warning));
		
		tfSource.setValue("");
		tfSource.setWidth(SHORT_FIELD_WIDTH, Unit.PIXELS);
		tfSource.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfSource.setImmediate(true);
		tfSource.setRequired(true);
		tfSource.addValidator(new RegexpValidator("[A-Z0-9][\\sA-Z0-9]{0,63}", Warning));
		
		tfAta.setValue("");
		tfAta.setWidth(LONG_FIELD_WIDTH, Unit.PIXELS);
		tfAta.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfAta.setImmediate(true);
		tfAta.setRequired(true);
		tfAta.addValidator(new RegexpValidator("[0-9\\.\\-\\s+\\/()]+", Warning));

		tfSystem.setValue("");
		tfSystem.setWidth(LONG_FIELD_WIDTH, Unit.PIXELS);
		tfSystem.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfSystem.setImmediate(true);
		tfSystem.setRequired(true);
		tfSystem.addValidator(new RegexpValidator("[A-Z][\\sA-Z]{0,63}", Warning));
		
		tfType.setValue("");
		tfType.setWidth(SHORT_FIELD_WIDTH, Unit.PIXELS);
		tfType.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfType.setImmediate(true);
		tfType.setRequired(true);
		tfType.addValidator(new RegexpValidator("[A-Z][\\sA-Z]{0,15}", Warning));
		
		tfUnit.setValue("");
		tfUnit.setWidth(SHORT_FIELD_WIDTH, Unit.PIXELS);
		tfUnit.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfUnit.setImmediate(true);
		tfUnit.setRequired(true);
		tfUnit.addValidator(new RegexpValidator("[a-zA-Z0-9][\\sa-zA-Z0-9]{0,31}", Warning));
		
		tfLabel.setValue("");
		tfLabel.setWidth(SHORT_FIELD_WIDTH, Unit.PIXELS);
		tfLabel.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfLabel.setImmediate(true);
		tfLabel.setRequired(true);
		tfLabel.addValidator(new RegexpValidator("[0-9][\\s0-9]{0,2}", Warning));
		
		tfMsb.setValue("");
		tfMsb.setWidth(SHORT_FIELD_WIDTH, Unit.PIXELS);
		tfMsb.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfMsb.setImmediate(true);
		tfMsb.setRequired(true);
		tfMsb.addValidator(new RegexpValidator("[0-9][\\s0-9]{0,7}", Warning));
		
		tfHwPn.setValue("");
		tfHwPn.setWidth(SHORT_FIELD_WIDTH, Unit.PIXELS);
		tfHwPn.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfHwPn.setImmediate(true);
		tfHwPn.setRequired(true);
		tfHwPn.addValidator(new RegexpValidator("[A-Z0-9][\\sA-Z0-9]{0,15}", Warning));
		
		tfSwPn.setValue("");
		tfSwPn.setWidth(SHORT_FIELD_WIDTH, Unit.PIXELS);
		tfSwPn.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfSwPn.setImmediate(true);
		tfSwPn.setRequired(true);
		tfSwPn.addValidator(new RegexpValidator("[a-zA-Z0-9][\\sa-zA-Z0-9]{0,15}", Warning));
		
		cbApplicability.setValue("");
		cbApplicability.setWidth(SHORT_FIELD_WIDTH, Unit.PIXELS);
		cbApplicability.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		cbApplicability.setRequired(true);
		cbApplicability.addItems(EnumSet.allOf(AppilcabilityDummyParameter.class));

		bCreate.setWidth(SIZE, Unit.PIXELS);
		bAdd.setWidth(SIZE, Unit.PIXELS);
		bDelete.setWidth(SIZE, Unit.PIXELS);
		bDeleteDP.setWidth(SIZE, Unit.PIXELS);
		
		//Tables--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

		useCaseConfiguration = applicationContext.getBean(UseCaseConfigurationBusinessContext.class).getUseCaseConfiguration();
		
		dummyParamaterListContainer.setBeanIdProperty("id");
		tbDummyParamaterList = new Table("Created Dummy Parameters");
		tbDummyParamaterList.setWidth(100, Unit.PERCENTAGE);
		tbDummyParamaterList.setSelectable(true);
		tbDummyParamaterList.setImmediate(true);
		tbDummyParamaterList.addStyleName("rowheight");
		tbDummyParamaterList.setPageLength(8);
				
		dummyParamaterListContainer.removeAllItems();

		for (DummyParameter p : manageDummyParameterService.getAllDummyParameter()) {
			dummyParamaterListContainer.addBean(p);
		}

		tbDummyParamaterList.setContainerDataSource(dummyParamaterListContainer);
		setDummyParameterTableProperties();	

		temporaryListContainer.setBeanIdProperty("id");
		tbUserSelectedParameterList = new Table("User selected Dummy Parameters");
		tbUserSelectedParameterList.setWidth(100, Unit.PERCENTAGE);
		tbUserSelectedParameterList.setSelectable(true);
		tbUserSelectedParameterList.setImmediate(true);
		tbUserSelectedParameterList.addStyleName("rowheight");
		tbUserSelectedParameterList.setPageLength(8);
	
		for (UserDummyParameter p : manageUserDummyParameterService.getAllUserDummyParameter().getUserDummyParameters()) {
			temporaryListContainer.addBean(p);
		}

		tbUserSelectedParameterList.setContainerDataSource(temporaryListContainer);
		setUserDummyParameterTableProperties();	
		
		tbDummyParamaterList.addValueChangeListener(new Property.ValueChangeListener() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {

				if(event != null && event.getProperty().getValue() != null){
					
					bDeleteDP.setEnabled(true);
					if(bDeleteDP.isEnabled()) {
						bAdd.setEnabled(true);
					}
					
					String ff = event.getProperty().getValue().toString();
					Integer id = new Integer(ff);
	
					for (DummyParameter p : manageDummyParameterService.getAllDummyParameter()) {
						
						int xx = p.getId().intValue();
						
						if (id.intValue() == xx) {
							dummyParameterSelected = p;
							break;
						}
					}
				}
				else					
					bDeleteDP.setEnabled(false);
					if(!bDeleteDP.isEnabled()) {
						bAdd.setEnabled(false);
					}
			}
		});
		
		
		tbUserSelectedParameterList.addValueChangeListener(new Property.ValueChangeListener() {		
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {

				if(event != null && event.getProperty().getValue() != null){
					
					bDelete.setEnabled(true);
					bDeleteDP.setEnabled(true);
				
					String ff = event.getProperty().getValue().toString();
					Integer id = new Integer(ff);
	

					
					for (UserDummyParameter p : manageUserDummyParameterService.getAllUserDummyParameter().getUserDummyParameters()) {
									
						int xx = p.getId().intValue();
						
						if (id.intValue() == xx) {
							userDummyParameterSelected = p;
							break;
						}
					}
				}
				else
					bDelete.setEnabled(false);
					bDeleteDP.setEnabled(false);
			}
		});
	
		
		//All Textfields Listeners --------------------------------------------------------------------------------------------------------------------------------------------------------
		tfParamName.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfParamName.isValid();
			}
		});
		
		tfParamDesc.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfParamDesc.isValid();
			}
		});
		
		tfEmitter.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfEmitter.isValid();
			}
		});
		
		tfFIN.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfFIN.isValid();
			}
		});
		
		tfEquipName.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfEquipName.isValid();
			}
		});
		
		tfSide.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfSide.isValid();
			}
		});
		
		tfSource.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfSource.isValid();
			}
		});
		
		tfAta.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfAta.isValid();
			}
		});
		
		tfSystem.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfSystem.isValid();
			}
		});
		
		tfType.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfType.isValid();
			}
		});
		
		tfUnit.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfUnit.isValid();
			}
		});
		
		tfLabel.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfLabel.isValid();
			}
		});
		
		tfMsb.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfMsb.isValid();
			}
		});
		
		tfHwPn.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfHwPn.isValid();
			}
		});
		
		tfSwPn.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfSwPn.isValid();
			}
		});
		
		cbApplicability.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				cbApplicability.isValid();
				
			}
		});
		
		//All button click listeners-------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		bCreate.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = -5666247399646245663L;

			public void buttonClick(ClickEvent event) {
				
				DummyParameter dummyParameter = new DummyParameter();
				
				if(!tfParamName.isValid()){
					tfParamName.setRequiredError("PLEASE ENTER VALUE");						
				}
				if(!tfParamDesc.isValid()){
					tfParamDesc.setRequiredError("PLEASE ENTER VALUE");
				}
				if(!tfEmitter.isValid()){
					tfEmitter.setRequiredError("PLEASE ENTER VALUE");
				}
				if(!tfFIN.isValid()){
					tfFIN.setRequiredError("PLEASE ENTER VALUE");
				}
				if(!tfEquipName.isValid()){
					tfEquipName.setRequiredError("PLEASE ENTER VALUE");
				}
				if(!tfSide.isValid()){
					tfSide.setRequiredError("PLEASE ENTER VALUE");
				}
				if(!tfSource.isValid()){
					tfSource.setRequiredError("PLEASE ENTER VALUE");
				}
				if(!tfAta.isValid()){
					tfAta.setRequiredError("PLEASE ENTER VALUE");
				}
				if(!tfSystem.isValid()){
					tfSystem.setRequiredError("PLEASE ENTER VALUE");
				}
				if(!tfType.isValid()){
					tfType.setRequiredError("PLEASE ENTER VALUE");
				}
				if(!tfUnit.isValid()){
					tfUnit.setRequiredError("PLEASE ENTER VALUE");
				}
				if(!tfLabel.isValid()){
					tfLabel.setRequiredError("PLEASE ENTER VALUE");
				}
				if(!tfMsb.isValid()){
					tfMsb.setRequiredError("PLEASE ENTER VALUE");					
				}
				if(!tfHwPn.isValid()){
					tfHwPn.setRequiredError("PLEASE ENTER VALUE");				
				}
				if(!tfSwPn.isValid()){
					tfSwPn.setRequiredError("PLEASE ENTER VALUE");			
				}
				if(!cbApplicability.isValid()) {
					cbApplicability.setRequiredError("PLEASE ENTER VALUE");
				}
				
				
				dummyParameter.setEmitter(tfEmitter.getValue());	
				dummyParameter.setFin(tfFIN.getValue());
				dummyParameter.setEquipmentName(tfEquipName.getValue());
				
				dummyParameter.setSide(tfSide.getValue());
				dummyParameter.setSource(tfSource.getValue());
				dummyParameter.setAta(tfAta.getValue());
				dummyParameter.setSystem(tfSystem.getValue());	
				
				dummyParameter.setType(tfType.getValue());
				dummyParameter.setUnit(tfUnit.getValue());
				dummyParameter.setLabel(tfLabel.getValue());
				dummyParameter.setMsb(tfMsb.getValue());
				
				dummyParameter.setHardwarePartNumber(tfHwPn.getValue());	
				dummyParameter.setSoftwarePartNumber(tfSwPn.getValue());	
				dummyParameter.setParameterDescription(tfParamDesc.getValue());
				dummyParameter.setParameterName(tfParamName.getValue());
				
				if(cbApplicability.getValue() != null)
					dummyParameter.setApplicability(cbApplicability.getValue().toString());
				
				if(cbApplicability.getValue() != null && tfParamName.isValid() && tfParamDesc.isValid() && tfEmitter.isValid() && tfFIN.isValid() && 
						tfEquipName.isValid() && tfSide.isValid()&& tfSource.isValid() && tfAta.isValid() && 
						tfSystem.isValid() && tfType.isValid() && tfUnit.isValid() && tfLabel.isValid() && 
						tfMsb.isValid() && tfHwPn.isValid() && tfSwPn.isValid() && cbApplicability.isValid()) {

					DBEnvelopeResponse response = manageDummyParameterService.saveDummyParameter(dummyParameter);
					
					if(ServiceEnum.OK.equals(response.getDB_SAVE_STATUS())){
						
						dummyParamaterListContainer.removeAllItems();

						for (DummyParameter p : manageDummyParameterService.getAllDummyParameter()) {
							dummyParamaterListContainer.addBean(p);
						}

						tbDummyParamaterList.setContainerDataSource(dummyParamaterListContainer);
						setDummyParameterTableProperties();
					}
					else{
						caCAUUIManager.getAppErrorLB().setValue(response.getMessage());
					}

				}
			}
		});
		
		bAdd.setEnabled(false);	
		bAdd.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = -5666247399646245663L;

			@SuppressWarnings("deprecation")
			public void buttonClick(ClickEvent event) {

				if(dummyParameterSelected != null){
					
					UserDummyParameter userDummyParameter = new UserDummyParameter();
					
					userDummyParameter.setAta(dummyParameterSelected.getAta());
					userDummyParameter.setSystem(dummyParameterSelected.getSystem());
					userDummyParameter.setEmitter(dummyParameterSelected.getEmitter());
					userDummyParameter.setFin(dummyParameterSelected.getFin());
					userDummyParameter.setEquipmentName(dummyParameterSelected.getEquipmentName());
					userDummyParameter.setSide(dummyParameterSelected.getSide());
					userDummyParameter.setSource(dummyParameterSelected.getSource());
					userDummyParameter.setParameterName(dummyParameterSelected.getParameterName());
					userDummyParameter.setParameterDescription(dummyParameterSelected.getParameterDescription());
					userDummyParameter.setType(dummyParameterSelected.getType());
					userDummyParameter.setUnit(dummyParameterSelected.getUnit());
					userDummyParameter.setLabel(dummyParameterSelected.getLabel());
					userDummyParameter.setMsb(dummyParameterSelected.getMsb());
					userDummyParameter.setHardwarePartNumber(dummyParameterSelected.getHardwarePartNumber());
					userDummyParameter.setSoftwarePartNumber(dummyParameterSelected.getSoftwarePartNumber());
					userDummyParameter.setApplicability(dummyParameterSelected.getApplicability());
					userDummyParameter.setUseCaseConfiguration(useCaseConfiguration);	
																																					
					UserDummyServiceEnveloperesponse response = manageUserDummyParameterService.saveUserDummyParameter(userDummyParameter);	
						
					if(ServiceEnum.OK.equals(response.getDB_SAVE_STATUS())) {											
						
					temporaryListContainer.removeAllItems();	
						
						for (UserDummyParameter p : manageUserDummyParameterService.getAllUserDummyParameter().getUserDummyParameters()) {
						
							temporaryListContainer.addBean(p);	
							Notification.show("added");							
						} 																																							
						tbUserSelectedParameterList.setContainerDataSource(temporaryListContainer);
						setUserDummyParameterTableProperties();
						}																
					}										
							
				bAdd.setEnabled(false);		
				if(!bAdd.isEnabled()) {
					bDeleteDP.setEnabled(false);
				}
			}
		});

			
		bDelete.setEnabled(false);
		bDelete.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = -5666247399646245663L;

			public void buttonClick(ClickEvent event) {
				
				if (userDummyParameterSelected != null) {
										
					for (UserDummyParameter p : manageUserDummyParameterService.getAllUserDummyParameter().getUserDummyParameters()) {
						 					
						if (userDummyParameterSelected.getId().intValue() == p.getId().intValue()) {
							manageUserDummyParameterService.deleteUserDummyParameter(p, p.getUseCaseConfiguration());
						}
					}
					
					temporaryListContainer.removeAllItems();					
					for (UserDummyParameter p : manageUserDummyParameterService.getAllUserDummyParameter().getUserDummyParameters()) {
						temporaryListContainer.addBean(p);
					}	

					tbUserSelectedParameterList.setContainerDataSource(temporaryListContainer);
					setUserDummyParameterTableProperties();	
				}				
				bDelete.setEnabled(false);
				Notification.show("The selected Parameter has been removed...");				
			} 				
		});
		
		bDeleteDP.setEnabled(false);
		bDeleteDP.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = -5666247399646245663L;

			public void buttonClick(ClickEvent event) {
				
				if (dummyParameterSelected != null) {
										
					for (DummyParameter p : manageDummyParameterService.getAllDummyParameter()) {
						 					
						if (dummyParameterSelected.getId().intValue() == p.getId().intValue()) {
							manageDummyParameterService.deleteDummyParameter(p);
						}
					}
					
					dummyParamaterListContainer.removeAllItems();					
					for (DummyParameter p : manageDummyParameterService.getAllDummyParameter()) {
						dummyParamaterListContainer.addBean(p);
					}	

					tbDummyParamaterList.setContainerDataSource(dummyParamaterListContainer);
					setDummyParameterTableProperties();	
				}				
				bDeleteDP.setEnabled(false);
				if(!bDeleteDP.isEnabled()) {
					bAdd.setEnabled(false);
				}
				Notification.show("The selected Parameter has been removed...");				
			} 				
		});
		

		// adding the layouts to the main layout------------------------------------------------------------------------------------------------------------------------------------------
		
		mainVLayout.addComponent(newDummyPanel);
		mainVLayout.addComponent(tableContentPanel);
		
		newDummyPanel.setContent(newDummyVLayout);
		newDummyVLayout.addComponent(searchHLayout1);
		newDummyVLayout.addComponent(searchHLayout2);
		newDummyVLayout.addComponent(searchHLayout3);
		newDummyVLayout.addComponent(searchHLayout4);
		newDummyVLayout.addComponent(searchHLayout5);
		
		searchHLayout1.addComponent(tfAta);
		searchHLayout1.addComponent(tfSystem);
		searchHLayout1.addComponent(tfEmitter);
		searchHLayout1.addComponent(tfFIN);
		
		searchHLayout2.addComponent(tfEquipName);
		searchHLayout2.addComponent(tfSide);
		searchHLayout2.addComponent(tfSource);
		searchHLayout2.addComponent(tfParamName);
		
		searchHLayout3.addComponent(tfParamDesc);
		searchHLayout3.addComponent(tfType);
		searchHLayout3.addComponent(tfUnit);
		searchHLayout3.addComponent(tfLabel);
		
		searchHLayout4.addComponent(tfMsb);
		searchHLayout4.addComponent(tfHwPn);
		searchHLayout4.addComponent(tfSwPn);
		searchHLayout4.addComponent(cbApplicability);
		
		searchHLayout5.addComponent(bCreate);
		searchHLayout5.setComponentAlignment(bCreate, Alignment.MIDDLE_CENTER);
		
		tableContentPanel.setContent(tableContentVLayout);
		tableContentVLayout.addComponent(tbDummyParamaterList);	
		tableContentVLayout.addComponent(addDeleteHorizontalLayout);
		tableContentVLayout.addComponent(tbUserSelectedParameterList);
		
		addDeleteHorizontalLayout.addComponent(bAdd);
		addDeleteHorizontalLayout.addComponent(bDelete);
		addDeleteHorizontalLayout.addComponent(bDeleteDP);
		addDeleteHorizontalLayout.setExpandRatio(bAdd, 1);
		addDeleteHorizontalLayout.setExpandRatio(bDelete, 2);
		addDeleteHorizontalLayout.setExpandRatio(bDeleteDP, 3);

		addComponent(mainVLayout);
	}
	

	private void setDummyParameterTableProperties(){
		
		tbDummyParamaterList.setVisibleColumns("parameterName", "parameterDescription", "emitter", "equipmentName", "system", "source", "label", "side", "msb", "applicability", "ata", "fin", "type", "unit", "hardwarePartNumber", "softwarePartNumber");
		tbDummyParamaterList.setColumnHeaders("parameterName", "parameterDescription", "emitter", "equipmentName", "system", "source", "label", "side	", "msb", "applicability", "ata", "fin", "type", "unit", "hardwarePartNumber", "softwarePartNumber");

	}
	
	private void setUserDummyParameterTableProperties(){
			
		tbUserSelectedParameterList.setVisibleColumns("parameterName", "parameterDescription", "emitter", "equipmentName", "system", "source", "label", "side", "msb", "applicability", "ata", "fin", "type", "unit", "hardwarePartNumber", "softwarePartNumber");
		tbUserSelectedParameterList.setColumnHeaders("parameterName", "parameterDescription", "emitter", "equipmentName", "system", "source", "label", "side	", "msb", "applicability", "ata", "fin", "type", "unit", "hardwarePartNumber", "softwarePartNumber");

	}
	
	
}
