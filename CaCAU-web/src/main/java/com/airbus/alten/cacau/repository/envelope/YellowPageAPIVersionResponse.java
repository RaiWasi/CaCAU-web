package com.airbus.alten.cacau.repository.envelope;

import com.airbus.alten.cacau.model.yellowpage.Version;

public class YellowPageAPIVersionResponse extends YellowPageAPISeviceResponse {
	
	private Version version;

	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}
}
