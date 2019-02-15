package com.airbus.alten.cacau.presentation.ui.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.airbus.alten.cacau.exception.DefaultExceptionHandler;
import com.airbus.alten.cacau.model.ACApu;
import com.airbus.alten.cacau.model.ACEngine;
import com.airbus.alten.cacau.model.ACVersion;
import com.airbus.alten.cacau.model.UseCaseConfiguration;
import com.airbus.alten.cacau.model.business.UseCaseConfigurationBusinessContext;
import com.airbus.alten.cacau.model.business.UseCaseConfigurationContext;
import com.airbus.alten.cacau.model.business.UserCaCAUContext;
import com.airbus.alten.cacau.model.yellowpage.APIYellowPageAircraftsResponse;
import com.airbus.alten.cacau.model.yellowpage.APIYellowPagesApusResponse;
import com.airbus.alten.cacau.model.yellowpage.APIYellowPagesEnginesResponse;
import com.airbus.alten.cacau.model.yellowpage.Aircraft;
import com.airbus.alten.cacau.model.yellowpage.Apu;
import com.airbus.alten.cacau.model.yellowpage.Data;
import com.airbus.alten.cacau.model.yellowpage.Engine;
import com.airbus.alten.cacau.presentation.ui.manager.CaCAUApplicationNavigatorManager;
import com.airbus.alten.cacau.presentation.ui.manager.CaCAUUIManager;
import com.airbus.alten.cacau.presentation.ui.manager.GenericCaCAUHorizontalLayout;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPIApuTypesResponse;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPIBatchResponse;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPIEngineResponse;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPIModelResponse;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPISeviceAircraftEnginesRequest;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPISeviceAircraftEnginesResponse;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPISeviceAircraftResponse;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPISeviceEngineApusRequest;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPISeviceEngineApusResponse;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPIVersionResponse;
import com.airbus.alten.cacau.service.ManageUseCaseConfigurationService;
import com.airbus.alten.cacau.utils.AircraftProgramEnum;
import com.airbus.alten.cacau.utils.ServiceEnum;
import com.airbus.alten.cacau.yellowpage.jersey.webservice.YelloPageJSONFile;
import com.vaadin.annotations.Theme;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.MarginInfo;
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
import com.vaadin.ui.Table.Align;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@SpringView(name = CaCAUChooseProgram.MAIN_URL, ui = CaCAUUIManager.class)
@Theme("cacau")
public class CaCAUChooseProgram extends GenericCaCAUHorizontalLayout implements View {

	private static final long serialVersionUID = 8392442034382750867L;

	private static Logger LOGGER = LogManager.getLogger(CaCAUChooseProgram.class.getName());
	
	public static final String MAIN_URL = "choose-program";

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private ManageUseCaseConfigurationService manageUseCaseConfigurationService;

	@Autowired
	private CaCAUUIManager caCAUUIManager;
	
	private static final int SIZE = 200;
	private static final int HEIGHTSIZE = 35;

	private VerticalLayout projectVLLeft = new VerticalLayout();
	private VerticalLayout projectVLRight = new VerticalLayout();

	private Panel loadXmlPanel = new Panel("Load Existing XML");
	private Panel loadFromDBPanel = new Panel("Load Configuration");
	private Panel newConfigurationPanel = new Panel("New Configuration");
	
	private HorizontalLayout loadDeleteHLayout = new HorizontalLayout();
	private VerticalLayout mainConfigVLayout = new VerticalLayout();

//	private final ComboBox cbBatch = new ComboBox("Batch");
	private final ComboBox cbProgram = new ComboBox("Model");
	private final ComboBox cbVersion = new ComboBox("Version");
	private final ComboBox cbEngine = new ComboBox("Engine");
	private final ComboBox cbApu = new ComboBox("APU");

	private final Button bConfirm = new Button("Confirm Configuration");
	private final Button bClear = new Button("Clear Fields");
	private final Button bLoadConfig = new Button("Load Use Case", FontAwesome.DOWNLOAD);
	private final Button bLoadXML = new Button("Load Existing XML", FontAwesome.DOWNLOAD);
	private final Button bExportDP = new Button("Export DP", FontAwesome.DOWNLOAD);
	private final Button bDeleteConfig = new Button("Delete Use Case");

	private Label infoLoadXML = new Label("Click to load all existing XML files");
	private Label infoNewConfig = new Label("New Configuration");

	private Table tbConfigList = new Table();
	
	private String program = "";
	private String version = "";
	private String engine = "";
	private String apu = "";	
	private String title = "";
	
	private Integer userConfigurationSelected;
	private YelloPageJSONFile yelloPageJSONFile = new YelloPageJSONFile();

	private List<String> aircraftProgramNameList = new ArrayList<String>();

	private List<String> aircraftVersioneA320List = new ArrayList<String>();
	private List<String> aircraftVersioneA330List = new ArrayList<String>();
	private List<String> aircraftVersioneA350List = new ArrayList<String>();
	private List<String> aircraftVersioneA380List = new ArrayList<String>();

	private List<String> aircraftEngineList = new ArrayList<String>();
	private List<String> aircraftApuList = new ArrayList<String>();
	
