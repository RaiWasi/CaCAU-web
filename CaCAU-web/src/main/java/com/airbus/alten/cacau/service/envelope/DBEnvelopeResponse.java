package com.airbus.alten.cacau.service.envelope;

import com.airbus.alten.cacau.utils.ServiceEnum;

public class DBEnvelopeResponse {

	private ServiceEnum DB_SAVE_STATUS = ServiceEnum.KO;
	private String message = "";
	
	public ServiceEnum getDB_SAVE_STATUS() {
		return DB_SAVE_STATUS;
	}
	public void setDB_SAVE_STATUS(ServiceEnum dB_SAVE_STATUS) {
		DB_SAVE_STATUS = dB_SAVE_STATUS;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
