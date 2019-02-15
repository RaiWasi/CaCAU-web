package com.airbus.alten.cacau.presentation.ui.view;


import java.util.EnumSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.airbus.alten.cacau.model.HLDocument;
import com.airbus.alten.cacau.model.Reference;
import com.airbus.alten.cacau.model.Release;
import com.airbus.alten.cacau.model.UseCaseConfiguration;
import com.airbus.alten.cacau.model.business.UseCaseConfigurationBusinessContext;
import com.airbus.alten.cacau.model.business.UserCaCAUContext;
import com.airbus.alten.cacau.presentation.ui.manager.CaCAUUIManager;
import com.airbus.alten.cacau.presentation.ui.manager.GenericCaCAUHorizontalLayout;
import com.airbus.alten.cacau.service.ManageUseCaseConfigurationService;
import com.airbus.alten.cacau.service.ManageUserInfoService;
import com.airbus.alten.cacau.utils.HeaderReleaseStatusEnum;
import com.airbus.alten.cacau.utils.ServiceTypeEnum;
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
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = CaCAUHeader.MAIN_URL, ui = CaCAUUIManager.class)
@Theme("cacau")
public class CaCAUHeader extends GenericCaCAUHorizontalLayout implements View {

	private static final long serialVersionUID = 8392442034382750867L;

	public static final String MAIN_URL = "header";

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
	
	private Panel authorPanel = new Panel("Author Information");
	private Panel releasePanel = new Panel("Release Information");
	private Panel referencePanel = new Panel("Reference Information");
	private Panel hlDocumentPanel = new Panel("HLDocument Information");
	
	private Label authorName = new Label();
	private Label authorDepartment = new Label();
	private Label authorFunction = new Label();
	private Label dateLabel = new Label("Date:");
	
	private PopupDateField releaseDate = new PopupDateField();
	
	private final TextField tfReleaseVersion = new TextField("Version:");
	private final TextField tfReleaseDescription = new TextField("Description:");
	private final TextField tfReferenceTitle = new TextField("Title:");	
	private final TextField tfReferenceNumber = new TextField("Number:");	
	private final TextField tfReferenceIssue = new TextField("Issue:");	
	private final TextField tfReferenceUsecaseNumber = new TextField("UseCase Number:");		
	private final TextField tfHlDocumentTitle = new TextField("Title:");	
	private final TextField tfHlDocumentReference = new TextField("Reference");	
	private final TextField tfHlDocumentIssue = new TextField("Issue");
	
	private final ComboBox cbReleaseStatus = new ComboBox("Status:");	
	private final ComboBox cbReferenceServiceType = new ComboBox("Service Type:");
	
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
		
		caCAUUIManager.getAuthorInfoBT().setEnabled(false);
		caCAUUIManager.getAuthorInfoBT().setStyleName("buttonSelected");
		
		caCAUUIManager.getTemporaryParameterBT().setEnabled(true);
		caCAUUIManager.getTemporaryParameterBT().setStyleName("buttonNormale");
		
		caCAUUIManager.getAirlineEquipmentInfoBT().setEnabled(true);
		caCAUUIManager.getAirlineEquipmentInfoBT().setStyleName("buttonNormale");
		
		useCaseConfiguration = manageUseCaseConfigurationService.getUserUseCaseConfigurationTitle(applicationContext.getBean(UserCaCAUContext.class).getUser().getId(), applicationContext.getBean(UseCaseConfigurationBusinessContext.class).getUseCaseConfiguration().getTitle());
		applicationContext.getBean(UseCaseConfigurationBusinessContext.class).setUseCaseConfiguration(useCaseConfiguration);
		
		authorName.setValue("Name: " + applicationContext.getBean(UserCaCAUContext.class).getSurname() + " " + applicationContext.getBean(UserCaCAUContext.class).getName());
		authorDepartment.setValue("Department: " + applicationContext.getBean(UserCaCAUContext.class).getDepartment());
		authorFunction.setValue("Funtion: " + applicationContext.getBean(UserCaCAUContext.class).getFunction());
		
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
		// all text fields property		
		