	private List<Data> batchesData = new ArrayList<Data>();

	private List<UseCaseConfiguration> UseCaseConfigurationsDb = new ArrayList<UseCaseConfiguration>();
	private BeanContainer<Integer, UseCaseConfiguration> tbConfigListContainer = new BeanContainer<Integer, UseCaseConfiguration>(
			UseCaseConfiguration.class);

	public void entreCaCAU(ViewChangeEvent event) {

//		getAPIBatch();
		getAPIModel();
		getAPIVersion();
		getAPIEngine();
		getAPIApu();
		
		readJSONAircrafts();

		setSizeFull();
		setSpacing(true);
		setMargin(true);

		// Content Panel starts with main Horizontal
		// Layout------------------------------------------------------------------------------------------------------------------------------------------------

		projectVLLeft.setSizeFull();
		projectVLLeft.setSpacing(true);
		projectVLLeft.setMargin(true);


		projectVLRight.setSizeFull();
		projectVLRight.setSpacing(true);
		projectVLRight.setMargin(true);

		mainConfigVLayout.setMargin(true);
		mainConfigVLayout.setSizeFull();;

		// total layouts inside
		// mainTableVLayout--------------------------------------------------------------------------------------------------------------------------------------------------------

		VerticalLayout loadXMLFromDBVLayout = new VerticalLayout();
		loadXMLFromDBVLayout.setSpacing(true);
		loadXMLFromDBVLayout.setMargin(true);

		HorizontalLayout loadXmlContentHLayout = new HorizontalLayout();
		loadXmlContentHLayout.setWidth(100, Unit.PERCENTAGE);
		loadXmlContentHLayout.setSpacing(true);
		loadXmlContentHLayout.setMargin(true);
		
		enableAllAdminButton(applicationContext.getBean(UserCaCAUContext.class).getUserRole());
		
		loadDeleteHLayout.setWidth(100, Unit.PERCENTAGE);
		loadDeleteHLayout.setSpacing(true);
		loadDeleteHLayout.setMargin(true);

		// total 3 layouts inside
		// mainconfigVLayout--------------------------------------------------------------------------------------------------------------------------------------------------------
		HorizontalLayout lableNewConfigHLayout = new HorizontalLayout();
		lableNewConfigHLayout.setSizeFull();
		lableNewConfigHLayout.setSpacing(false);
		lableNewConfigHLayout.setMargin(true);

		HorizontalLayout configHLayout1 = new HorizontalLayout();
		configHLayout1.setWidth(100, Unit.PERCENTAGE);
		configHLayout1.setSpacing(true);
		configHLayout1.setMargin(new MarginInfo(false, true, true, true));

		HorizontalLayout configHLayout2 = new HorizontalLayout();
		configHLayout2.setWidth(100, Unit.PERCENTAGE);
		configHLayout2.setSpacing(true);
		configHLayout2.setMargin(new MarginInfo(false, true, true, true));

		HorizontalLayout clearConfirmHLayout = new HorizontalLayout();

		clearConfirmHLayout.setSizeFull();
		clearConfirmHLayout.setSpacing(true);
		clearConfirmHLayout.setMargin(true);

		// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//		cbBatch.setNullSelectionAllowed(true);
//		cbBatch.setInvalidAllowed(false);
//		cbBatch.setRequired(true);
				
		cbProgram.setNullSelectionAllowed(true);
		cbProgram.setInvalidAllowed(false);
		cbProgram.setRequired(true);
		addACProgramComboBoxValue();

		cbVersion.setNullSelectionAllowed(false);
		cbVersion.setInvalidAllowed(false);
		cbVersion.setEnabled(false);

		cbEngine.setNullSelectionAllowed(false);
		cbEngine.setInvalidAllowed(true);
		cbEngine.setEnabled(false);

		cbApu.setNullSelectionAllowed(false);
		cbApu.setInvalidAllowed(true);
		cbApu.setEnabled(false);

		bConfirm.setWidth(SIZE, Unit.PIXELS);
		bConfirm.setHeight(HEIGHTSIZE, Unit.PIXELS);
		bConfirm.setEnabled(false);

		bClear.setWidth(SIZE, Unit.PIXELS);
		bClear.setHeight(HEIGHTSIZE, Unit.PIXELS);

		bLoadConfig.setWidth(SIZE, Unit.PIXELS);
		bLoadConfig.setHeight(HEIGHTSIZE, Unit.PIXELS);
		bLoadConfig.setEnabled(false);

		bDeleteConfig.setWidth(SIZE, Unit.PIXELS);
		bDeleteConfig.setHeight(HEIGHTSIZE, Unit.PIXELS);
		bDeleteConfig.setEnabled(false);

		bLoadXML.setWidth(SIZE, Unit.PIXELS);
		bLoadXML.setHeight(HEIGHTSIZE, Unit.PIXELS);
		
		bExportDP.setWidth(SIZE, Unit.PIXELS);
		bExportDP.setHeight(HEIGHTSIZE, Unit.PIXELS);

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		cbProgram.addValueChangeListener(new Property.ValueChangeListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {

				if (cbProgram.getValue() != null) {

					if (cbProgram.getValue().equals(AircraftProgramEnum.A320.toString())) {
						cbVersion.removeAllItems();
						addACVersionComboBoxValue(aircraftVersioneA320List);
					} else if (cbProgram.getValue().equals(AircraftProgramEnum.A330.toString())) {
						cbVersion.removeAllItems();
						addACVersionComboBoxValue(aircraftVersioneA330List);
					} else if (cbProgram.getValue().equals(AircraftProgramEnum.A350.toString())) {
						cbVersion.removeAllItems();
						addACVersionComboBoxValue(aircraftVersioneA350List);
					} else if (cbProgram.getValue().equals(AircraftProgramEnum.A380.toString())) {
						cbVersion.removeAllItems();
						addACVersionComboBoxValue(aircraftVersioneA380List);
					} else {
						return;
					}

					bConfirm.setEnabled(true);

					applicationContext.getBean(UseCaseConfigurationContext.class)
							.setProgram(cbProgram.getValue().toString());
				} else {
					bClear.click();
				}
			}

		});

