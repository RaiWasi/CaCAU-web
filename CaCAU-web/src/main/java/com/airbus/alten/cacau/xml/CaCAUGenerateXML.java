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

import com.airbus.alten.cacau.model.xml.CaCAUUseCase;


//this was just the Demo Version, today a new Version was created to generate the Export in XML  - 30.10
public class CaCAUGenerateXML {

	private static String ABSOLUTE_PATH_XML_SCHEMA_FOLDER = "C:\\Users\\Public\\DevSoftware\\Export";
	
	private static final String FileXML_Shopping_List_EXAMPLE = "/CacauDemo.xml";
	
	private static String ADC_CONFIGURATION_SCHEMA_XSD = "/CacauDemo.xsd";
	private static StreamSource streamSourceXSD;
	private static StreamSource streamSourecXML;
	
	public void generateXML(CaCAUUseCase caCAUUseCase) {
		
		try {

			File file = new File(ABSOLUTE_PATH_XML_SCHEMA_FOLDER + FileXML_Shopping_List_EXAMPLE);
			JAXBContext jaxbContext = JAXBContext.newInstance(CaCAUUseCase.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(caCAUUseCase, file);
			jaxbMarshaller.marshal(caCAUUseCase, System.out);

			this.streamSourceXSD = new StreamSource(
					new File(ABSOLUTE_PATH_XML_SCHEMA_FOLDER + ADC_CONFIGURATION_SCHEMA_XSD));
			this.streamSourecXML = new StreamSource(new File(ABSOLUTE_PATH_XML_SCHEMA_FOLDER + FileXML_Shopping_List_EXAMPLE));
			
			validateXMLFile();
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
	
	public static boolean validateXMLFile() {
		boolean result = false;

		try {

			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Source[] xsdSchema = new Source[] { streamSourceXSD };

			for (Source Source : xsdSchema) {
				System.out.println(Source);
			}
			System.out.println("\n");

			Schema schema = schemaFactory.newSchema(xsdSchema);

			Validator validator = schema.newValidator();
			validator.validate(streamSourecXML);
			result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
