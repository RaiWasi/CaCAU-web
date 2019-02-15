package com.airbus.alten.cacau.repository.envelope;

import com.airbus.alten.cacau.model.yellowpage.APIYellowPageAircraftsResponse;

public class YellowPageAPISeviceAircraftResponse extends YellowPageAPISeviceResponse{

	private APIYellowPageAircraftsResponse APIYellowPageAircraftsResponse;

	public APIYellowPageAircraftsResponse getAPIYellowPageAircraftsResponse() {
		return APIYellowPageAircraftsResponse;
	}

	public void setAPIYellowPageAircraftsResponse(APIYellowPageAircraftsResponse aPIYellowPageAircraftsResponse) {
		APIYellowPageAircraftsResponse = aPIYellowPageAircraftsResponse;
	}

}
