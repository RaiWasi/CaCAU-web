package com.airbus.alten.cacau.repository.envelope;

import com.airbus.alten.cacau.model.yellowpage.Model;

public class YellowPageAPIModelResponse extends YellowPageAPISeviceResponse {

	private Model model;

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

}
