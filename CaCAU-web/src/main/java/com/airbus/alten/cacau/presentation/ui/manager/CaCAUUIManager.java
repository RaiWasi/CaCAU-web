package com.airbus.alten.cacau.presentation.ui.manager;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.airbus.alten.cacau.model.business.UserCaCAUContext;
import com.airbus.alten.cacau.presentation.ui.view.CaCAUAirlinesEquipmentView;
import com.airbus.alten.cacau.presentation.ui.view.CaCAUChooseProgram;
import com.airbus.alten.cacau.presentation.ui.view.CaCAUDummyParameter;
import com.airbus.alten.cacau.presentation.ui.view.CaCAUExport;
import com.airbus.alten.cacau.presentation.ui.view.CaCAUHeader;
import com.airbus.alten.cacau.presentation.ui.view.CaCAUSearchByCriteria;
import com.airbus.alten.cacau.presentation.ui.view.CaCAUTemporaryList;
import com.airbus.alten.cacau.presentation.ui.view.CaCAUUserManagmentView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.event.MouseEvents;
import com.vaadin.server.FileResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path=CaCAUUIManager.MAIN_URL)
@Title("CaCAU Application")
@Theme("cacau")
public class CaCAUUIManager extends UI {

	private static final long serialVersionUID = -2460788284116577758L;

	public static final String MAIN_URL = "/main";
	
	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private SpringViewProvider springViewProvider;
	
	private VerticalLayout rootVLayout = new VerticalLayout();
	private Panel appHeaderPanel = new Panel();
	private Panel appMenuPanel = new Panel();
	private Panel appContentPanel = new Panel();
	
	private HorizontalLayout appHeaderHL = new HorizontalLayout();
	
	private HorizontalLayout mainMenuHL = new HorizontalLayout();
	private HorizontalLayout basicMenuHL = new HorizontalLayout();
	private HorizontalLayout mainAdminMenuHL = new HorizontalLayout();
	private HorizontalLayout mainErrorMenuHL = new HorizontalLayout();
	
	private Label titleLB = new Label("CaCAU - Case Configurator for ADC Usage");
	private Label userInfoAndAppVersionLB = new Label();
	
	//buttons menu
	
	private final Button newConfigProjectBT = new Button("Project");
	private final Button searchByCriteriaBT = new Button("Search", FontAwesome.SEARCH);
	private final Button temporaryParameterBT = new Button("Temporary List", FontAwesome.SHOPPING_CART);
	private final Button dummyBT = new Button("Dummy");
	private final Button airlineEquipmentInfoBT = new Button("Airlines", FontAwesome.GEARS);
	
	private final Button authorInfoBT = new Button("Author Info", FontAwesome.GEARS);
	
	private final Button bExport = new Button("Export", FontAwesome.DOWNLOAD);
	
	private final Button userManagmentBT = new Button("User Settings", FontAwesome.GEARS);

	private Label appErrorLB = new Label();

