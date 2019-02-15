package com.airbus.alten.cacau.presentation.ui.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.airbus.alten.cacau.presentation.ui.manager.CaCAUUIManager;
import com.airbus.alten.cacau.presentation.ui.manager.GenericCaCAUVerticalLayout;
import com.airbus.alten.cacau.yellowpage.jersey.webservice.YellowPageAPISeviceClient;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = CaCAUTaskPanel.MAIN_URL, ui = CaCAUUIManager.class)
@Theme("cacau")
public class CaCAUTaskPanel extends GenericCaCAUVerticalLayout implements View {

	private static final long serialVersionUID = 8392442034382750867L;

	public static final String MAIN_URL = "task-panel";

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private SpringViewProvider springViewProvider;
	
	@Autowired
	private YellowPageAPISeviceClient jerseyClient;
	
	private static final int SIZE = 250;
	private static final int MENU_BUTTONS_SIZE = 200;

	public void entreCaCAU(ViewChangeEvent event) {
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	    //LOGGER.debug("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	    //LOGGER.info("Choose Program");
	    //LOGGER.debug("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		//-----PANEL_MENU_TASK ------------------------------------------------------------------------------------------------------------------------------------------
		setSizeFull();
		setSpacing(true);
		setMargin(true);


				
		// ------ testing taskpanel - end
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

		Panel searchPanel = new Panel();
		searchPanel.setSizeFull();	
		
		VerticalLayout verticalLayout = new VerticalLayout();
		HorizontalLayout inputHorizontalLayout = new HorizontalLayout();
		
		inputHorizontalLayout.setSizeFull();
		inputHorizontalLayout.setSpacing(true);
		inputHorizontalLayout.setMargin(true);

		//CaCAUApplicationNavigatorManager.navigate(CaCAUTaskPanel.MAIN_URL); // NOT WORKING testing calling
		
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
				

		verticalLayout.addComponent(inputHorizontalLayout);
		searchPanel.setContent(verticalLayout);

		addComponent(searchPanel);
				
	}
}