		cbVersion.addValueChangeListener(new Property.ValueChangeListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {

				if (cbVersion.getValue() != null) {

					readJSONAircraftEngines(cbVersion.getValue().toString());
				}

			}
		});

		cbEngine.addValueChangeListener(new Property.ValueChangeListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {

				if (cbEngine.getValue() != null) {

					readJSONAircraftEngineApus(cbEngine.getValue().toString(), cbVersion.getValue().toString());

				}
			}
		});

		cbApu.addValueChangeListener(new Property.ValueChangeListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {
			}
		});
		
		bExportDP.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = -5666247399646245663L;

			public void buttonClick(ClickEvent event) {
				CaCAUApplicationNavigatorManager.navigate(CaCAUExport.MAIN_URL);
			}
		});
		
		bLoadConfig.addClickListener(new Button.ClickListener() {


			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {

				if(userConfigurationSelected != null){
					
					UseCaseConfigurationsDb = manageUseCaseConfigurationService
							.getAllUserUseCaseConfiguration(applicationContext.getBean(UserCaCAUContext.class).getUser().getId());

					for (UseCaseConfiguration p : UseCaseConfigurationsDb) {
						
						if(userConfigurationSelected == p.getId()){
							
							applicationContext.getBean(UseCaseConfigurationBusinessContext.class).setUseCaseConfiguration(p);       
							CaCAUApplicationNavigatorManager.navigate(CaCAUSearchByCriteria.MAIN_URL);
						}
					} 
					
				}else{
					return;
				}
					
			}
		});
		
		
		bDeleteConfig.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = -5666247399646245663L;

			public void buttonClick(ClickEvent event) {
				
				//Popup window to delete Use case-------------------------------------------------------------------------------------------------------------------------------------------------------
				final Window deletePopupWindow = new Window("Delete Configuration");
				deletePopupWindow.setModal(true);
				deletePopupWindow.center();
				deletePopupWindow.setResizable(false);
				deletePopupWindow.setHeight("375px");
				deletePopupWindow.setWidth("800px");
				
		        UI.getCurrent().addWindow(deletePopupWindow);
				
		        VerticalLayout popupDeleteContent = new VerticalLayout();
		        popupDeleteContent.setSpacing(true);
		        popupDeleteContent.setMargin(true);
		        
		        HorizontalLayout infoDeleteLayout = new HorizontalLayout();
		        infoDeleteLayout.setSizeFull();
		        infoDeleteLayout.setSpacing(true);
		        infoDeleteLayout.setMargin(true);
		        
		        HorizontalLayout deleteConfirmLayout = new HorizontalLayout();
		        deleteConfirmLayout.setSpacing(true);
		        deleteConfirmLayout.setMargin(true);
		        
		        final Button cancelBT = new Button("Cancel");			        
		        final Button deleteBT = new Button("Delete");
		        final Label infoDelLabel = new Label("Do you really want to delete the selected UseCase Configuration from the Database ?");
		        
		        cancelBT.setWidth(SIZE, Unit.PIXELS);
		        cancelBT.setHeight(HEIGHTSIZE, Unit.PIXELS);
		        
		        deleteBT.setWidth(SIZE, Unit.PIXELS);
		        deleteBT.setHeight(HEIGHTSIZE, Unit.PIXELS);
		        
		        infoDeleteLayout.addComponent(infoDelLabel);
		        deleteConfirmLayout.addComponent(cancelBT);
		        deleteConfirmLayout.addComponent(deleteBT);
		        
		        popupDeleteContent.addComponent(infoDeleteLayout);
		        popupDeleteContent.addComponent(deleteConfirmLayout); 
		        popupDeleteContent.setComponentAlignment(deleteConfirmLayout, Alignment.MIDDLE_CENTER);
		        
		        cancelBT.addClickListener(new Button.ClickListener() {
		        	
					private static final long serialVersionUID = -5666247399646245663L;
					
					public void buttonClick(ClickEvent event) {
						deletePopupWindow.close();
					}
				});
		        
		        deleteBT.addClickListener(new Button.ClickListener() {
		        	
					private static final long serialVersionUID = -5666247399646245663L;
					
					public void buttonClick(ClickEvent event) {	

						if(userConfigurationSelected != null){
							
							UseCaseConfigurationsDb = manageUseCaseConfigurationService
									.getAllUserUseCaseConfiguration(applicationContext.getBean(UserCaCAUContext.class).getUser().getId());

							tbConfigListContainer.removeAllItems();
							
							for (UseCaseConfiguration p : UseCaseConfigurationsDb) {
								
								if(userConfigurationSelected == p.getId()){
									manageUseCaseConfigurationService.deleteUserUseCaseConfiguration(applicationContext.getBean(UserCaCAUContext.class).getUser().getId(), p);
								}
								else{
									tbConfigListContainer.addBean(p);
								}
							}
							
							tbConfigList.setContainerDataSource(tbConfigListContainer);
							setUserSelectecParameterTableProperties();
							
							bDeleteConfig.setEnabled(false);
							bLoadConfig.setEnabled(false);
							
						}else{
							return;
						}
							
						Notification.show("The selected Parameters has bin removed...");
						deletePopupWindow.close();								
					}						
				});
		        deletePopupWindow.setContent(popupDeleteContent);
			}
		});

		bClear.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = -5666247399646245663L;

			public void buttonClick(ClickEvent event) {

				cbApu.removeAllItems();
				cbApu.setEnabled(false);

				cbEngine.removeAllItems();
				cbEngine.setEnabled(false);

				cbVersion.removeAllItems();
				cbVersion.setEnabled(false);

				cbProgram.select(null);

				bConfirm.setEnabled(false);

			}
		});

		bConfirm.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = -5666247399646245663L;

			public void buttonClick(ClickEvent event) {

				//PopUp window for New Confirmation-----------------------------------------------------------------------------------------------------------------------------------------------------						
				final Window confirmPopupWindow = new Window("New Configuration");
				confirmPopupWindow.setModal(true);
				confirmPopupWindow.center();
				confirmPopupWindow.setResizable(false);
				confirmPopupWindow.setHeight("375px");
				confirmPopupWindow.setWidth("800px");
				
		        UI.getCurrent().addWindow(confirmPopupWindow);
		        
		        VerticalLayout popupConfirmContent = new VerticalLayout();
		        popupConfirmContent.setSpacing(true);
		        popupConfirmContent.setMargin(true);
		        
		        VerticalLayout textFieldLayout = new VerticalLayout();
		        textFieldLayout.setSizeFull();
		        textFieldLayout.setSpacing(true);
		        textFieldLayout.setMargin(true);
		        				        
		        HorizontalLayout cancelConfirmLayout = new HorizontalLayout();
		        cancelConfirmLayout.setSpacing(true);
		        cancelConfirmLayout.setMargin(true);
		        
		        final TextField tfTitleEditor = new TextField("Add New Title");				       
		        final Button btCancel = new Button("Cancel");			        
		        final Button btConfirm = new Button("Confirm");
		        final Label infoOldLabel = new Label("Old Title: " + program + "-" + version + "-" + engine + "-" + apu + "-" + "Old title Info");
		        
		        tfTitleEditor.setRequired(true);
		        tfTitleEditor.setWidth("500px");

		        btCancel.setWidth(SIZE, Unit.PIXELS);
		        btCancel.setHeight(HEIGHTSIZE, Unit.PIXELS);
		        
		        btConfirm.setWidth(SIZE, Unit.PIXELS);
		        btConfirm.setHeight(HEIGHTSIZE, Unit.PIXELS);
		        
		        tfTitleEditor.setValue("");
		        tfTitleEditor.setImmediate(true);
		        
		        textFieldLayout.addComponent(tfTitleEditor);
		        textFieldLayout.addComponent(infoOldLabel);
		        
		        cancelConfirmLayout.addComponent(btCancel);
		        cancelConfirmLayout.addComponent(btConfirm);
		        
		        popupConfirmContent.addComponent(textFieldLayout);
		        popupConfirmContent.addComponent(cancelConfirmLayout); 
		        popupConfirmContent.setComponentAlignment(cancelConfirmLayout, Alignment.MIDDLE_CENTER);
		        
		        tfTitleEditor.addValueChangeListener(new Property.ValueChangeListener() {
		        	
					private static final long serialVersionUID = 1L;
					
					@Override
					public void valueChange(ValueChangeEvent event) {								
						title = (String) event.getProperty().getValue(); 
					}
				});
		        
		        btCancel.addClickListener(new Button.ClickListener() {
			
					private static final long serialVersionUID = -5666247399646245663L;
					
					public void buttonClick(ClickEvent event) {
						confirmPopupWindow.close();
					}
				});			        
		        
		        btConfirm.addClickListener(new Button.ClickListener() {

					private static final long serialVersionUID = -5666247399646245663L;
					
					public void buttonClick(ClickEvent event) {	
						
						if(!title.isEmpty()){
							title = title.trim();
							
							if(!title.isEmpty()) {	
								
								tfTitleEditor.validate();
								tfTitleEditor.setComponentError(null);
								
								if (cbProgram.getValue() != null) {

									applicationContext.getBean(UseCaseConfigurationContext.class)
											.setProgram(cbProgram.getValue().toString());				
									
									if (cbVersion.getValue() != null)
										applicationContext.getBean(UseCaseConfigurationContext.class)
												.setVersion(cbVersion.getValue().toString());					
									else
										applicationContext.getBean(UseCaseConfigurationContext.class).setVersion("ALL");

									if (cbEngine.getValue() != null)
										applicationContext.getBean(UseCaseConfigurationContext.class)
												.setEngine(cbEngine.getValue().toString());
									else
										applicationContext.getBean(UseCaseConfigurationContext.class).setEngine("ALL");

									if (cbApu.getValue() != null)
										applicationContext.getBean(UseCaseConfigurationContext.class)
												.setApu(cbApu.getValue().toString());
									else
										applicationContext.getBean(UseCaseConfigurationContext.class).setApu("ALL");

									program = applicationContext.getBean(UseCaseConfigurationContext.class).getProgram();
									version = applicationContext.getBean(UseCaseConfigurationContext.class).getVersion();
									engine = applicationContext.getBean(UseCaseConfigurationContext.class).getEngine();
									apu = applicationContext.getBean(UseCaseConfigurationContext.class).getApu();

									UseCaseConfiguration useCaseConfiguration = new UseCaseConfiguration();
									useCaseConfiguration.setTitle(program + "_" + version + "_" + engine + "_" + apu + "_" + title);

									List<ACVersion> acVersions = new ArrayList<ACVersion>();
									ACVersion acV = new ACVersion();
									acV.setVersionName(applicationContext.getBean(UseCaseConfigurationContext.class).getVersion());
									acV.setUseCaseConfiguration(useCaseConfiguration);
									acVersions.add(acV);

									List<ACEngine> acEngines = new ArrayList<ACEngine>();
									ACEngine acE = new ACEngine();
									acE.setEngineName(applicationContext.getBean(UseCaseConfigurationContext.class).getEngine());
									acE.setUseCaseConfiguration(useCaseConfiguration);
									acEngines.add(acE);

									List<ACApu> acApus = new ArrayList<ACApu>();
									ACApu acA = new ACApu();
									acA.setApuName(applicationContext.getBean(UseCaseConfigurationContext.class).getApu());
									acA.setUseCaseConfiguration(useCaseConfiguration);
									acApus.add(acA);

									useCaseConfiguration
											.setProgram(applicationContext.getBean(UseCaseConfigurationContext.class).getProgram());
									useCaseConfiguration.setVersions(acVersions);
									useCaseConfiguration.setEngines(acEngines);
									useCaseConfiguration.setApus(acApus);
									useCaseConfiguration
											.setUserId(applicationContext.getBean(UserCaCAUContext.class).getUser().getId());
									useCaseConfiguration.setYellowPageDataServiceVersion("1.0.0");
									useCaseConfiguration.setYellowPageDBVersion("2.0.0");
									useCaseConfiguration.setSource("source");

						
									manageUseCaseConfigurationService.saveUserUseCaseConfiguration(useCaseConfiguration);

					
									UseCaseConfiguration UseCaseConfigResult = manageUseCaseConfigurationService
											.getUserUseCaseConfigurationTitle(
													applicationContext.getBean(UserCaCAUContext.class).getUser().getId(),
													useCaseConfiguration.getTitle());	
							        
									if (UseCaseConfigResult != null) {

										applicationContext.getBean(UseCaseConfigurationBusinessContext.class)
												.setUseCaseConfiguration(UseCaseConfigResult);       
									}
								} else {
									return;
								}
								confirmPopupWindow.close();
								CaCAUApplicationNavigatorManager.navigate(CaCAUSearchByCriteria.MAIN_URL);	
							} else {
								tfTitleEditor.setComponentError(getErrorMessage());
							}
						}
					
					}							
				});	
		        confirmPopupWindow.setContent(popupConfirmContent);	
			}
		});


		lableNewConfigHLayout.addComponent(infoNewConfig);
		lableNewConfigHLayout.setComponentAlignment(infoNewConfig, Alignment.MIDDLE_CENTER);

		configHLayout1.addComponent(cbProgram);
		configHLayout1.setComponentAlignment(cbProgram, Alignment.MIDDLE_RIGHT);
		configHLayout1.addComponent(cbVersion);
		configHLayout1.setComponentAlignment(cbVersion, Alignment.MIDDLE_LEFT);

		configHLayout2.addComponent(cbEngine);
		configHLayout2.setComponentAlignment(cbEngine, Alignment.MIDDLE_RIGHT);
		configHLayout2.addComponent(cbApu);
		configHLayout2.setComponentAlignment(cbApu, Alignment.MIDDLE_LEFT);

		clearConfirmHLayout.addComponent(bClear);
		clearConfirmHLayout.setComponentAlignment(bClear, Alignment.MIDDLE_RIGHT);
		clearConfirmHLayout.addComponent(bConfirm);
		clearConfirmHLayout.setComponentAlignment(bConfirm, Alignment.MIDDLE_LEFT);

		// --------------------------------------------------------------------------------------------------------------------------
		// User Selected Parameters Table

		tbConfigList = new Table("User Selected Parameters");
		tbConfigList.setSelectable(true);
		tbConfigList.setWidth(100, Unit.PERCENTAGE);
		tbConfigList.setMultiSelect(false);
		tbConfigList.setImmediate(true);
		tbConfigList.addStyleName("rowheight");
		tbConfigList.setPageLength(8);

		tbConfigListContainer.setBeanIdProperty("id");

		UseCaseConfigurationsDb = manageUseCaseConfigurationService
				.getAllUserUseCaseConfiguration(applicationContext.getBean(UserCaCAUContext.class).getUser().getId());

		for (UseCaseConfiguration p : UseCaseConfigurationsDb) {
			tbConfigListContainer.addBean(p);
		}
		
		tbConfigList.setContainerDataSource(tbConfigListContainer);
		setUserSelectecParameterTableProperties();
		
		tbConfigList.addValueChangeListener(new Property.ValueChangeListener() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {

				bClear.click();
				
				if(event != null && event.getProperty().getValue() != null){
					
					bDeleteConfig.setEnabled(true);
					bLoadConfig.setEnabled(true);
					
					String ff = event.getProperty().getValue().toString();
					Integer id = new Integer(ff);

					userConfigurationSelected = id.intValue(); 
				}
				else{
					bDeleteConfig.setEnabled(false);
					bLoadConfig.setEnabled(false);
				}	
			}
		});
		
		loadXmlContentHLayout.addComponent(bLoadXML);
		loadXmlContentHLayout.setComponentAlignment(bLoadXML, Alignment.MIDDLE_CENTER);
		loadXmlContentHLayout.addComponent(bExportDP);
		loadXmlContentHLayout.setComponentAlignment(bExportDP, Alignment.MIDDLE_CENTER);
