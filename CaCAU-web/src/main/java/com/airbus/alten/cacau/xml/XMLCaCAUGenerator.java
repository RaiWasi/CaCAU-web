package com.airbus.alten.cacau.xml;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import com.airbus.alten.cacau.model.xml.USECASE;
import com.vaadin.server.VaadinService;

public class XMLCaCAUGenerator {

	private static final String XSD_SCHEMA_PATH = "/WEB-INF/schema/Schema_ADC_UseCase_XML_V1D009.xsd";
	private static final String XML = ".xml";
	private static StreamSource streamSourceXSD; //for multiple xsd
	private static StreamSource streamSourceXML; //for multiple xsd

	public boolean generateXML(USECASE useCase, String ABSOLUTE_PATH_FOLDER, String FileName) {

		boolean result = false;
		
		try {

			FileName = FileName + XML;
			File file = new File(ABSOLUTE_PATH_FOLDER + FileName);

			JAXBContext jaxbContext = JAXBContext.newInstance(USECASE.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(useCase, file);

			// Find the application directory
			String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();

			streamSourceXSD = new StreamSource(
					new File(basepath + XSD_SCHEMA_PATH));
			streamSourceXML = new StreamSource(new File(ABSOLUTE_PATH_FOLDER + FileName));
			
//			result = isXMLFileValideAgainXSD();
//			
//			if (!result) {
//				file.delete();
//				System.out.println("File remove");
//			}

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return result; //false because it wasnt validated yet
	}

	private static boolean isXMLFileValideAgainXSD() {

		boolean result = false;
		try {
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Source[] xsdSchema = new Source[] { streamSourceXSD };

			Schema schema = schemaFactory.newSchema(xsdSchema);
			Validator validator = schema.newValidator();
			validator.validate(streamSourceXML);
			result = true;
			System.out.println("Generated is complain");

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		return result;
	}
}
