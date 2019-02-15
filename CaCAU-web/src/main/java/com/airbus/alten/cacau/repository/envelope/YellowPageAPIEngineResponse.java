package com.airbus.alten.cacau.repository.envelope;

import com.airbus.alten.cacau.model.yellowpage.EngineTypes;

public class YellowPageAPIEngineResponse extends YellowPageAPISeviceResponse {

	private EngineTypes engine;

	public EngineTypes getEngine() {
		return engine;
	}

	public void setEngine(EngineTypes engine) {
		this.engine = engine;
	}
	
}
