package com.airbus.alten.cacau.presentation.ui.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.airbus.alten.cacau.model.UseCaseConfiguration;
import com.airbus.alten.cacau.model.User;
import com.airbus.alten.cacau.model.UserParameter;
import com.airbus.alten.cacau.model.business.UseCaseConfigurationBusinessContext;
import com.airbus.alten.cacau.model.business.UserCaCAUContext;
import com.airbus.alten.cacau.model.xml.USECASE;
import com.airbus.alten.cacau.presentation.ui.manager.CaCAUUIManager;
import com.airbus.alten.cacau.presentation.ui.manager.GenericCaCAUVerticalLayout;
import com.airbus.alten.cacau.service.ManageParameterService;
import com.airbus.alten.cacau.service.ManageUseCaseConfigurationService;
import com.airbus.alten.cacau.xml.UseCaseGenerator;
import com.airbus.alten.cacau.xml.XMLCaCAUGenerator;
import com.vaadin.annotations.Theme;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.Align;
import com.vaadin.ui.themes.ValoTheme;

@SpringView(name = CaCAUTemporaryList.MAIN_URL, ui = CaCAUUIManager.class)
@Theme("cacau")
public class CaCAUTemporaryList extends GenericCaCAUVerticalLayout implements View {

	private static final long serialVersionUID = 8392442034382750867L;

	public static final String MAIN_URL = "temporary-list";

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private CaCAUUIManager caCAUUIManager;
	
	@Autowired
	private ManageParameterService manageParameterService;

	@Autowired
	private ManageUseCaseConfigurationService manageUseCaseConfigurationService;
	
	private Table tbTemporaryList = new Table();
	private HorizontalLayout commandHL = new HorizontalLayout();
	private Label infoConfigurationLB = new Label();
	
	private static final int BUTTON_WIDTH = 300;
	private static final int BUTTON_HEIGHT = 50;
	
	private Integer paramToDelete;
	
	private final Button deleteAllBT = new Button("Delete All", FontAwesome.REMOVE);
	private final Button deleteSingleBT = new Button("Delete Selected", FontAwesome.REMOVE);
	private final Button exportXMLBT = new Button("Generate XML File", FontAwesome.DOWNLOAD);

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
		
		caCAUUIManager.getTemporaryParameterBT().setEnabled(false);
		caCAUUIManager.getTemporaryParameterBT().setStyleName("buttonSelected");
		
		caCAUUIManager.getAirlineEquipmentInfoBT().setEnabled(true);
		caCAUUIManager.getAirlineEquipmentInfoBT().setStyleName("buttonNormale");
		
		commandHL.setSpacing(true);
		commandHL.setMargin(true); 
		commandHL.setWidth(100, Unit.PERCENTAGE);
		

		infoConfigurationLB = new Label("Selected Configuration - Aircraft:  Version:   Engine: , APU: ");
		infoConfigurationLB.addStyleName(ValoTheme.LABEL_SUCCESS);
		infoConfigurationLB.setWidth(100, Unit.PERCENTAGE);

		
		// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

		
		tbTemporaryList = new Table("The current Temporary List contains the following Parameters");
		tbTemporaryList.setSelectable(true);
		tbTemporaryList.setWidth(100, Unit.PERCENTAGE);
		tbTemporaryList.setMultiSelect(false);
		tbTemporaryList.setImmediate(true);
		tbTemporaryList.addStyleName("rowheight");
		tbTemporaryList.setPageLength(15);
		
		deleteAllBT.setWidth(BUTTON_WIDTH, Unit.PIXELS);
		deleteAllBT.setHeight(BUTTON_HEIGHT, Unit.PIXELS);
		deleteAllBT.setEnabled(false);
		
		deleteSingleBT.setWidth(BUTTON_WIDTH, Unit.PIXELS);
		deleteSingleBT.setHeight(BUTTON_HEIGHT, Unit.PIXELS);
		deleteSingleBT.setEnabled(false);
		
