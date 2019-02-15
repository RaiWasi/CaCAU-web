package com.airbus.alten.cacau.yellowpage.jersey.webservice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.airbus.alten.cacau.model.json.JSONYellowPageParameterResponse;
import com.airbus.alten.cacau.model.yellowpage.APIYellowPageAircraftsResponse;
import com.airbus.alten.cacau.model.yellowpage.APIYellowPagesApusResponse;
import com.airbus.alten.cacau.model.yellowpage.APIYellowPagesEnginesResponse;
import com.airbus.alten.cacau.model.yellowpage.ApuTypes;
import com.airbus.alten.cacau.model.yellowpage.Batch;
import com.airbus.alten.cacau.model.yellowpage.Engine;
import com.airbus.alten.cacau.model.yellowpage.EngineTypes;
import com.airbus.alten.cacau.model.yellowpage.Model;
import com.airbus.alten.cacau.model.yellowpage.Version;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPIApuTypesResponse;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPIBatchResponse;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPIEngineResponse;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPIModelResponse;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPISeviceAircraftEnginesRequest;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPISeviceAircraftEnginesResponse;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPISeviceAircraftResponse;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPISeviceEngineApusRequest;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPISeviceEngineApusResponse;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPIVersionResponse;
import com.airbus.alten.cacau.repository.envelope.json.YellowPageJSONSeviceParameterResponse;
import com.airbus.alten.cacau.utils.ServiceEnum;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.server.VaadinService;

public class YelloPageJSONFile {

	private static Logger LOGGER = LogManager.getLogger(YelloPageJSONFile.class.getName());

	private String errorID = " ID-YPJSONF ";
	
	public YellowPageAPIBatchResponse getBatches() {

		YellowPageAPIBatchResponse yellowPageAPIBatchResponse = new YellowPageAPIBatchResponse();

		try {

			// Read JSON file
			String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
			InputStream parameterJSON = new FileInputStream(basepath + "/WEB-INF/JSON/Batches.json");
			yellowPageAPIBatchResponse.setSERVICE_API_STATUS(ServiceEnum.OK);
			ObjectMapper mapper = new ObjectMapper();
			Batch batch = mapper.readValue(parameterJSON, Batch.class);
			yellowPageAPIBatchResponse.setMAPPER_STATUS(ServiceEnum.OK);
			yellowPageAPIBatchResponse.setBatch(batch);

		} catch (FileNotFoundException e) {
			LOGGER.error(e.getMessage() + "File Not Found Error" + errorID, e);
			yellowPageAPIBatchResponse.setMessage("File Not Found Error" + errorID);
		}catch (JsonParseException e) {
			LOGGER.error(e.getMessage() + "JSON Parse Error" + errorID, e);
			yellowPageAPIBatchResponse.setMessage("JSON Parse Error" + errorID);
		}catch (JsonMappingException e) {
			LOGGER.error(e.getMessage() + "JSON Mapping Error" + errorID, e);
			yellowPageAPIBatchResponse.setMessage("JSON Mapping Error" + errorID);
		}catch (IOException e) {
			LOGGER.error(e.getMessage() + "IOException error" + errorID, e);
			yellowPageAPIBatchResponse.setMessage("IOException error" + errorID);
		}

		return yellowPageAPIBatchResponse;

	}

	public YellowPageAPIModelResponse getModel() {

		LOGGER.info(YelloPageJSONFile.class.getName() + "\t" + "getModel()" + "\t" + "Start");

		YellowPageAPIModelResponse yellowPageAPIModelResponse = new YellowPageAPIModelResponse();

		try {

			// Read JSON file
			String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();

			InputStream parameterJSON = new FileInputStream(basepath + "/WEB-INF/JSON/ModelTypes.json");
			yellowPageAPIModelResponse.setSERVICE_API_STATUS(ServiceEnum.OK);

			ObjectMapper mapper = new ObjectMapper();

			Model model = new Model();
			model = mapper.readValue(parameterJSON, Model.class);

			yellowPageAPIModelResponse.setModel(model);
			yellowPageAPIModelResponse.setMAPPER_STATUS(ServiceEnum.OK);

		} catch (IOException e) {

			LOGGER.error(e.getMessage(), e);
		}

		LOGGER.info(YelloPageJSONFile.class.getName() + "\t" + "getModel()" + "\t" + "End");

		return yellowPageAPIModelResponse;
	}

