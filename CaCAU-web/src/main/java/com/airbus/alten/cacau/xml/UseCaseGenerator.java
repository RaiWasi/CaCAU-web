package com.airbus.alten.cacau.xml;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.airbus.alten.cacau.model.UseCaseConfiguration;
import com.airbus.alten.cacau.model.User;
import com.airbus.alten.cacau.model.UserParameter;
import com.airbus.alten.cacau.model.xml.AIRLINE;
import com.airbus.alten.cacau.model.xml.APPLICABILITY;
import com.airbus.alten.cacau.model.xml.AUTHOR;
import com.airbus.alten.cacau.model.xml.CONFIGURATION;
import com.airbus.alten.cacau.model.xml.CONTENT;
import com.airbus.alten.cacau.model.xml.EMITTER;
import com.airbus.alten.cacau.model.xml.EQUIPMENT;
import com.airbus.alten.cacau.model.xml.HEADER;
import com.airbus.alten.cacau.model.xml.HLDOCUMENT;
import com.airbus.alten.cacau.model.xml.LABEL;
import com.airbus.alten.cacau.model.xml.PARAMETER;
import com.airbus.alten.cacau.model.xml.PROGRAM;
import com.airbus.alten.cacau.model.xml.REFERENCE;
import com.airbus.alten.cacau.model.xml.RELEASE;
import com.airbus.alten.cacau.model.xml.USECASE;
import com.airbus.alten.cacau.model.xml.YPBATCH;

public class UseCaseGenerator {

