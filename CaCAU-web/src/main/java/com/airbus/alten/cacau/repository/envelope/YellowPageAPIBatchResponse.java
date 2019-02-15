package com.airbus.alten.cacau.repository.envelope;

import com.airbus.alten.cacau.model.yellowpage.Batch;

public class YellowPageAPIBatchResponse extends YellowPageAPISeviceResponse{

	private Batch batch;

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	
}
