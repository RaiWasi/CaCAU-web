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
"EngineName",
"Engineid"
})
public class Engine {

@JsonProperty("EngineName")
private String engineName;
@JsonProperty("Engineid")
private Integer engineid;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("EngineName")
public String getEngineName() {
return engineName;
}

@JsonProperty("EngineName")
public void setEngineName(String engineName) {
this.engineName = engineName;
}

@JsonProperty("Engineid")
public Integer getEngineid() {
return engineid;
}

@JsonProperty("Engineid")
public void setEngineid(Integer engineid) {
this.engineid = engineid;
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