		tfReleaseVersion.setRequired(true);
		tfReleaseVersion.addValidator(new RegexpValidator("[a-zA-Z0-9][\\sa-zA-Z0-9]{0,29}", warrning));
		tfReleaseVersion.setWidth(LONG_FIELD_WIDTH, Unit.PIXELS);
		tfReleaseVersion.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfReleaseVersion.setImmediate(true);
		tfReleaseVersion.isValid();
		
		releaseDate.setRequired(true);
		releaseDate.setDateFormat("yyyy-MM-dd");
		releaseDate.setWidth(LONG_FIELD_WIDTH, Unit.PIXELS);
		releaseDate.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		releaseDate.setImmediate(true);
		
		tfReleaseDescription.setRequired(true);
		tfReleaseDescription.addValidator(new RegexpValidator("[a-zA-Z0-9][\\sa-zA-Z0-9]{0,99}", warrning));
		tfReleaseDescription.setWidth(LONG_FIELD_WIDTH, Unit.PIXELS);
		tfReleaseDescription.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfReleaseDescription.setImmediate(true);

		cbReleaseStatus.setRequired(true);
		cbReleaseStatus.setNullSelectionAllowed(false);
		cbReleaseStatus.setInvalidAllowed(false);
		cbReleaseStatus.setWidth(SHORT_FIELD_WIDTH, Unit.PIXELS);
		cbReleaseStatus.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		cbReleaseStatus.addItems(EnumSet.allOf(HeaderReleaseStatusEnum.class));
		
		List<Release> releases = useCaseConfiguration.getReleases();
		
		if(releases.size()>0){
			tfReleaseVersion.setValue(releases.get(0).getVersion());
			tfReleaseDescription.setValue(releases.get(0).getDescription());
			
			if(HeaderReleaseStatusEnum.Final.toString().equals(releases.get(0).getStatus())){
				cbReleaseStatus.select(HeaderReleaseStatusEnum.Final);
			}
			else if(HeaderReleaseStatusEnum.Draft.toString().equals(releases.get(0).getStatus())){
				cbReleaseStatus.select(HeaderReleaseStatusEnum.Draft);
			}
			else{
				cbReleaseStatus.select("");
			}
			releaseDate.setInputPrompt("Select a date");
		}
		else{
			tfReleaseVersion.setValue("");
			tfReleaseDescription.setValue("");
			cbReleaseStatus.select("");
			releaseDate.setInputPrompt("Select a date");
		}
		
		tfReferenceTitle.setRequired(true);
		tfReferenceTitle.addValidator(new RegexpValidator("[a-zA-Z0-9][\\sa-zA-Z0-9]{0,99}", warrning));
		tfReferenceTitle.setWidth(LONG_FIELD_WIDTH, Unit.PIXELS);
		tfReferenceTitle.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfReferenceTitle.setImmediate(true);
		
		tfReferenceNumber.setRequired(true);
		tfReferenceNumber.addValidator(new RegexpValidator("[0-9][\\s0-9]{0,19}", warrning));
		tfReferenceNumber.setWidth(SHORT_FIELD_WIDTH, Unit.PIXELS);
		tfReferenceNumber.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfReferenceNumber.setImmediate(true);
		
		tfReferenceIssue.setRequired(true);
		tfReferenceIssue.addValidator(new RegexpValidator("[a-zA-Z0-9][\\sa-zA-Z0-9]{0,99}", warrning));
		tfReferenceIssue.setWidth(LONG_FIELD_WIDTH, Unit.PIXELS);
		tfReferenceIssue.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfReferenceIssue.setImmediate(true);
		
