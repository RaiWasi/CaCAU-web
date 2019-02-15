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
@JsonPropertyOrder({
	"APUName",
	"APUid"
})
public class Apu {

	@JsonProperty("APUName")
	private String aPUName;
	@JsonProperty("APUid")
	private Integer aPUid;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("APUName")
	public String getAPUName() {
		return aPUName;
	}

	@JsonProperty("APUName")
	public void setAPUName(String aPUName) {
		this.aPUName = aPUName;
	}

	@JsonProperty("APUid")
	public Integer getAPUid() {
		return aPUid;
	}

	@JsonProperty("APUid")
	public void setAPUid(Integer aPUid) {
		this.aPUid = aPUid;
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
