package com.airbus.alten.cacau.repository.envelope;

import com.airbus.alten.cacau.model.yellowpage.APIYellowPageParameterByICDResponse;

public class YellowPageAPIServiceParameterByICDResponse extends YellowPageAPISeviceResponse {

	private String parameterByICDJSON;
	
	private APIYellowPageParameterByICDResponse aPIYellowPageParameterByICDResponse;

	public String getParameterByICDJSON() {
		return parameterByICDJSON;
	}

	public void setParameterByICDJSON(String parameterByICDJSON) {
		this.parameterByICDJSON = parameterByICDJSON;
	}

	public APIYellowPageParameterByICDResponse getaPIYellowPageParameterByICDResponse() {
		return aPIYellowPageParameterByICDResponse;
	}

	public void setaPIYellowPageParameterByICDResponse(
			APIYellowPageParameterByICDResponse aPIYellowPageParameterByICDResponse) {
		this.aPIYellowPageParameterByICDResponse = aPIYellowPageParameterByICDResponse;
	}
}
