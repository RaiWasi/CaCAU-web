package com.airbus.alten.cacau.presentation.ui.manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

public class GenericCaCAUVerticalLayout extends VerticalLayout{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LogManager.getLogger(GenericCaCAUVerticalLayout.class.getName());
	
	@Autowired
	private CaCAUUIManager caCAUUIManager;
	
	public void enter(ViewChangeEvent event) 
	{
        try {
        	entreCaCAU(event);
        } catch(Exception e) {
        	LOGGER.error(e.getMessage(), e);
        	caCAUUIManager.getAppErrorLB().setValue("Error");	
        }
	}

	protected void entreCaCAU(ViewChangeEvent event) {
		

	}

}
