package com.airbus.alten.cacau.utils;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteXMLFile {

	public static void main(String argv[]) {

		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("USECASE");
			doc.appendChild(rootElement);

			// header elements
			Element header = doc.createElement("HEADER");
			rootElement.appendChild(header);

			//new
			Element author = doc.createElement("AUTHOR");
			header.appendChild(author);
			
			// set attribute to header element
			Attr attr = doc.createAttribute("name");
			attr.setValue("LE COQ Julien");
			author.setAttributeNode(attr);

			// shorten way
			// header.setAttribute("id", "1");

			// reference elements
			Element reference = doc.createElement("REFERENCE");
			reference.setNodeValue("title");
			reference.appendChild(doc.createTextNode("Title of the Reference"));
			header.appendChild(reference);

			// release elements
			Element release = doc.createElement("RELEASE");
			release.setNodeValue("version");
			release.appendChild(doc.createTextNode("V1"));
			header.appendChild(release);

			// hldocument elements
			Element hldocument = doc.createElement("HLDOCUMENT");
			hldocument.setNodeValue("title");
			hldocument.appendChild(doc.createTextNode("Shock-Absorber-Mechanical-Degradation"));
			header.appendChild(hldocument);

			// write the content into xml file - IT WORKS - even the timestamp
			String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(new Date());
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:\\Users\\Public\\DevSoftware\\Export\\Use_Case_Request_V1_" + timestamp +".xml"));

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result); //source: xml tags; result: path + filename

			System.out.println("File saved!");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}

}
