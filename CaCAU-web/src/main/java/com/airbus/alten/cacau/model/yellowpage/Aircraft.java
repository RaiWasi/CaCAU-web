package com.airbus.alten.cacau.model.yellowpage;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "AircraftName", "Aircraftid" })
public class Aircraft {

	@JsonProperty("AircraftName")
	private String aircraftName;
	@JsonProperty("Aircraftid")
	private Integer aircraftid;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("AircraftName")
	public String getAircraftName() {
		return aircraftName;
	}

	@JsonProperty("AircraftName")
	public void setAircraftName(String aircraftName) {
		this.aircraftName = aircraftName;
	}

	@JsonProperty("Aircraftid")
	public Integer getAircraftid() {
		return aircraftid;
	}

	@JsonProperty("Aircraftid")
	public void setAircraftid(Integer aircraftid) {
		this.aircraftid = aircraftid;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