//		loadXmlContentHLayout.addComponent(infoLoadXML);
//		loadXmlContentHLayout.setComponentAlignment(infoLoadXML, Alignment.MIDDLE_CENTER);
		
		loadXmlPanel.setContent(loadXmlContentHLayout);
		loadXmlPanel.setStyleName("cacauProjectMain");
		
		
		loadDeleteHLayout.addComponent(bLoadConfig);
		loadDeleteHLayout.addComponent(bDeleteConfig);
		
		loadDeleteHLayout.setComponentAlignment(bLoadConfig, Alignment.MIDDLE_CENTER);
		loadDeleteHLayout.setComponentAlignment(bDeleteConfig, Alignment.MIDDLE_CENTER);
		

		
		loadXMLFromDBVLayout.addComponent(loadXmlContentHLayout);
		loadXMLFromDBVLayout.addComponent(tbConfigList);
		loadXMLFromDBVLayout.addComponent(loadDeleteHLayout);
		
		
		loadFromDBPanel.setContent(loadXMLFromDBVLayout);
		loadFromDBPanel.setStyleName("cacauProjectMain");

		
		mainConfigVLayout.addComponent(configHLayout1);
		mainConfigVLayout.addComponent(configHLayout2);
		mainConfigVLayout.addComponent(clearConfirmHLayout);

		newConfigurationPanel.setStyleName("cacauProjectMain");
		newConfigurationPanel.setContent(mainConfigVLayout);
		

		loadFromDBPanel.setWidth(70, Unit.PERCENTAGE);
		loadFromDBPanel.setHeight(600, Unit.PIXELS);
		
		newConfigurationPanel.setWidth(70, Unit.PERCENTAGE);
		newConfigurationPanel.setHeight(600, Unit.PIXELS);
		
		
		projectVLLeft.addComponent(loadFromDBPanel);
		projectVLRight.addComponent(newConfigurationPanel);
		
		projectVLLeft.setComponentAlignment(loadFromDBPanel, Alignment.TOP_RIGHT);
		projectVLRight.setComponentAlignment(newConfigurationPanel, Alignment.TOP_LEFT);

		addComponent(projectVLLeft);
		addComponent(projectVLRight);
		
		setComponentAlignment(projectVLLeft, Alignment.TOP_RIGHT);
		setComponentAlignment(projectVLRight, Alignment.TOP_LEFT);

	}