		tfReferenceUsecaseNumber.setRequired(true);
		tfReferenceUsecaseNumber.addValidator(new RegexpValidator("[0-9][\\s0-9]{0,19}", warrning));
		tfReferenceUsecaseNumber.setWidth(SHORT_FIELD_WIDTH, Unit.PIXELS);
		tfReferenceUsecaseNumber.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfReferenceUsecaseNumber.setImmediate(true);
		
		cbReferenceServiceType.setRequired(true);
		cbReferenceServiceType.setNullSelectionAllowed(false);
		cbReferenceServiceType.setInvalidAllowed(false);
		cbReferenceServiceType.setWidth(LONG_FIELD_WIDTH, Unit.PIXELS);
		cbReferenceServiceType.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		cbReferenceServiceType.addItems(EnumSet.allOf(ServiceTypeEnum.class));
		
		List<Reference> references = useCaseConfiguration.getReferences();
		
		if(references.size()>0){

			tfReferenceTitle.setValue(references.get(0).getTitle());
			tfReferenceNumber.setValue(references.get(0).getNumber());
			tfReferenceIssue.setValue(references.get(0).getIssue());
			tfReferenceUsecaseNumber.setValue("");
			cbReferenceServiceType.setValue("");
			
		}
		else{
			
			tfReferenceTitle.setValue("");
			tfReferenceNumber.setValue("");
			tfReferenceIssue.setValue("");
			tfReferenceUsecaseNumber.setValue("");
			cbReferenceServiceType.setValue("");
		}
		
		tfHlDocumentTitle.setRequired(true);
		tfHlDocumentTitle.addValidator(new RegexpValidator("[a-zA-Z0-9][\\sa-zA-Z0-9]{0,99}", warrning));
		tfHlDocumentTitle.setWidth(LONG_FIELD_WIDTH, Unit.PIXELS);
		tfHlDocumentTitle.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfHlDocumentTitle.setImmediate(true);
		
		tfHlDocumentReference.setRequired(true);
		tfHlDocumentReference.addValidator(new RegexpValidator("[a-zA-Z0-9][\\sa-zA-Z0-9]{0,99}", warrning));
		tfHlDocumentReference.setWidth(LONG_FIELD_WIDTH, Unit.PIXELS);
		tfHlDocumentReference.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfHlDocumentReference.setImmediate(true);	
		
		tfHlDocumentIssue.setRequired(true);
		tfHlDocumentIssue.addValidator(new RegexpValidator("[a-zA-Z0-9][\\sa-zA-Z0-9]{0,99}", warrning));
		tfHlDocumentIssue.setWidth(LONG_FIELD_WIDTH, Unit.PIXELS);
		tfHlDocumentIssue.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		tfHlDocumentIssue.setImmediate(true);

		List<HLDocument> hlDocuments = useCaseConfiguration.getHlDocuments();

		if(hlDocuments.size()>0){

			tfHlDocumentTitle.setValue(hlDocuments.get(0).getTitle());
			tfHlDocumentReference.setValue(hlDocuments.get(0).getReference());
			tfHlDocumentIssue.setValue(hlDocuments.get(0).getIssue());
		}
		else{

			tfHlDocumentTitle.setValue("");
			tfHlDocumentReference.setValue("");
			tfHlDocumentIssue.setValue("");
		}
		
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
		// all layouts for contents
		
		VerticalLayout contentLeftVLayout = new VerticalLayout();
		contentLeftVLayout.setSpacing(true);
		contentLeftVLayout.setMargin(true);
		
		VerticalLayout contentRightVLayout = new VerticalLayout();
		contentRightVLayout.setSpacing(true);
		contentRightVLayout.setMargin(true);
		
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		//Author Info All Layouts
		VerticalLayout authorVLAyout = new VerticalLayout();
		authorVLAyout.setSpacing(true);
		authorVLAyout.setMargin(true);
		
		HorizontalLayout authorInfo1HLayout = new HorizontalLayout ();
		authorInfo1HLayout.setSizeFull();
		authorInfo1HLayout.setSpacing(true);
		authorInfo1HLayout.setMargin(true);
		