	public YellowPageAPIVersionResponse getVersion() {

		LOGGER.info(YelloPageJSONFile.class.getName() + "\t" + "getVersion()" + "\t" + "Start");

		YellowPageAPIVersionResponse yellowPageAPIVersionResponse = new YellowPageAPIVersionResponse();

		try {

			// Read JSON file
			String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();

			InputStream parameterJSON = new FileInputStream(basepath + "/WEB-INF/JSON/VersionTypes.json");
			yellowPageAPIVersionResponse.setSERVICE_API_STATUS(ServiceEnum.OK);

			ObjectMapper mapper = new ObjectMapper();

			Version version = new Version();
			version = mapper.readValue(parameterJSON, Version.class);

			yellowPageAPIVersionResponse.setVersion(version);
			yellowPageAPIVersionResponse.setMAPPER_STATUS(ServiceEnum.OK);

		} catch (IOException e) {

			LOGGER.error(e.getMessage(), e);
		}

		LOGGER.info(YelloPageJSONFile.class.getName() + "\t" + "getVersion()" + "\t" + "End");

		return yellowPageAPIVersionResponse;
	}

	public YellowPageAPIEngineResponse getEngines() {

		LOGGER.info(YelloPageJSONFile.class.getName() + "\t" + "getEngines()" + "\t" + "Start");

		YellowPageAPIEngineResponse yellowPageAPIEngineResponse = new YellowPageAPIEngineResponse();

		try {

			// Read JSON file
			String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();

			InputStream parameterJSON = new FileInputStream(basepath + "/WEB-INF/JSON/EngineTypes.json");
			yellowPageAPIEngineResponse.setSERVICE_API_STATUS(ServiceEnum.OK);

			ObjectMapper mapper = new ObjectMapper();

			EngineTypes engine = new EngineTypes();
			engine = mapper.readValue(parameterJSON, EngineTypes.class);

			yellowPageAPIEngineResponse.setEngine(engine);
			yellowPageAPIEngineResponse.setMAPPER_STATUS(ServiceEnum.OK);

		} catch (IOException e) {

			LOGGER.error(e.getMessage(), e);
		}

		LOGGER.info(YelloPageJSONFile.class.getName() + "\t" + "getEngines()" + "\t" + "End");

		return yellowPageAPIEngineResponse;
	}

	public YellowPageAPIApuTypesResponse getApuTypes() {

		LOGGER.info(YelloPageJSONFile.class.getName() + "\t" + "getApuTypes()" + "\t" + "Start");

		YellowPageAPIApuTypesResponse yellowPageAPIApuTypesResponse = new YellowPageAPIApuTypesResponse();

		try {

			// Read JSON file
			String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();

			InputStream parameterJSON = new FileInputStream(basepath + "/WEB-INF/JSON/ApuTypes.json");
			yellowPageAPIApuTypesResponse.setSERVICE_API_STATUS(ServiceEnum.OK);

			ObjectMapper mapper = new ObjectMapper();

			ApuTypes apu = new ApuTypes();
			apu = mapper.readValue(parameterJSON, ApuTypes.class);

			yellowPageAPIApuTypesResponse.setApu(apu);
			yellowPageAPIApuTypesResponse.setMAPPER_STATUS(ServiceEnum.OK);

		} catch (IOException e) {

			LOGGER.error(e.getMessage(), e);
		}

		LOGGER.info(YelloPageJSONFile.class.getName() + "\t" + "getApuTypes()" + "\t" + "End");

		return yellowPageAPIApuTypesResponse;
	}

