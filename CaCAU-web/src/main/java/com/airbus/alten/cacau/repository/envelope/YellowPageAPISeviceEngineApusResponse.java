package com.airbus.alten.cacau.repository.envelope;

import com.airbus.alten.cacau.model.yellowpage.APIYellowPagesApusResponse;

public class YellowPageAPISeviceEngineApusResponse extends YellowPageAPISeviceResponse{

	private APIYellowPagesApusResponse aPIYellowPagesApusResponse;

	public APIYellowPagesApusResponse getaPIYellowPagesApusResponse() {
		return aPIYellowPagesApusResponse;
	}

	public void setaPIYellowPagesApusResponse(APIYellowPagesApusResponse aPIYellowPagesApusResponse) {
		this.aPIYellowPagesApusResponse = aPIYellowPagesApusResponse;
	}		
}
