package com.airbus.alten.cacau.repository.envelope;

import com.airbus.alten.cacau.model.yellowpage.ApuTypes;

public class YellowPageAPIApuTypesResponse extends YellowPageAPISeviceResponse {

	private ApuTypes apu;

	public ApuTypes getApu() {
		return apu;
	}

	public void setApu(ApuTypes apu) {
		this.apu = apu;
	}
}