	// OLD
	// SERVICES----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public YellowPageAPISeviceAircraftResponse getAircrafts() {

		LOGGER.info(YelloPageJSONFile.class.getName() + "\t" + "getAircrafts()" + "\t" + "Start");
		YellowPageAPISeviceAircraftResponse yellowPageAPISeviceAircraftResponse = new YellowPageAPISeviceAircraftResponse();

		try {

			// Read JSON file
			String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();

			InputStream parameterJSON = new FileInputStream(basepath + "/WEB-INF/JSON/getAircrafts.json");
			yellowPageAPISeviceAircraftResponse.setSERVICE_API_STATUS(ServiceEnum.OK);

			ObjectMapper mapper = new ObjectMapper();

			APIYellowPageAircraftsResponse apiYellowPageAircraftsResponse = new APIYellowPageAircraftsResponse();
			apiYellowPageAircraftsResponse = mapper.readValue(parameterJSON, APIYellowPageAircraftsResponse.class);

			yellowPageAPISeviceAircraftResponse.setAPIYellowPageAircraftsResponse(apiYellowPageAircraftsResponse);
			yellowPageAPISeviceAircraftResponse.setMAPPER_STATUS(ServiceEnum.OK);

		} catch (IOException e) {

			LOGGER.error(e.getMessage(), e);
		}

