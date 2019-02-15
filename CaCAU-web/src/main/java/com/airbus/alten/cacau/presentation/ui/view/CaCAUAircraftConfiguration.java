package com.airbus.alten.cacau.presentation.ui.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.airbus.alten.cacau.presentation.ui.manager.CaCAUApplicationNavigatorManager;
import com.airbus.alten.cacau.presentation.ui.manager.CaCAUUIManager;
import com.airbus.alten.cacau.presentation.ui.manager.GenericCaCAUVerticalLayout;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = CaCAUAircraftConfiguration.MAIN_URL, ui = CaCAUUIManager.class)
@Theme("cacau")
public class CaCAUAircraftConfiguration extends GenericCaCAUVerticalLayout implements View {

	private static final long serialVersionUID = 8392442034382750867L;

	public static final String MAIN_URL = "aircraft-configuration";

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private SpringViewProvider springViewProvider;

	private static final int SIZE = 250;

	public void entreCaCAU(ViewChangeEvent event) {

		setSizeFull();
		setSpacing(true);
		setMargin(true);


		Panel searchPanel = new Panel();
		searchPanel.setSizeFull();	

		VerticalLayout verticalLayout = new VerticalLayout();
		HorizontalLayout inputHorizontalLayout = new HorizontalLayout();

		inputHorizontalLayout.setSizeFull();
		inputHorizontalLayout.setSpacing(true);
		inputHorizontalLayout.setMargin(true);
				
		final Label current = new Label ("Selected: -"); // works - from example 

		final PopupView popupView = new PopupView(null, new Button("CIAOO")); 
		popupView.setVisible(false);
		
		
		inputHorizontalLayout.addComponent(popupView);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------		
		HorizontalLayout commandHorizontalLayout = new HorizontalLayout();

		commandHorizontalLayout.setSizeFull();
		commandHorizontalLayout.setSpacing(true);
		commandHorizontalLayout.setMargin(true);

		//buttons - begin
		final Button bCancel = new Button("Cancel", FontAwesome.BACKWARD);
		bCancel.setWidth(SIZE, Unit.PIXELS);

		final Button bBack = new Button("Back", FontAwesome.STEP_BACKWARD);
		bBack.setWidth(SIZE, Unit.PIXELS);

		// Handle the events with an anonymous class
		bBack.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = -5666247399646245663L;

			public void buttonClick(ClickEvent event) {
				//CaCAUApplicationNavigatorManager.navigate(CaCAUMainApplicationView.MAIN_URL);
				CaCAUApplicationNavigatorManager.navigate(CaCAUChooseProgram.MAIN_URL);
			}

		});

		final Button bSave = new Button("Save", FontAwesome.SAVE);
		bSave.setWidth(SIZE, Unit.PIXELS);

		// Handle the events with an anonymous class
		bSave.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = -5666247399646245663L;

			public void buttonClick(ClickEvent event) {

				//CaCAUApplicationNavigatorManager.navigate(CaCAUChooseProgram.MAIN_URL); //will call and insert into the tmp list
			}

		});

		commandHorizontalLayout.addComponent(bSave);
		commandHorizontalLayout.addComponent(bCancel);
		commandHorizontalLayout.addComponent(bBack);

		verticalLayout.addComponent(inputHorizontalLayout);
		verticalLayout.addComponent(commandHorizontalLayout);
		searchPanel.setContent(verticalLayout);

		addComponent(searchPanel);

		setExpandRatio(searchPanel, 8);

	}

}