		exportXMLBT.setWidth(BUTTON_WIDTH, Unit.PIXELS);
		exportXMLBT.setHeight(BUTTON_HEIGHT, Unit.PIXELS);
		exportXMLBT.setEnabled(false);
		
		
		final BeanContainer<Integer, UserParameter> temporaryListListContainer = new BeanContainer<Integer, UserParameter>(UserParameter.class);
		temporaryListListContainer.setBeanIdProperty("parameterId");

		
		useCaseConfiguration = manageUseCaseConfigurationService.getUserUseCaseConfigurationTitle(applicationContext.getBean(UserCaCAUContext.class).getUser().getId(), applicationContext.getBean(UseCaseConfigurationBusinessContext.class).getUseCaseConfiguration().getTitle());
		List<UserParameter> resultHeader = useCaseConfiguration.getUserParameters();
		
		temporaryListListContainer.removeAllItems();
		
		for (UserParameter p : resultHeader) {
			temporaryListListContainer.addBean(p);
		}

		if(temporaryListListContainer.size() > 0){
			
			deleteAllBT.setEnabled(true);
			exportXMLBT.setEnabled(true);
		}

		tbTemporaryList.setContainerDataSource(temporaryListListContainer);
		setUserSelectecParameterTableProperties();
	
		
		// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		tbTemporaryList.addValueChangeListener(new Property.ValueChangeListener() {
			