		HorizontalLayout authorInfo2HLayout = new HorizontalLayout ();
		authorInfo2HLayout.setSpacing(true);
		authorInfo2HLayout.setMargin(true);
		
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		//Release Info All Layouts
		VerticalLayout releaseVLayout = new VerticalLayout();
		releaseVLayout.setSpacing(true);
		releaseVLayout.setMargin(true);
		
		HorizontalLayout releaseInfo1HLayout = new HorizontalLayout ();
		releaseInfo1HLayout.setSizeFull();
		releaseInfo1HLayout.setSpacing(true);
		
		HorizontalLayout releaseInfo2HLayout = new HorizontalLayout ();
		releaseInfo2HLayout.setSizeFull();
		releaseInfo2HLayout.setSpacing(true);
		
		VerticalLayout releaseInfo3VLayout = new VerticalLayout ();
		releaseInfo3VLayout.setSizeFull();
		releaseInfo3VLayout.setSpacing(true);
		
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		//Reference Info All Layouts
		VerticalLayout referenceVLayout = new VerticalLayout();
		referenceVLayout.setSpacing(true);
		referenceVLayout.setMargin(true);
		
		HorizontalLayout referenceInfo1HLayout = new HorizontalLayout ();
		referenceInfo1HLayout.setSizeFull();
		referenceInfo1HLayout.setSpacing(true);
	
		HorizontalLayout referenceInfo2HLayout = new HorizontalLayout ();
		referenceInfo2HLayout.setSizeFull();
		referenceInfo2HLayout.setSpacing(true);

		HorizontalLayout referenceInfo3HLayout = new HorizontalLayout ();
		referenceInfo3HLayout.setSpacing(true);
		
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		//HLDocument Info All Layouts
		VerticalLayout hlDocumentVLayout = new VerticalLayout();
		hlDocumentVLayout.setSpacing(true);
		hlDocumentVLayout.setMargin(true);
		
		HorizontalLayout hlDocumentInfo1HLayout = new HorizontalLayout ();
		hlDocumentInfo1HLayout.setSizeFull();
		hlDocumentInfo1HLayout.setSpacing(true);

		HorizontalLayout hlDocumentInfo2HLayout = new HorizontalLayout ();
		hlDocumentInfo2HLayout.setSpacing(true);

		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
		//style to all 4 panels	
		authorPanel.setStyleName("cacauProjectMain");
		authorPanel.setWidth(80, Unit.PERCENTAGE);
		authorPanel.setHeight(300, Unit.PIXELS);
				
		releasePanel.setStyleName("cacauProjectMain");
		releasePanel.setWidth(80, Unit.PERCENTAGE);
		releasePanel.setHeight(300, Unit.PIXELS);
		
		referencePanel.setStyleName("cacauProjectMain");
		referencePanel.setWidth(80, Unit.PERCENTAGE);
		referencePanel.setHeight(300, Unit.PIXELS);
				
		hlDocumentPanel.setStyleName("cacauProjectMain");
		hlDocumentPanel.setWidth(80, Unit.PERCENTAGE);
		hlDocumentPanel.setHeight(300, Unit.PIXELS);

		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
		