		LOGGER.info(YelloPageJSONFile.class.getName() + "\t" + "getAircrafts()" + "\t" + "End");
		return yellowPageAPISeviceAircraftResponse;

	}

	public YellowPageAPISeviceAircraftEnginesResponse getEnginesFromAircraft(
			YellowPageAPISeviceAircraftEnginesRequest request) {

		LOGGER.info(YelloPageJSONFile.class.getName() + "\t" + "getEnginesFromAircraft()" + "\t" + "Start");
		YellowPageAPISeviceAircraftEnginesResponse yellowPageAPISeviceAircraftEnginesResponse = new YellowPageAPISeviceAircraftEnginesResponse();

		try {

			// Read JSON file
			String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();

			InputStream parameterJSON = new FileInputStream(basepath + "/WEB-INF/JSON/getEnginesFromAircraft.json");

			if ("A320NEO".equals(request.getAircraft())) {
				parameterJSON = new FileInputStream(basepath + "/WEB-INF/JSON/getEnginesFromVersionNEO.json");
			} else if ("A320CEO".equals(request.getAircraft())) {
				parameterJSON = new FileInputStream(basepath + "/WEB-INF/JSON/getEnginesFromVersionCEO.json");
			}

			yellowPageAPISeviceAircraftEnginesResponse.setSERVICE_API_STATUS(ServiceEnum.OK);

			ObjectMapper mapper = new ObjectMapper();

			APIYellowPagesEnginesResponse apiYellowPagesEnginesResponse = new APIYellowPagesEnginesResponse();
			apiYellowPagesEnginesResponse = mapper.readValue(parameterJSON, APIYellowPagesEnginesResponse.class);

			yellowPageAPISeviceAircraftEnginesResponse.setApiYellowPagesEnginesResponse(apiYellowPagesEnginesResponse);
			yellowPageAPISeviceAircraftEnginesResponse.setMAPPER_STATUS(ServiceEnum.OK);

		} catch (IOException e) {

			LOGGER.error(e.getMessage(), e);
		}

		LOGGER.info(YelloPageJSONFile.class.getName() + "\t" + "getEnginesFromAircraft()" + "\t" + "End");
		return yellowPageAPISeviceAircraftEnginesResponse;

	}

	public YellowPageAPISeviceEngineApusResponse getApusFromEngine(YellowPageAPISeviceEngineApusRequest request) {

		LOGGER.info(YelloPageJSONFile.class.getName() + "\t" + "getApusFromEngine()" + "\t" + "Start");
		YellowPageAPISeviceEngineApusResponse yellowPageAPISeviceEngineApusResponse = new YellowPageAPISeviceEngineApusResponse();

		try {

			// Read JSON file
			String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();

			InputStream parameterJSON = new FileInputStream(basepath + "/WEB-INF/JSON/getAPUsFromAircraft.json");

			if ("CEO".equals(request.getEngine())) {
				parameterJSON = new FileInputStream(basepath + "/WEB-INF/JSON/getAPUsFromVersionCEO.json");
			} else if ("NEO".equals(request.getEngine())) {
				parameterJSON = new FileInputStream(basepath + "/WEB-INF/JSON/getAPUsFromVersionNEO.json");
			} else if ("PW".equals(request.getEngine())) {
				parameterJSON = new FileInputStream(basepath + "/WEB-INF/JSON/getAPUsFromEnginePW.json");
			} else if ("IAE".equals(request.getEngine())) {
				parameterJSON = new FileInputStream(basepath + "/WEB-INF/JSON/getAPUsFromEngineIAE.json");
			} else if ("RR".equals(request.getEngine())) {
				parameterJSON = new FileInputStream(basepath + "/WEB-INF/JSON/getAPUsFromEngineRR.json");
			} else if ("CFM".equals(request.getEngine())) {
				parameterJSON = new FileInputStream(basepath + "/WEB-INF/JSON/getAPUsFromEngineCFM.json");
			}

			yellowPageAPISeviceEngineApusResponse.setSERVICE_API_STATUS(ServiceEnum.OK);

			ObjectMapper mapper = new ObjectMapper();

			APIYellowPagesApusResponse apiYellowPagesApusResponse = new APIYellowPagesApusResponse();
			apiYellowPagesApusResponse = mapper.readValue(parameterJSON, APIYellowPagesApusResponse.class);

			yellowPageAPISeviceEngineApusResponse.setaPIYellowPagesApusResponse(apiYellowPagesApusResponse);
			yellowPageAPISeviceEngineApusResponse.setMAPPER_STATUS(ServiceEnum.OK);

		} catch (IOException e) {

			LOGGER.error(e.getMessage(), e);
		}

		LOGGER.info(YelloPageJSONFile.class.getName() + "\t" + "getApusFromEngine()" + "\t" + "End");
		return yellowPageAPISeviceEngineApusResponse;

	}

	public YellowPageJSONSeviceParameterResponse getParameters() {

		LOGGER.info(YelloPageJSONFile.class.getName() + "\t" + "getParameters()" + "\t" + "Start");
		YellowPageJSONSeviceParameterResponse yellowPageJSONSeviceParameterResponse = new YellowPageJSONSeviceParameterResponse();

		try {

			// Read JSON file
			String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();

			InputStream parameterJSON = new FileInputStream(
					basepath + "/WEB-INF/JSON/getParameters_shorter_20PARAM.json");
			yellowPageJSONSeviceParameterResponse.setSERVICE_API_STATUS(ServiceEnum.OK);

			ObjectMapper mapper = new ObjectMapper();

			JSONYellowPageParameterResponse jsonParameterStructure = new JSONYellowPageParameterResponse();
			jsonParameterStructure = mapper.readValue(parameterJSON, JSONYellowPageParameterResponse.class);

			yellowPageJSONSeviceParameterResponse.setJSONYellowPageAParametersResponse(jsonParameterStructure);
			yellowPageJSONSeviceParameterResponse.setMAPPER_STATUS(ServiceEnum.OK);

		} catch (IOException e) {

			LOGGER.error(e.getMessage(), e);
		}

		LOGGER.info(YelloPageJSONFile.class.getName() + "\t" + "getParameters()" + "\t" + "End");

		return yellowPageJSONSeviceParameterResponse;

	}
}
