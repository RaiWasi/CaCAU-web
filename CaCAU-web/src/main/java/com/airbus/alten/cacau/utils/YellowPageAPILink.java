package com.airbus.alten.cacau.utils;

import java.io.FileReader;
import java.util.ArrayList;

import com.vaadin.server.VaadinService;

public class YellowPageAPILink {

	public static final String URL_GET_AIRCRAFTS = "http://de0-vsiaas-1345.eu.airbus.corp/acmsdatasrv/ACMSEquipmentService.svc/v1/Aircrafts";

	public static final String URL_GET_AIRCRAFTS_ENGINES = "http://de0-vsiaas-1345.eu.airbus.corp/acmsdatasrv/ACMSEquipmentService.svc/v1/Aircrafts/";

	public static final String URL_ENGINES = "/Engines";

	public static final String URL_GET_ENGINES = "http://de0-vsiaas-1345.eu.airbus.corp/acmsdatasrv/ACMSEquipmentService.svc/v1/Engines";

	public static final String URL_GET_EQUIPMENTS = "http://de0-vsiaas-1345.eu.airbus.corp/acmsdatasrv/ACMSICDStandardsService.svc/v1/Equipments"; //started 03.08

	public static final String URL_GET_ICDS = "http://de0-vsiaas-1345.eu.airbus.corp/acmsdatasrv/ACMSParameterService.svc/v1/ICDStandards/382/Parameters?=nulll"; // an example ICD - started 07.08

	public static final String URL_GET_APUS = "http://de0-vsiaas-1345.eu.airbus.corp/acmsdatasrv/ACMSEquipmentService.svc/v1/APUS"; //new combobox in view ChooseProgram

	//public static final String URL_GET_PARAMETERS = "C:\\Users\\Public\\DevSoftware\\eclipse-workspace\\Airbus.CaCAU\\CaCAU-web\\src\\main\\webapp\\WEB-INF\\JSON\\getParameters.json"; //Since API isn't working, reads the Parameters.json locally

}