		tfReleaseVersion.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfReleaseVersion.isValid();
			}
		});
		
		releaseDate.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				releaseDate.isValid();
			}
		});
		
		tfReleaseDescription.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfReleaseDescription.isValid();
			}
		});
		
		cbReleaseStatus.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				cbReleaseStatus.isValid();
				
			}
		});
		
		tfReferenceTitle.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfReferenceTitle.isValid();
			}
		});
		
		tfReferenceNumber.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfReferenceNumber.isValid();
			}
		});
		
		tfReferenceIssue.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfReferenceIssue.isValid();
			}
		});
			
		tfReferenceUsecaseNumber.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfReferenceUsecaseNumber.isValid();
			}
		});
		
		cbReferenceServiceType.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				cbReferenceServiceType.isValid();
			}
		});

		tfHlDocumentTitle.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfHlDocumentTitle.isValid();
			}
		});
		
		tfHlDocumentReference.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfHlDocumentReference.isValid();
			}
		});
		
		tfHlDocumentIssue.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				tfHlDocumentIssue.isValid();
			}
		});
		
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
		// Save Button Functionality
		final Button bSave = new Button("Save", FontAwesome.FORWARD);
		bSave.setWidth(SIZE, Unit.PIXELS);
		bSave.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = -5666247399646245663L;

			public void buttonClick(ClickEvent event) {
				
				if(tfReleaseVersion.isValid()){
					tfReleaseVersion.setValue(tfReleaseVersion.getValue());
				} else{
					tfReleaseVersion.setRequiredError("PLEASE ENTER VALUE");
				}
				
				if(!releaseDate.isValid()) {
					releaseDate.setRequiredError("PLEASE ENTER VALUE");
				}
				
				if(tfReleaseDescription.isValid()) {
					tfReleaseDescription.setValue(tfReleaseDescription.getValue());
				} else {
					tfReleaseDescription.setRequiredError("PLEASE ENTER VALUE");
				}
				
				if(!cbReleaseStatus.isValid()) {
					cbReleaseStatus.setRequiredError("PLEASE ENTER VALUE");
				}
				
				if(tfReleaseVersion.isValid() && releaseDate.isValid() && tfReleaseDescription.isValid() && cbReleaseStatus.isValid()){
					
					Release release = new Release();
					release.setVersion(tfReleaseVersion.getValue());
					release.setDescription(tfReleaseDescription.getValue());
					release.setStatus(cbReleaseStatus.getValue().toString());
					release.setUseCaseConfiguration(useCaseConfiguration);
					manageUserInfoService.saveRelease(release,useCaseConfiguration);
				}
							
				if(!tfReferenceTitle.isValid()) {
					tfReferenceTitle.setRequiredError("PLEASE ENTER VALUE");
				}
				
				if(!tfReferenceNumber.isValid()) {
					tfReferenceNumber.setRequiredError("PLEASE ENTER VALUE");
				}
				
				if(!tfReferenceIssue.isValid()) {
					tfReferenceIssue.setRequiredError("PLEASE ENTER VALUE");
				}
				
				if(!tfReferenceUsecaseNumber.isValid()) {
					tfReferenceUsecaseNumber.setRequiredError("PLEASE ENTER VALUE");
				}
				
				if(!cbReferenceServiceType.isValid()) {
					cbReferenceServiceType.setRequiredError("PLEASE ENTER VALUE");
				}
				
				if(tfReferenceTitle.isValid() && tfReferenceNumber.isValid() && tfReferenceIssue.isValid() && tfReferenceUsecaseNumber.isValid() && cbReferenceServiceType.isValid()){
					
					Reference reference = new Reference();
					reference.setIssue(tfReferenceIssue.getValue());
					reference.setTitle(tfReferenceTitle.getValue());
					reference.setNumber(tfReferenceNumber.getValue());
					reference.setUseCaseConfiguration(useCaseConfiguration);
					reference.setService(cbReleaseStatus.getValue().toString());

					// ???? Question to David
					tfReferenceUsecaseNumber.getValue();
					
					manageUserInfoService.saveReference(reference, useCaseConfiguration);
				}
				
				if(!tfHlDocumentTitle.isValid()) {
					tfHlDocumentTitle.setRequiredError("PLEASE ENTER VALUE");
				}
				
				if(!tfHlDocumentReference.isValid()) {
					tfHlDocumentReference.setRequiredError("PLEASE ENTER VALUE");
				}
				
				if(!tfHlDocumentIssue.isValid()) {
					tfHlDocumentIssue.setRequiredError("PLEASE ENTER VALUE");
				}
				
				if(tfHlDocumentTitle.isValid() && tfHlDocumentReference.isValid() && tfHlDocumentIssue.isValid()){
			
					HLDocument hlDocument = new HLDocument();
					hlDocument.setTitle(tfHlDocumentTitle.getValue());
					hlDocument.setReference(tfHlDocumentReference.getValue());
					hlDocument.setIssue(tfHlDocumentIssue.getValue());
					hlDocument.setUseCaseConfiguration(useCaseConfiguration);
					manageUserInfoService.saveHLDocument(hlDocument, useCaseConfiguration);
					
				}

				useCaseConfiguration = manageUseCaseConfigurationService.getUserUseCaseConfigurationTitle(applicationContext.getBean(UserCaCAUContext.class).getUser().getId(), applicationContext.getBean(UseCaseConfigurationBusinessContext.class).getUseCaseConfiguration().getTitle());
			}
		});
			
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
		//adding all components to layout and panel 
		authorPanel.setContent(authorVLAyout);
		referencePanel.setContent(referenceVLayout);		
		releasePanel.setContent(releaseVLayout);		
		hlDocumentPanel.setContent(hlDocumentVLayout);
				
		authorVLAyout.addComponent(authorInfo1HLayout);
		authorVLAyout.addComponent(authorInfo2HLayout);
		
		referenceVLayout.addComponent(referenceInfo1HLayout);
		referenceVLayout.addComponent(referenceInfo2HLayout);
		referenceVLayout.addComponent(referenceInfo3HLayout);

		releaseVLayout.addComponent(releaseInfo1HLayout);
		releaseVLayout.addComponent(releaseInfo2HLayout);
		releaseVLayout.addComponent(releaseInfo3VLayout);
		
		hlDocumentVLayout.addComponent(hlDocumentInfo1HLayout);
		hlDocumentVLayout.addComponent(hlDocumentInfo2HLayout);

		authorInfo1HLayout.addComponent(authorName);
		authorInfo1HLayout.addComponent(authorDepartment);
		authorInfo2HLayout.addComponent(authorFunction);

		releaseInfo1HLayout.addComponent(tfReleaseVersion); 
		releaseInfo1HLayout.addComponent(tfReleaseDescription);	
		releaseInfo2HLayout.addComponent(cbReleaseStatus);
		releaseInfo2HLayout.addComponent(releaseInfo3VLayout);
		releaseInfo3VLayout.addComponent(dateLabel);
		releaseInfo3VLayout.addComponent(releaseDate);

		referenceInfo1HLayout.addComponent(tfReferenceTitle);
		referenceInfo1HLayout.addComponent(cbReferenceServiceType);
		referenceInfo2HLayout.addComponent(tfReferenceIssue);
		referenceInfo3HLayout.addComponent(tfReferenceNumber);
		referenceInfo3HLayout.addComponent(tfReferenceUsecaseNumber);

		hlDocumentInfo1HLayout.addComponent(tfHlDocumentTitle);
		hlDocumentInfo1HLayout.addComponent(tfHlDocumentReference);
		hlDocumentInfo2HLayout.addComponent(tfHlDocumentIssue);

		contentLeftVLayout.addComponent(authorPanel);
		contentLeftVLayout.addComponent(referencePanel);

		contentLeftVLayout.setComponentAlignment(authorPanel, Alignment.TOP_RIGHT);
		contentLeftVLayout.setComponentAlignment(referencePanel, Alignment.TOP_RIGHT);
		
		contentRightVLayout.addComponent(hlDocumentPanel);
		contentRightVLayout.addComponent(releasePanel);
		contentRightVLayout.addComponent(bSave);
				
		contentRightVLayout.setComponentAlignment(hlDocumentPanel, Alignment.TOP_LEFT);
		contentRightVLayout.setComponentAlignment(releasePanel, Alignment.TOP_LEFT);
		contentRightVLayout.setComponentAlignment(bSave, Alignment.MIDDLE_CENTER);
		
		addComponent(contentLeftVLayout);
		addComponent(contentRightVLayout);
	}
}
