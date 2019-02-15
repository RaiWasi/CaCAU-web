package com.airbus.alten.cacau.repository.envelope;

import com.airbus.alten.cacau.model.yellowpage.APIYellowPagesEquipmentReponse;

public class YellowPageAPIServiceEquipmentResponse extends YellowPageAPISeviceResponse{
	
	private String equipmentJSON;
	
	private APIYellowPagesEquipmentReponse aPIYellowPagesEquipmentReponse;

	public String getEquipmentJSON() {
		return equipmentJSON;
	}

	public void setEquipmentJSON(String equipmentJSON) {
		this.equipmentJSON = equipmentJSON;
	}

	public APIYellowPagesEquipmentReponse getaPIYellowPagesEquipmentReponse() {
		return aPIYellowPagesEquipmentReponse;
	}

	public void setaPIYellowPagesEquipmentReponse(APIYellowPagesEquipmentReponse aPIYellowPagesEquipmentReponse) {
		this.aPIYellowPagesEquipmentReponse = aPIYellowPagesEquipmentReponse;
	}
	
	

}
