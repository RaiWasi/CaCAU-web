package com.airbus.alten.cacau.presentation.ui.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.airbus.alten.cacau.model.json.SelectedParameter;
import com.airbus.alten.cacau.presentation.ui.manager.CaCAUUIManager;
import com.airbus.alten.cacau.presentation.ui.manager.GenericCaCAUVerticalLayout;
//import com.airbus.alten.cacau.repository.impl.HeaderRepositoryImpl;
import com.airbus.alten.cacau.xml.UseCaseGenerator;
import com.airbus.alten.cacau.xml.XMLCaCAUGenerator;
import com.airbus.alten.cacau.yellowpage.jersey.webservice.YellowPageAPISeviceClient;
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
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = CaCAUExport.MAIN_URL, ui = CaCAUUIManager.class)
@Theme("cacau")
public class CaCAUExport extends GenericCaCAUVerticalLayout implements View {

	private static final long serialVersionUID = 8392442034382750867L;

	public static final String MAIN_URL = "export-xml";

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private SpringViewProvider springViewProvider;

	@Autowired
	private YellowPageAPISeviceClient jerseyClient;

	private static final int MENU_BUTTONS_SIZE = 200;
	private static final int SIZE = 250;
	private static final int HEIGHT = 40;
	private static final int LONG_FIELD_WIDTH = 600;
	private static final int FIELD_HEIGHT = 30;

//	HeaderRepositoryImpl headerRepositoryImpl = new HeaderRepositoryImpl();
	String winUser = "";

	//Vaadin Components
	Label lbHeader = new Label();

	//Application Context
//	List<Header> selectedHeaderContext = new ArrayList<Header>(); //funk - 31.10
//	Header headerContext = new Header(); //funk - 31.10

	public void entreCaCAU(ViewChangeEvent event) {

		setSizeFull();
		setSpacing(true);
		setMargin(true);



		//-----PANEL SEARCH ---------------------------------------------------------------------------------------------------------------------------------------------------
		Panel searchPanel = new Panel();
		searchPanel.setSizeFull();

		VerticalLayout verticalLayout = new VerticalLayout();
		HorizontalLayout inputHorizontalLayout = new HorizontalLayout();
		HorizontalLayout inputHorizontalLayout2 = new HorizontalLayout();

		inputHorizontalLayout2.setSizeFull();
		inputHorizontalLayout2.setSpacing(true);
		inputHorizontalLayout2.setMargin(true);

		inputHorizontalLayout.setSizeFull();
		inputHorizontalLayout.setSpacing(true);
		inputHorizontalLayout.setMargin(true);

		final TextField tfExportPath = new TextField("File Path : C:/Users/NG6629C/Documents/CaCAU/Export/");
		tfExportPath.setWidth(LONG_FIELD_WIDTH, Unit.PIXELS);
		tfExportPath.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		//tfExportPath.setValue(path);
		//fileName = tfExportPath.getValue();

		final Button bSave = new Button("Save as...", FontAwesome.SAVE);
		bSave.setWidth(SIZE, Unit.PIXELS);
		bSave.setHeight(HEIGHT, Unit.PIXELS);
		
//		selectedHeaderContext = applicationContext.getBean(CaCAUUseCaseConfigurationPROGRAM.class).getSelectedHeaderContext(); //ArrayList filled with just one header - 31.10
//		headerContext = applicationContext.getBean(CaCAUUseCaseConfigurationPROGRAM.class).getHeaderContext(); //Single Header also filled - 31.10
//
//		winUser = System.getenv("USERNAME");
//		lbHeader = new Label("The following Header will be used for the Use Case - Author: " 
//			+ selectedHeaderContext.get(0).getAuthorName() + " , " + selectedHeaderContext.get(0).getAuthorDepartment() + " , " + selectedHeaderContext.get(0).getAuthorFunction()
//			+ ". Document : " + selectedHeaderContext.get(0).getHlDocumentTitle()
//			+ ". Use Case Number : " + selectedHeaderContext.get(0).getUseCaseNumber() + " , " + selectedHeaderContext.get(0).getReleaseDate()
//			+ ". Please check the information for the header of the XML file in the view 'Header' before exporting the Use Case !");
//		lbHeader.addStyleName(ValoTheme.LABEL_SUCCESS);
//		
//		System.out.println("Header from app. context as an array list : " + selectedHeaderContext.get(0).getAuthorName()); //funk! - 31.10
//		System.out.println("single Header as a type in app. context instead of an array list as in the label above : " + headerContext.getAuthorName()); //funk! - 31.10

		bSave.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = -5666247399646245663L;

			@SuppressWarnings("deprecation")
			public void buttonClick(ClickEvent event) {

				List<SelectedParameter>  selectedParameter= new ArrayList<SelectedParameter>();
//				selectedParameter = applicationContext.getBean(UseCaseConfigurationContext.class).getSelectedParameterContext();

//				Header headerContext = new Header();
//				headerContext = applicationContext.getBean(CaCAUUseCaseConfigurationPROGRAM.class).getHeaderContext();
				
				XMLCaCAUGenerator xmlCaCAUGenerator = new XMLCaCAUGenerator();
				UseCaseGenerator useCaseGenerator = new UseCaseGenerator();

//				USECASE useCase = useCaseGenerator.generateUseCase(selectedParameter, headerContext); //funk - 31.10
				String xmlFileName = "UseCase";

				String ABSOLUTE_PATH_XML_FOLDER = "C://Users//Public//DevSoftware//Export//";
//				xmlCaCAUGenerator.generateXML(useCase, ABSOLUTE_PATH_XML_FOLDER, xmlFileName);

				Notification.show("The Use Case was generated with success!", Notification.TYPE_HUMANIZED_MESSAGE );
			}
		});

		inputHorizontalLayout.addComponent(tfExportPath);
		inputHorizontalLayout.addComponent(bSave);
		inputHorizontalLayout2.addComponent(lbHeader);

		// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		// adding the layouts to the main layout

		verticalLayout.addComponent(inputHorizontalLayout2);
		verticalLayout.addComponent(inputHorizontalLayout);
		verticalLayout.setExpandRatio(inputHorizontalLayout, 3);
		searchPanel.setContent(verticalLayout);

		addComponent(searchPanel);

	}
}