			@Override
			public void valueChange(ValueChangeEvent event) {
				
				if(event != null && event.getProperty().getValue() != null){
					
					deleteSingleBT.setEnabled(true);
					
					String ff = event.getProperty().getValue().toString();
					Integer id = new Integer(ff);

					paramToDelete = id.intValue(); 
				}
				else
					deleteSingleBT.setEnabled(false);

			}
		});
		
		deleteAllBT.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = -5666247399646245663L;
			
			public void buttonClick(ClickEvent event) {

			
				useCaseConfiguration = manageUseCaseConfigurationService.getUserUseCaseConfigurationTitle(applicationContext.getBean(UserCaCAUContext.class).getUser().getId(), useCaseConfiguration.getTitle());
				applicationContext.getBean(UseCaseConfigurationBusinessContext.class).setUseCaseConfiguration(useCaseConfiguration);
				List<UserParameter> resultHeader = useCaseConfiguration.getUserParameters();
				
				for (UserParameter p : resultHeader) {
					
					manageParameterService.deleteUserParameter(p, p.getUseCaseConfiguration());
				
				}
				
				temporaryListListContainer.removeAllItems();
				setUserSelectecParameterTableProperties();
				
				Notification.show("All Parameters and Dummy parameters has bin deleted");
				
				deleteAllBT.setEnabled(false);
				deleteSingleBT.setEnabled(false);
				exportXMLBT.setEnabled(false);
						

			}
		});
		
		deleteSingleBT.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = -5666247399646245663L;
			
			public void buttonClick(ClickEvent event) {


				if(paramToDelete != null){
					
					useCaseConfiguration = manageUseCaseConfigurationService.getUserUseCaseConfigurationTitle(applicationContext.getBean(UserCaCAUContext.class).getUser().getId(), useCaseConfiguration.getTitle());
					List<UserParameter> resultHeader = useCaseConfiguration.getUserParameters();
					
					for (UserParameter p : resultHeader) {
						
						if(paramToDelete == p.getParameterId()){
							manageParameterService.deleteUserParameter(p, p.getUseCaseConfiguration());
						}
					
					}
					
					useCaseConfiguration = manageUseCaseConfigurationService.getUserUseCaseConfigurationTitle(applicationContext.getBean(UserCaCAUContext.class).getUser().getId(), useCaseConfiguration.getTitle());
					applicationContext.getBean(UseCaseConfigurationBusinessContext.class).setUseCaseConfiguration(useCaseConfiguration);
					resultHeader = useCaseConfiguration.getUserParameters();
					temporaryListListContainer.removeAllItems();
					
					for (UserParameter p : resultHeader) {
						temporaryListListContainer.addBean(p);
					}
					
					tbTemporaryList.setContainerDataSource(temporaryListListContainer);
					setUserSelectecParameterTableProperties();
					
					Notification.show("The selected Parameters has bin removed...");
					
					deleteSingleBT.setEnabled(false);
					
					if(temporaryListListContainer.size() == 0){
						deleteAllBT.setEnabled(false);
						exportXMLBT.setEnabled(false);
					}
				}
			}
		});
		
		exportXMLBT.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = -5666247399646245663L;
			
			public void buttonClick(ClickEvent event) {


//				Header headerContext = new Header();
//				headerContext = applicationContext.getBean(CaCAUUseCaseConfigurationPROGRAM.class).getHeaderContext();
//				useCaseConfiguration
				
				XMLCaCAUGenerator xmlCaCAUGenerator = new XMLCaCAUGenerator();
				UseCaseGenerator useCaseGenerator = new UseCaseGenerator();

				List<User> users = new ArrayList<User>();
				users.add(applicationContext.getBean(UserCaCAUContext.class).getUser());
				
				USECASE useCase = useCaseGenerator.generateUseCase(useCaseConfiguration , users);
				
				String xmlFileName = "UseCaseExport";
				String ABSOLUTE_PATH_XML_FOLDER = "C://Users//Public//";
				
				xmlCaCAUGenerator.generateXML(useCase, ABSOLUTE_PATH_XML_FOLDER, xmlFileName);

				Notification.show("The Use Case was generated with success!");

			}
		});

		commandHL.addComponent(exportXMLBT);
		commandHL.addComponent(deleteSingleBT);
		commandHL.addComponent(deleteAllBT);

		commandHL.setExpandRatio(exportXMLBT, 3);
		commandHL.setExpandRatio(deleteSingleBT, 1);
		commandHL.setExpandRatio(deleteAllBT, 1);

		addComponent(infoConfigurationLB);
		addComponent(tbTemporaryList);
		addComponent(commandHL);
		
		setExpandRatio(infoConfigurationLB, 1);
		setExpandRatio(tbTemporaryList, 10);
		setExpandRatio(commandHL, 3);

	}
	
	private void setUserSelectecParameterTableProperties(){
		
		tbTemporaryList.setVisibleColumns("parameterId", "applicabilityProgramAcType", "parameterName", "parameterDescription", "emitterName", "applicability", "applicabilityEngine", "label", "system", "labelSigned", "minSamplingFrequence", "inlay", "side", "hiPinNumber", "hiPinChar", "busFunction");
		tbTemporaryList.setColumnHeaders("ID", "Program", "Name", "Description", "Emitter", "Applicability", "Engine", "Label", "System", "Signed", "Min.Sampl", "Inlay", "Side", "H.P Number", "H.P Char", "Bus Funct");

		tbTemporaryList.setColumnAlignment("yourPropertyId", Align.CENTER);
		tbTemporaryList.setColumnAlignment("applicabilityProgramAcType", Align.CENTER);
		tbTemporaryList.setColumnAlignment("parameterName", Align.CENTER);
		tbTemporaryList.setColumnAlignment("parameterDescription", Align.CENTER);
		tbTemporaryList.setColumnAlignment("emitterName", Align.CENTER);
		tbTemporaryList.setColumnAlignment("applicability", Align.CENTER);
		tbTemporaryList.setColumnAlignment("applicabilityEngine", Align.CENTER);
		tbTemporaryList.setColumnAlignment("label", Align.CENTER);
		tbTemporaryList.setColumnAlignment("system", Align.CENTER);
		tbTemporaryList.setColumnAlignment("labelSigned", Align.CENTER);
		tbTemporaryList.setColumnAlignment("minSamplingFrequence", Align.CENTER);
		tbTemporaryList.setColumnAlignment("inlay", Align.CENTER);
		tbTemporaryList.setColumnAlignment("side", Align.CENTER);
		tbTemporaryList.setColumnAlignment("hiPinNumber", Align.CENTER);
		tbTemporaryList.setColumnAlignment("hiPinChar", Align.CENTER);
		tbTemporaryList.setColumnAlignment("busFunction", Align.CENTER);
		
	}
}
