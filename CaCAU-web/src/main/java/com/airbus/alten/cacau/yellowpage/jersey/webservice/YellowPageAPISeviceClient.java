package com.airbus.alten.cacau.yellowpage.jersey.webservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.airbus.alten.cacau.model.json.JSONYellowPageParameterResponse;
import com.airbus.alten.cacau.model.json.Parameter;
import com.airbus.alten.cacau.model.yellowpage.APIYellowPageAircraftsResponse;
import com.airbus.alten.cacau.model.yellowpage.APIYellowPageParameterByICDResponse;
import com.airbus.alten.cacau.model.yellowpage.APIYellowPagesApusResponse;
import com.airbus.alten.cacau.model.yellowpage.APIYellowPagesEnginesResponse;
import com.airbus.alten.cacau.model.yellowpage.APIYellowPagesEquipmentReponse;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPIServiceEquipmentResponse;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPIServiceParameterByICDResponse;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPISeviceAircraftResponse;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPISeviceEngineApusResponse;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPISeviceAircraftEnginesRequest;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPISeviceAircraftEnginesResponse;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPISeviceResponse;
import com.airbus.alten.cacau.repository.envelope.json.YellowPageJSONSeviceParameterResponse;
import com.airbus.alten.cacau.security.NtlmFeature;
import com.airbus.alten.cacau.utils.ServiceEnum;
import com.airbus.alten.cacau.utils.YellowPageAPILink;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class YellowPageAPISeviceClient extends NtlmFeature {


	public YellowPageAPISeviceAircraftResponse getAircrafts(){

		YellowPageAPISeviceAircraftResponse yellowPageAPISeviceAircraftResponse = new YellowPageAPISeviceAircraftResponse();
		String aircraftsJSON = ""; 

		yellowPageAPISeviceAircraftResponse.setSERVICE_API_STATUS(ServiceEnum.KO);
		yellowPageAPISeviceAircraftResponse.setMAPPER_STATUS(ServiceEnum.KO);

		try {
			aircraftsJSON = getAuthenticatedResponse(YellowPageAPILink.URL_GET_AIRCRAFTS);
			yellowPageAPISeviceAircraftResponse.setSERVICE_API_STATUS(ServiceEnum.OK);
		} catch (IOException e) {

			e.printStackTrace();
		}

		if(ServiceEnum.OK.equals(yellowPageAPISeviceAircraftResponse.getSERVICE_API_STATUS())){

			ObjectMapper mapper = new ObjectMapper();
			APIYellowPageAircraftsResponse yellowPageAircraftResponse = new APIYellowPageAircraftsResponse();

			try {

				yellowPageAircraftResponse = mapper.readValue(aircraftsJSON, APIYellowPageAircraftsResponse.class);
				yellowPageAPISeviceAircraftResponse.setAPIYellowPageAircraftsResponse(yellowPageAircraftResponse);
				yellowPageAPISeviceAircraftResponse.setMAPPER_STATUS(ServiceEnum.OK);

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return yellowPageAPISeviceAircraftResponse;

	}


	public YellowPageAPISeviceAircraftEnginesResponse getAircraftEngines(YellowPageAPISeviceAircraftEnginesRequest yellowPageAPISeviceEngineRequest){

		YellowPageAPISeviceAircraftEnginesResponse yellowPageAPISeviceEngineResponse = new YellowPageAPISeviceAircraftEnginesResponse();
		String enginesJSON = "";

		if(yellowPageAPISeviceEngineRequest.getAircraft() !=null){

			yellowPageAPISeviceEngineResponse.setSERVICE_API_STATUS(ServiceEnum.KO);
			yellowPageAPISeviceEngineResponse.setMAPPER_STATUS(ServiceEnum.KO);

			try {
				enginesJSON = getAuthenticatedResponse(YellowPageAPILink.URL_GET_AIRCRAFTS_ENGINES + yellowPageAPISeviceEngineRequest.getAircraft() + YellowPageAPILink.URL_ENGINES);
				yellowPageAPISeviceEngineResponse.setSERVICE_API_STATUS(ServiceEnum.OK);
//				yellowPageAPISeviceEngineResponse.setEnginesJSON(enginesJSON);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return yellowPageAPISeviceEngineResponse;

	}

	public YellowPageAPISeviceAircraftEnginesResponse getEngines(){

		YellowPageAPISeviceAircraftEnginesResponse yellowPageAPISeviceEngineResponse = new YellowPageAPISeviceAircraftEnginesResponse();
		String aircraftsJSON = ""; 

		yellowPageAPISeviceEngineResponse.setSERVICE_API_STATUS(ServiceEnum.KO);
		yellowPageAPISeviceEngineResponse.setMAPPER_STATUS(ServiceEnum.KO);

		try {
			aircraftsJSON = getAuthenticatedResponse(YellowPageAPILink.URL_GET_ENGINES);
			yellowPageAPISeviceEngineResponse.setSERVICE_API_STATUS(ServiceEnum.OK);
		} catch (IOException e) {

			e.printStackTrace();
		}

		if(ServiceEnum.OK.equals(yellowPageAPISeviceEngineResponse.getSERVICE_API_STATUS())){

			ObjectMapper mapper = new ObjectMapper();
			APIYellowPagesEnginesResponse yellowPageEnginesResponse = new APIYellowPagesEnginesResponse();

			try {

				yellowPageEnginesResponse = mapper.readValue(aircraftsJSON, APIYellowPagesEnginesResponse.class);
				yellowPageAPISeviceEngineResponse.setApiYellowPagesEnginesResponse(yellowPageEnginesResponse);
				yellowPageAPISeviceEngineResponse.setMAPPER_STATUS(ServiceEnum.OK);

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return yellowPageAPISeviceEngineResponse;

	}

	//new method - for svc - Equipment - 03.08 
	public YellowPageAPIServiceEquipmentResponse getEquiments(){

		YellowPageAPIServiceEquipmentResponse yellowPageAPISeviceEquipmentResponse = new YellowPageAPIServiceEquipmentResponse();
		String equipmentJSON = ""; 

		//DO NOT FORGET TO EXTEND THE SERVICE 
		//(YellowPageAPIServiceEquipmentResponse extends YellowPageAPISeviceResponse) - 06.08 
		yellowPageAPISeviceEquipmentResponse.setSERVICE_API_STATUS(ServiceEnum.KO);
		yellowPageAPISeviceEquipmentResponse.setMAPPER_STATUS(ServiceEnum.KO);

		try {
			equipmentJSON = getAuthenticatedResponse(YellowPageAPILink.URL_GET_EQUIPMENTS);
			yellowPageAPISeviceEquipmentResponse.setSERVICE_API_STATUS(ServiceEnum.OK);
		} catch (IOException e) {

			e.printStackTrace();
		}

		if(ServiceEnum.OK.equals(yellowPageAPISeviceEquipmentResponse.getSERVICE_API_STATUS())){

			ObjectMapper mapper = new ObjectMapper();
			APIYellowPagesEquipmentReponse yellowPageEquipmentResponse = new APIYellowPagesEquipmentReponse();

			try {

				yellowPageEquipmentResponse = mapper.readValue(equipmentJSON, APIYellowPagesEquipmentReponse.class);
				yellowPageAPISeviceEquipmentResponse.setaPIYellowPagesEquipmentReponse(yellowPageEquipmentResponse);
				yellowPageAPISeviceEquipmentResponse.setMAPPER_STATUS(ServiceEnum.OK);

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return yellowPageAPISeviceEquipmentResponse;

	}

	//new method - for svc - Param by ICD - 07.08 
	public YellowPageAPIServiceParameterByICDResponse getParameterByICD(){

		YellowPageAPIServiceParameterByICDResponse yellowPageAPIServiceParameterByICDResponse = new YellowPageAPIServiceParameterByICDResponse();
		String parameterByICDJSON = ""; 

		//DO NOT FORGET TO EXTEND THE SERVICE 
		//(YellowPageAPIServiceParameterByICDResponse extends YellowPageAPISeviceResponse) - 06.08 
		yellowPageAPIServiceParameterByICDResponse.setSERVICE_API_STATUS(ServiceEnum.KO);
		yellowPageAPIServiceParameterByICDResponse.setMAPPER_STATUS(ServiceEnum.KO);

		try {
			parameterByICDJSON = getAuthenticatedResponse(YellowPageAPILink.URL_GET_ICDS);
			yellowPageAPIServiceParameterByICDResponse.setSERVICE_API_STATUS(ServiceEnum.OK);
		} catch (IOException e) {

			e.printStackTrace();
		}

		if(ServiceEnum.OK.equals(yellowPageAPIServiceParameterByICDResponse.getSERVICE_API_STATUS())){

			ObjectMapper mapper = new ObjectMapper();
			APIYellowPageParameterByICDResponse yellowPageParameterByICDResponse = new APIYellowPageParameterByICDResponse();

			try {

				yellowPageParameterByICDResponse = mapper.readValue(parameterByICDJSON, APIYellowPageParameterByICDResponse.class);
				yellowPageAPIServiceParameterByICDResponse.setaPIYellowPageParameterByICDResponse(yellowPageParameterByICDResponse);
				yellowPageAPIServiceParameterByICDResponse.setMAPPER_STATUS(ServiceEnum.OK);

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return yellowPageAPIServiceParameterByICDResponse;

	}

	//new method - APU - 28.09 
	public YellowPageAPISeviceEngineApusResponse getApus(){

		YellowPageAPISeviceEngineApusResponse yellowPageAPIServiceApuResponse = new YellowPageAPISeviceEngineApusResponse();
		String apuJSON = ""; 

		yellowPageAPIServiceApuResponse.setSERVICE_API_STATUS(ServiceEnum.KO);
		yellowPageAPIServiceApuResponse.setMAPPER_STATUS(ServiceEnum.KO);

		try {
			apuJSON = getAuthenticatedResponse(YellowPageAPILink.URL_GET_APUS);
			yellowPageAPIServiceApuResponse.setSERVICE_API_STATUS(ServiceEnum.OK);
		} catch (IOException e) {

			e.printStackTrace();
		}

		if(ServiceEnum.OK.equals(yellowPageAPIServiceApuResponse.getSERVICE_API_STATUS())){

			ObjectMapper mapper = new ObjectMapper();
			APIYellowPagesApusResponse yellowPageApuResponse = new APIYellowPagesApusResponse();

			try {

				yellowPageApuResponse = mapper.readValue(apuJSON, APIYellowPagesApusResponse.class);
				yellowPageAPIServiceApuResponse.setaPIYellowPagesApusResponse(yellowPageApuResponse);
				yellowPageAPIServiceApuResponse.setMAPPER_STATUS(ServiceEnum.OK);

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return yellowPageAPIServiceApuResponse;

	}

}
