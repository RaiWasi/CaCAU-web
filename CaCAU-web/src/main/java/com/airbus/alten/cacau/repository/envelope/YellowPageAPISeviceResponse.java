package com.airbus.alten.cacau.repository.envelope;

import com.airbus.alten.cacau.utils.ServiceEnum;

public class YellowPageAPISeviceResponse{

	private ServiceEnum SERVICE_API_STATUS = ServiceEnum.KO;
	private ServiceEnum MAPPER_STATUS = ServiceEnum.KO;
	private String message = "";
	
	public ServiceEnum getSERVICE_API_STATUS() {
		return SERVICE_API_STATUS;
	}
	public void setSERVICE_API_STATUS(ServiceEnum sERVICE_API_STATUS) {
		SERVICE_API_STATUS = sERVICE_API_STATUS;
	}
	public ServiceEnum getMAPPER_STATUS() {
		return MAPPER_STATUS;
	}
	public void setMAPPER_STATUS(ServiceEnum mAPPER_STATUS) {
		MAPPER_STATUS = mAPPER_STATUS;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
