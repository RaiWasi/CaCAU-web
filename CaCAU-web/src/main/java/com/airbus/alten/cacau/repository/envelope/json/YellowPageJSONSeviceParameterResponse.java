package com.airbus.alten.cacau.repository.envelope.json;

import com.airbus.alten.cacau.model.json.JSONYellowPageParameterResponse;
import com.airbus.alten.cacau.repository.envelope.YellowPageAPISeviceResponse;

public class YellowPageJSONSeviceParameterResponse extends YellowPageAPISeviceResponse{

	private JSONYellowPageParameterResponse JSONYellowPageParameterResponse;

	public JSONYellowPageParameterResponse getJSONYellowPageParameterResponse() {
		return JSONYellowPageParameterResponse;
	}

	public void setJSONYellowPageAParametersResponse(JSONYellowPageParameterResponse jSONYellowPageParameterResponse) {
		JSONYellowPageParameterResponse = jSONYellowPageParameterResponse;
	}

}