//	private void getAPIBatch() {
//
//		YellowPageAPIBatchResponse response = yelloPageJSONFile.getBatches();
//		
//		if (cbProgram.removeAllItems() && ServiceEnum.OK.equals(response.getSERVICE_API_STATUS())
//				&& ServiceEnum.OK.equals(response.getMAPPER_STATUS())) {
//
//			batchesData = response.getBatch().getData();
//			
//			if(batchesData.size() == 0){
//				caCAUUIManager.getAppErrorLB().setValue("Batch API Data is empty");
//				return;
//			}
//				
//			Integer lastBatchId = 0;
//			Data selecteddate = new Data();
//			
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//			
//			for(Data d : batchesData){
//				
//				if("FROZEN".equals(d.getBatchStatus())){
//
//
//					cbProgram.addItem(d.getBatchId().toString() + " - "+ dateFormat.format(d.getBatchFrozenDateTime().getTime()));
//					
//					if(d.getBatchId() > lastBatchId){
//						
//						lastBatchId = d.getBatchId();
//						selecteddate = d;
//						LOGGER.info(d.getBatchId());
//						LOGGER.info(d.getBatchFrozenDateTime().toString());
//					}
//						
//				}
//			}
//			cbProgram.select(selecteddate.getBatchId().toString()  + " - "+ dateFormat.format(selecteddate.getBatchFrozenDateTime().getTime()));
//
//		} else {
//				caCAUUIManager.getAppErrorLB().setValue(response.getMessage());
//		}
//	}
	
	private void getAPIModel() {

		YellowPageAPIModelResponse response = yelloPageJSONFile.getModel();

		if (ServiceEnum.OK.equals(response.getSERVICE_API_STATUS())
				&& ServiceEnum.OK.equals(response.getMAPPER_STATUS())) {

		} else {
				caCAUUIManager.getAppErrorLB().setValue("777_ERROR");
		}
	}
	
	private void getAPIVersion() {

		YellowPageAPIVersionResponse response = yelloPageJSONFile.getVersion();

		if (ServiceEnum.OK.equals(response.getSERVICE_API_STATUS())
				&& ServiceEnum.OK.equals(response.getMAPPER_STATUS())) {

		} else {
				caCAUUIManager.getAppErrorLB().setValue("777_ERROR");
		}
	}
	
	private void getAPIEngine() {

		YellowPageAPIEngineResponse response = yelloPageJSONFile.getEngines();

		if (ServiceEnum.OK.equals(response.getSERVICE_API_STATUS())
				&& ServiceEnum.OK.equals(response.getMAPPER_STATUS())) {

		} else {
				caCAUUIManager.getAppErrorLB().setValue("777_ERROR");
		}
	}
	
	private void getAPIApu() {

		YellowPageAPIApuTypesResponse response = yelloPageJSONFile.getApuTypes();

		if (ServiceEnum.OK.equals(response.getSERVICE_API_STATUS())
				&& ServiceEnum.OK.equals(response.getMAPPER_STATUS())) {

		} else {
				caCAUUIManager.getAppErrorLB().setValue("777_ERROR");
		}
	}
	private void readJSONAircrafts() {

		YellowPageAPISeviceAircraftResponse yellowPageAPISeviceAircraftResponse = yelloPageJSONFile.getAircrafts();
		APIYellowPageAircraftsResponse apiYellowPageAircraftsResponse = yellowPageAPISeviceAircraftResponse
				.getAPIYellowPageAircraftsResponse();

		if (ServiceEnum.OK.equals(yellowPageAPISeviceAircraftResponse.getSERVICE_API_STATUS())
				&& ServiceEnum.OK.equals(yellowPageAPISeviceAircraftResponse.getMAPPER_STATUS())
				&& apiYellowPageAircraftsResponse != null) {

			List<Aircraft> aircraftListAPI = apiYellowPageAircraftsResponse.getData();

			List<String> aircraftNameList = new ArrayList<String>();

			for (Aircraft aN : aircraftListAPI) {

				aircraftNameList.add(aN.getAircraftName());

			}

			List<String> aircraftProgramList = new ArrayList<String>();
			aircraftProgramList.add(AircraftProgramEnum.A320.toString());
			aircraftProgramList.add(AircraftProgramEnum.A330.toString());
			aircraftProgramList.add(AircraftProgramEnum.A350.toString());
			aircraftProgramList.add(AircraftProgramEnum.A380.toString());

			for (String sP : aircraftProgramList) {

				boolean toBeAdd = true;
				Pattern aircraftProgramPattern = Pattern.compile(sP + ".*", Pattern.CASE_INSENSITIVE);

				for (String sV : aircraftNameList) {

					Matcher aircraftProgramMatcher = aircraftProgramPattern.matcher(sV);

					if (aircraftProgramMatcher.find()) {

						sV = sV.replaceAll(sP, "");

						if (sP.equals(AircraftProgramEnum.A320.toString())) {

							aircraftVersioneA320List.add(sV);

							if (toBeAdd) {
								aircraftProgramNameList.add(sP);
								toBeAdd = false;
							}
						} else if (sP.equals(AircraftProgramEnum.A330.toString())) {

							aircraftVersioneA330List.add(sV);

							if (toBeAdd) {
								aircraftProgramNameList.add(sP);
								toBeAdd = false;
							}
						} else if (sP.equals(AircraftProgramEnum.A350.toString())) {

							aircraftVersioneA350List.add(sV);

							if (toBeAdd) {
								aircraftProgramNameList.add(sP);
								toBeAdd = false;
							}
						} else if (sP.equals(AircraftProgramEnum.A380.toString())) {

							aircraftVersioneA380List.add(sV);

							if (toBeAdd) {
								aircraftProgramNameList.add(sP);
								toBeAdd = false;
							}
						}
					}
				}
			}
		} else {

			Notification.show("ccccccccccccccc");

		}

	}

	private void readJSONAircraftEngines(String versionSelected) {

		YellowPageAPISeviceAircraftEnginesRequest request = new YellowPageAPISeviceAircraftEnginesRequest();

		String aircraftProgramSelected = applicationContext.getBean(UseCaseConfigurationContext.class).getProgram();
		request.setAircraft(aircraftProgramSelected + versionSelected);

		YellowPageAPISeviceAircraftEnginesResponse yellowPageAPISeviceAircraftEnginesResponse = yelloPageJSONFile
				.getEnginesFromAircraft(request);
		APIYellowPagesEnginesResponse apiYellowPagesEnginesResponse = yellowPageAPISeviceAircraftEnginesResponse
				.getApiYellowPagesEnginesResponse();

		if (ServiceEnum.OK.equals(yellowPageAPISeviceAircraftEnginesResponse.getSERVICE_API_STATUS())
				&& ServiceEnum.OK.equals(yellowPageAPISeviceAircraftEnginesResponse.getMAPPER_STATUS())
				&& apiYellowPagesEnginesResponse != null) {

			List<Engine> enginesListAPI = apiYellowPagesEnginesResponse.getData();

			aircraftEngineList.clear();

			for (Engine e : enginesListAPI) {

				aircraftEngineList.add(e.getEngineName());
			}

			addACEnginesComboBoxValue(aircraftEngineList);
		} else {

			Notification.show("ccccccccccccccc");
		}

	}

	private void readJSONAircraftEngineApus(String engineSelected, String versionSelected) {

		YellowPageAPISeviceEngineApusRequest request = new YellowPageAPISeviceEngineApusRequest();

		if ("ALL".equals(engineSelected))
			request.setEngine(versionSelected);
		else
			request.setEngine(engineSelected);

		YellowPageAPISeviceEngineApusResponse response = yelloPageJSONFile.getApusFromEngine(request);
		APIYellowPagesApusResponse apiYellowPagesApusResponse = response.getaPIYellowPagesApusResponse();

		if (ServiceEnum.OK.equals(response.getSERVICE_API_STATUS())
				&& ServiceEnum.OK.equals(response.getMAPPER_STATUS()) && apiYellowPagesApusResponse != null) {

			List<Apu> apusListAPI = apiYellowPagesApusResponse.getData();

			aircraftApuList.clear();

			for (Apu a : apusListAPI) {

				aircraftApuList.add(a.getAPUName());
			}

			addACApusComboBoxValue(aircraftApuList);
		} else {

			Notification.show("ccccccccccccccc");
		}

	}

	private void addACProgramComboBoxValue() {

		for (String a : aircraftProgramNameList) {

			cbProgram.addItems(a);
		}
	}

	private void addACVersionComboBoxValue(List<String> aircraftVersions) {

		if (aircraftVersions.size() > 0) {

			cbVersion.addItem("ALL");

			for (String v : aircraftVersions) {
				cbVersion.addItem(v);
			}

			if (aircraftVersions.size() > 1)
				cbVersion.select("ALL");

			else {
				cbVersion.removeItem("ALL");
				cbVersion.select(aircraftVersions.get(0));
			}

			cbEngine.removeAllItems();
			cbEngine.addItem("ALL");
			cbEngine.select("ALL");
			cbEngine.setEnabled(true);

			cbApu.removeAllItems();
			cbApu.addItem("ALL");
			cbApu.select("ALL");
			cbApu.setEnabled(true);

			cbVersion.setEnabled(true);
		}
	}

	private void addACEnginesComboBoxValue(List<String> aircraftEngines) {

		if (aircraftEngines.size() > 0) {

			cbEngine.removeAllItems();
			cbEngine.addItem("ALL");

			for (String e : aircraftEngines) {
				cbEngine.addItem(e);
			}

			if (aircraftEngines.size() > 1)
				cbEngine.select("ALL");

			else {
				cbEngine.removeItem("ALL");
				cbEngine.select(aircraftEngines.get(0));
			}

			cbApu.removeAllItems();
			cbApu.addItem("ALL");
			cbApu.select("ALL");
			cbApu.setEnabled(true);
		}
	}

	private void addACApusComboBoxValue(List<String> aircraftApus) {

		if (aircraftApus.size() > 0) {

			cbApu.removeAllItems();
			cbApu.addItem("ALL");

			for (String e : aircraftApus) {
				cbApu.addItem(e);
			}

			if (aircraftApus.size() > 1)
				cbApu.select("ALL");

			else {
				cbApu.removeItem("ALL");
				cbApu.select(aircraftApus.get(0));
			}
		}
	}

	private void setUserSelectecParameterTableProperties() {

		tbConfigList.setVisibleColumns("title");
		tbConfigList.setColumnHeaders("Title");

		tbConfigList.setColumnAlignment("title", Align.CENTER);

	}
	
	private void enableAllAdminButton(String userRole){
		
		bExportDP.setVisible(false);
		
		bExportDP.setStyleName("buttonNormale");
		
		if(userRole != null && !userRole.isEmpty() && userRole.equals("ADMIN")){

			bExportDP.setEnabled(true);
			bExportDP.setVisible(true);			
		}

	}
}