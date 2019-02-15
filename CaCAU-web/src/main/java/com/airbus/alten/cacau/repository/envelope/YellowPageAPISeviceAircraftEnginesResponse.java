package com.airbus.alten.cacau.repository.envelope;

import com.airbus.alten.cacau.model.yellowpage.APIYellowPagesEnginesResponse;

public class YellowPageAPISeviceAircraftEnginesResponse extends YellowPageAPISeviceResponse{

	private APIYellowPagesEnginesResponse apiYellowPagesEnginesResponse;

	public APIYellowPagesEnginesResponse getApiYellowPagesEnginesResponse() {
		return apiYellowPagesEnginesResponse;
	}

	public void setApiYellowPagesEnginesResponse(APIYellowPagesEnginesResponse apiYellowPagesEnginesResponse) {
		this.apiYellowPagesEnginesResponse = apiYellowPagesEnginesResponse;
	}

}