	@Override
	protected void init(VaadinRequest request) {

		
		rootVLayout.setSizeFull();
		rootVLayout.setMargin(true);
		rootVLayout.setSpacing(true);

		appHeaderPanel.setWidth(100, Unit.PERCENTAGE);
		
		appMenuPanel.setWidth(100, Unit.PERCENTAGE);
		appMenuPanel.setStyleName("cacauMenu");

		appContentPanel.setSizeFull();

		appHeaderHL.setMargin(true);
		appHeaderHL.setWidth(100, Unit.PERCENTAGE);
			
		//------------------------------------------------------------------------------------------------------------------------------
		// APPLICATION MENU
			
		mainMenuHL.setSpacing(true);
		mainMenuHL.setMargin(true);
		mainMenuHL.setWidth(100, Unit.PERCENTAGE);
		
		basicMenuHL.setWidth(100, Unit.PERCENTAGE);
		basicMenuHL.setSpacing(true);
		
		mainErrorMenuHL.setWidth(100, Unit.PERCENTAGE);
		
		mainAdminMenuHL.setWidth(100, Unit.PERCENTAGE);
		mainAdminMenuHL.setSpacing(true);
		
		enableAllButton(false);
		
		enableAllAdminButton(applicationContext.getBean(UserCaCAUContext.class).getUserRole());
		
		appErrorLB.addStyleName("errorLabel");
		titleLB.addStyleName("apptitle");
		
		// Find the application directory
		String basepath = VaadinService.getCurrent()
				.getBaseDirectory().getAbsolutePath();

		// Image as a file resource
		FileResource resourceLogo = new FileResource(new File(basepath +
				"/WEB-INF/images/CaCAU_Logo_smallest.png"));

		// Show the image in the application
		Image logo = new Image("", resourceLogo);
		logo.setWidth(110, Unit.PIXELS);
		logo.setHeight(110, Unit.PIXELS);
		
		userInfoAndAppVersionLB.setValue(applicationContext.getBean(UserCaCAUContext.class).getUsername() + " " + applicationContext.getBean(UserCaCAUContext.class).getUserRole());

		// Image as a file resource
		FileResource resourceLogout = new FileResource(new File(basepath + "/WEB-INF/images/exit.png"));
		// Show the image in the application
		Image logout = new Image("", resourceLogout);
		logout.setWidth(30, Unit.PIXELS);
		logout.setHeight(30, Unit.PIXELS);
		
		
		
		newConfigProjectBT.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = -5666247399646245663L;

			public void buttonClick(ClickEvent event) {
				enableAllButton(false);
				CaCAUApplicationNavigatorManager.navigate(CaCAUChooseProgram.MAIN_URL);
			}
		});

		searchByCriteriaBT.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = -5666247399646245663L;

			public void buttonClick(ClickEvent event) {

				CaCAUApplicationNavigatorManager.navigate(CaCAUSearchByCriteria.MAIN_URL);
			}
		});

		temporaryParameterBT.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = -5666247399646245663L;

			public void buttonClick(ClickEvent event) {

				CaCAUApplicationNavigatorManager.navigate(CaCAUTemporaryList.MAIN_URL);
			}
		});

		dummyBT.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = -5666247399646245663L;

			public void buttonClick(ClickEvent event) {
				CaCAUApplicationNavigatorManager.navigate(CaCAUDummyParameter.MAIN_URL);
			}
		});
	
		airlineEquipmentInfoBT.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = -5666247399646245663L;

			public void buttonClick(ClickEvent event) {
				CaCAUApplicationNavigatorManager.navigate(CaCAUAirlinesEquipmentView.MAIN_URL);
			}
		});
		
		authorInfoBT.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = -5666247399646245663L;

			public void buttonClick(ClickEvent event) {
				CaCAUApplicationNavigatorManager.navigate(CaCAUHeader.MAIN_URL);
			}
		});

		bExport.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = -5666247399646245663L;

			public void buttonClick(ClickEvent event) {
				CaCAUApplicationNavigatorManager.navigate(CaCAUExport.MAIN_URL);
			}
		});
		
		userManagmentBT.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = -5666247399646245663L;

			public void buttonClick(ClickEvent event) {
				
				CaCAUApplicationNavigatorManager.navigate(CaCAUUserManagmentView.URL_PATH);
				
			}
		});
		
		logout.addClickListener(new MouseEvents.ClickListener() {
	        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
	        public void click(MouseEvents.ClickEvent event) {
	            
	        	SecurityContextHolder.clearContext();
				UI.getCurrent().getPage().setLocation("/CaCAU-App/login");
	        }
	    });

		basicMenuHL.addComponent(newConfigProjectBT);
		basicMenuHL.addComponent(searchByCriteriaBT);
		basicMenuHL.addComponent(dummyBT);
		basicMenuHL.addComponent(airlineEquipmentInfoBT);
		basicMenuHL.addComponent(authorInfoBT);
		basicMenuHL.addComponent(temporaryParameterBT);

		mainErrorMenuHL.addComponent(appErrorLB);
	
		mainAdminMenuHL.addComponent(userManagmentBT);
		
		appHeaderHL.addComponent(logo);
		appHeaderHL.addComponent(titleLB);
		appHeaderHL.addComponent(userInfoAndAppVersionLB);
		
		appHeaderHL.addComponent(logout);
		
		appHeaderHL.setComponentAlignment(logo, Alignment.MIDDLE_LEFT);
		appHeaderHL.setComponentAlignment(titleLB, Alignment.MIDDLE_LEFT);
		appHeaderHL.setComponentAlignment(userInfoAndAppVersionLB, Alignment.MIDDLE_RIGHT);
		appHeaderHL.setComponentAlignment(logout, Alignment.MIDDLE_RIGHT);

		appHeaderHL.setExpandRatio(logo, 5);
		appHeaderHL.setExpandRatio(titleLB, 60);
		appHeaderHL.setExpandRatio(userInfoAndAppVersionLB, 10);
		appHeaderHL.setExpandRatio(logout, 5);
		
		appHeaderPanel.setContent(appHeaderHL);
		
		mainMenuHL.addComponent(basicMenuHL);
		mainMenuHL.addComponent(mainErrorMenuHL);
		mainMenuHL.addComponent(mainAdminMenuHL);
		
		mainMenuHL.setExpandRatio(basicMenuHL, 65);
		mainMenuHL.setExpandRatio(mainErrorMenuHL, 20);
		mainMenuHL.setExpandRatio(mainAdminMenuHL, 20);
		
		appMenuPanel.setContent(mainMenuHL);

		
		rootVLayout.addComponent(appHeaderPanel);
		rootVLayout.addComponent(appMenuPanel);
		rootVLayout.addComponent(appContentPanel);

		rootVLayout.setExpandRatio(appContentPanel, 85);

		initNavigator();

		setContent(rootVLayout);
	}


	private void initNavigator() {

		CaCAUApplicationNavigatorManager cacauApplicationNavigatorManager = new CaCAUApplicationNavigatorManager(this,
				appContentPanel);
		applicationContext.getAutowireCapableBeanFactory().autowireBean(cacauApplicationNavigatorManager);
		cacauApplicationNavigatorManager.addProvider(springViewProvider);
		cacauApplicationNavigatorManager.navigateTo(CaCAUChooseProgram.MAIN_URL);

	}
	
	private void enableAllButton(Boolean b){
		
		
		newConfigProjectBT.setEnabled(b);
		searchByCriteriaBT.setEnabled(b);
		temporaryParameterBT.setEnabled(b);
		dummyBT.setEnabled(b);
		airlineEquipmentInfoBT.setEnabled(b);
		authorInfoBT.setEnabled(b);
		bExport.setEnabled(b);

		newConfigProjectBT.setStyleName("buttonNormale");
		searchByCriteriaBT.setStyleName("buttonNormale");
		temporaryParameterBT.setStyleName("buttonNormale");
		dummyBT.setStyleName("buttonNormale");
		airlineEquipmentInfoBT.setStyleName("buttonNormale");
		authorInfoBT.setStyleName("buttonNormale");
		bExport.setStyleName("buttonNormale");
		
	}
	
	private void enableAllAdminButton(String userRole){
		
		userManagmentBT.setVisible(false);
		
		userManagmentBT.setStyleName("buttonNormale");
		
		if(userRole != null && !userRole.isEmpty() && userRole.equals("ADMIN")){
			
			userManagmentBT.setEnabled(true);
			userManagmentBT.setVisible(true);
			
		}

	}


	public Button getNewConfigProjectBT() {
		return newConfigProjectBT;
	}


	public Button getSearchByCriteriaBT() {
		return searchByCriteriaBT;
	}


	public Button getTemporaryParameterBT() {
		return temporaryParameterBT;
	}


	public Button getAuthorInfoBT() {
		return authorInfoBT;
	}

	public Button getUserManagmentBT() {
		return userManagmentBT;
	}

	public Button getbExport() {
		return bExport;
	}

	public Button getDummyBT() {
		return dummyBT;
	}


	public Panel getAppMenuPanel() {
		return appMenuPanel;
	}


	public Label getAppErrorLB() {
		return appErrorLB;
	}


	public void setAppErrorLB(Label appErrorLB) {
		this.appErrorLB = appErrorLB;
	}


	public Button getAirlineEquipmentInfoBT() {
		return airlineEquipmentInfoBT;
	}

	
}