	public USECASE generateUseCase(UseCaseConfiguration useCaseConfiguration, List<User> users) {

		List<UserParameter> userParameters = useCaseConfiguration.getUserParameters();
		
		//----------------------------------------------------------------------------------------------
	    Map<String, String> mapOfEmitter = new HashMap<String, String>();
	    
		for(UserParameter p : userParameters){
			
			if(!mapOfEmitter.containsKey(p.getEmitterName())){
				
				System.out.println(p.getEmitterName());
				mapOfEmitter.put(p.getEmitterName(), p.getEmitterName());
			}
			
	    }
		
	    Map<String, String> mapOfParameter = new HashMap<String, String>();
	    
		for(UserParameter p : userParameters){
			
			if(!mapOfParameter.containsKey(p.getParameterName())){
				
				System.out.println(p.getParameterName().toString());
				mapOfParameter.put(p.getParameterName().toString(), p.getParameterName().toString());
			}
			
	    }
		
	    Map<String, String> mapOfLabel = new HashMap<String, String>();
	    
		for(UserParameter p : userParameters){
			
			if(!mapOfLabel.containsKey(p.getLabel().toString())){
				
				System.out.println(p.getLabel().toString());
				mapOfLabel.put(p.getLabel().toString(), p.getLabel().toString());
			}
			
	    }
		

		// ------------------------------------------------------------------------------------------------------------------------------------//
		// USECASE
		USECASE useCase = new USECASE();

		if (useCase != null) {

			// ------------------------------------------------------------------------------------------------------------------------------------//
			// HEADER
			HEADER header = new HEADER();

			if (header != null) {

				// ------------------------------------------------------------------------------------------------------------------------------------//


				// Author list
				List<AUTHOR> listAuthor = new ArrayList<AUTHOR>();
				
				for(User u : users){
					
					// AUTHOR
					AUTHOR author = new AUTHOR();
					author.setName(u.getName());
					author.setDepartment(u.getDepartment());
					author.setFunction(u.getFunction());
					
					listAuthor.add(author);
				}
				
				// Add author list in Header
				header.setAUTHOR(listAuthor);

				// ------------------------------------------------------------------------------------------------------------------------------------//
				// REFERENCE
				REFERENCE reference = new REFERENCE();
				reference.setTitle("Title");
				reference.setNumber("Number");
				reference.setIssue("Issue");
				reference.setServicetype("Servicetype");

				// Add reference in Header
				header.setREFERENCE(reference);

				// ------------------------------------------------------------------------------------------------------------------------------------//
				// RELEASE
				RELEASE release = new RELEASE();
				release.setVersion("Version");
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
				LocalDate localDate = LocalDate.now();
				release.setDate(dtf.format(localDate)); // 2016/11/16
				release.setDescription("Description");
				release.setStatus("Status");

				// Add release in Header
				header.setRELEASE(release);

				// ------------------------------------------------------------------------------------------------------------------------------------//
				// HLDOCUMENT
				HLDOCUMENT hLDocument = new HLDOCUMENT();
				hLDocument.setTitle("Title");
				hLDocument.setReference("Reference");
				hLDocument.setIssue("Issue");

				// HLDocument list
				List<HLDOCUMENT> listHLDocument = new ArrayList<HLDOCUMENT>();
				listHLDocument.add(hLDocument);
				header.setHLDOCUMENT(listHLDocument);

				// Set Header in Usecase
				useCase.setHEADER(header);
			}

			// ------------------------------------------------------------------------------------------------------------------------------------//
			// CONFIGURATION
			CONFIGURATION configuration = new CONFIGURATION();

			if (configuration != null) {

				// ------------------------------------------------------------------------------------------------------------------------------------//
				// CONTENT
				CONTENT content = new CONTENT();
				content.setContentid(1);
				content.setTitle(useCaseConfiguration.getTitle());

				// APPLICABILITY
				APPLICABILITY applicability = new APPLICABILITY();

				if (applicability != null) {

					//for (int i = 0; i < userParameters.size(); i++) { //better to read from filtering chosenProgram... 31.10
					
					List<PROGRAM> listProgram = new ArrayList<PROGRAM>();
					PROGRAM program = new PROGRAM();
					program.setActype(useCaseConfiguration.getProgram());
					program.setEnginesupplier("Enginesupplier");
					program.setEnginetype(useCaseConfiguration.getEngines().get(0).getEngineName());
					program.setAputype(useCaseConfiguration.getApus().get(0).getApuName());
					listProgram.add(program);

					//airline value not available until now - 31.10
					List<AIRLINE> listAirline = new ArrayList<AIRLINE>();
					AIRLINE airline = new AIRLINE();
					airline.setIcaoCode("IcaoCode");
					airline.setTailnumber("Tailnumber");
					listAirline.add(airline);

					//Equip. value not available until now - 31.10
					List<EQUIPMENT> listEquipment = new ArrayList<EQUIPMENT>();
					EQUIPMENT equipment = new EQUIPMENT();
					equipment.setFin( userParameters.get(0).getFin());
					equipment.setFd("Fd");
					equipment.setName("Name");
					equipment.setSwpn("Swpn");
					equipment.setHwpn("Hwpn");
					listEquipment.add(equipment);

					applicability.setPROGRAM(listProgram);
					applicability.setAIRLINE(listAirline);
					applicability.setEQUIPMENT(listEquipment);

					// Set Applicability
					content.setAPPLICABILITY(applicability);
					//}
				}

			    
				List<EMITTER> emitterlist = new ArrayList<EMITTER>();
			    int indexEmitter = 1;
			    
				for (Entry<String, String> EmitterEntry : mapOfEmitter.entrySet()) {
			        
					List<UserParameter> currentSelectParameterList_1 = new ArrayList<UserParameter>();
					
					for(UserParameter p : userParameters){
						
						if(p.getEmitterName().equals(EmitterEntry.getKey())){
							
							currentSelectParameterList_1.add(p);
						}
					}
					
					// EMITTER
					EMITTER emitter = new EMITTER();
					emitter.setEmitterid(indexEmitter);
					emitter.setEquipmentCode(currentSelectParameterList_1.get(0).getEquipmentCode());
					emitter.setEmitterName(currentSelectParameterList_1.get(0).getEmitterName());
					
					//converting to string and then to Integer
					String ff = "4";
					Integer id = new Integer(ff);
					emitter.setSide(id.intValue());
					emitter.setBusfunction(currentSelectParameterList_1.get(0).getBusFunction());
					emitter.setInlay(currentSelectParameterList_1.get(0).getInlay());
					emitter.setHiPinNumber(currentSelectParameterList_1.get(0).getHiPinNumber());
					emitter.setHiPinChar(currentSelectParameterList_1.get(0).getHiPinChar());
					
					List<PARAMETER> parameterList = new ArrayList<PARAMETER>();
					int indexParameter = 1;
					
					for(UserParameter cp : currentSelectParameterList_1){
						
						List<UserParameter> currentSelectParameterList_2 = new ArrayList<UserParameter>();
						
						for (Entry<String, String> parameterEntry : mapOfParameter.entrySet()) {
	
							if(cp.getParameterName().equals(parameterEntry.getKey())){
								
								currentSelectParameterList_2.add(cp);
							}
						}
						
						
						PARAMETER parameter = new PARAMETER();
						parameter.setParameterId(indexParameter);
						parameter.setYpparameterId("setYpparameterId");
						parameter.setParameterName(cp.getParameterName());
						parameter.setDescription(cp.getParameterDescription());
						parameter.setMinSamplingFreq(cp.getMinSamplingFrequence()); //need to be tested - 06.11

	
						List<LABEL> labelList = new ArrayList<LABEL>();
						int indexLabel = 1;
						
						for(UserParameter pp : currentSelectParameterList_2){
							
							LABEL label = new LABEL();
							label.setLabelId(indexLabel);
							label.setNumberOctal(String.valueOf(pp.getOctalNumber()));
							label.setOrder(pp.getLabelOrder());
							label.setSdi(String.valueOf(pp.getLabelSDI()));
							
							if(pp.getMsb() != null)
								label.setMsb(Integer.valueOf(pp.getMsb()));
							else
								
							
							label.setLen(Integer.valueOf(pp.getLabelLen()));
							
							if(pp.getLabelSigned())
								label.setSigned("Yes");
							else
								label.setSigned("No");
								
							 
							
							labelList.add(label);
							indexLabel++;
						}
						parameter.setLABEL(labelList);
						parameterList.add(parameter);
						indexParameter++;
					}
					emitter.setPARAMETER(parameterList);
					emitterlist.add(emitter);
					indexEmitter++;
					
				}
				content.setEMITTER(emitterlist);
				configuration.setCONTENT(content);
				
//-----------------------------------------------------------------------------------------------------------------------------------------------------
	

				YPBATCH ypBatch = new YPBATCH();
				ypBatch.setBatchnumber(3);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate localDatex = LocalDate.now();
				ypBatch.setDate(dtf.format(localDatex)); // 2016/11/16

				configuration.setYPBATCH(ypBatch);
				useCase.setCONFIGURATION(configuration);
			}

			// ------------------------------------------------------------------------------------------------------------------------------------//
			// // EXPLORATION
			//// EXPLORATION exploration = new EXPLORATION();
			//
			// // configuration.setEXPLORATION(exploration);
			//
			// // Set Configuration
			// useCase.setCONFIGURATION(configuration);
			// }
			//
			// }
			//
			// moduleName = moduleName.trim();
			// moduleName = moduleName.replace(" ", "-");
			// moduleName = moduleName.replace("/", "");
			// Pattern pt = Pattern.compile("[^a-zA-Z0-9]");
			// Matcher match = pt.matcher(moduleName);
			// while (match.find()) {
			// moduleName = moduleName.replaceAll("[^a-zA-Z0-9]", "-");
			// }
			// moduleName = moduleName.replace("--", "-");
			//
			// moduleName = "/XML/" + moduleName +
			// "-UseCase-ADC-Configuration-Load.xml";
			//
			// useCaseJaxbObjectToXML(moduleName, useCase);
			//
			// USECASE empFromFile = useCaseJaxbXMLToObject(moduleName);
			// System.out.println();
			// System.out.println(empFromFile);
			// System.out.println("XML generated in :" +
			// ABSOLUTE_PATH_XML_SCHEMA_FOLDER + moduleName);
			//
			// // loadXMLAndXSDFiles(moduleName);
			// //
			// // if (validateXMLFile())
			// // System.out.println("******* Your XML file are successfully
			// // validated*******");
		}
		return useCase;
	}
}
