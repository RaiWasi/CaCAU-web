package com.airbus.alten.cacau.model.yellowpage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"Data",
"Status",
"Message",
"YPDatabaseVersion",
"YPDataServiceVersion",
"ResponseDateTime",
"Command",
"Source",
"DataCount",
"Arguments"
})

public class EngineTypes {

	@JsonProperty("Data")
	private List<String> data = null;
	@JsonProperty("Status")
	private Integer status;
	@JsonProperty("Message")
	private String message;
	@JsonProperty("YPDatabaseVersion")
	private String yPDatabaseVersion;
	@JsonProperty("YPDataServiceVersion")
	private String yPDataServiceVersion;
	@JsonProperty("ResponseDateTime")
	private String responseDateTime;
	@JsonProperty("Command")
	private String command;
	@JsonProperty("Source")
	private String source;
	@JsonProperty("DataCount")
	private Integer dataCount;
	@JsonProperty("Arguments")
	private EngineArguments arguments;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("Data")
	public List<String> getData() {
	return data;
	}

	@JsonProperty("Data")
	public void setData(List<String> data) {
	this.data = data;
	}

	@JsonProperty("Status")
	public Integer getStatus() {
	return status;
	}

	@JsonProperty("Status")
	public void setStatus(Integer status) {
	this.status = status;
	}

	@JsonProperty("Message")
	public String getMessage() {
	return message;
	}

	@JsonProperty("Message")
	public void setMessage(String message) {
	this.message = message;
	}

	@JsonProperty("YPDatabaseVersion")
	public String getYPDatabaseVersion() {
	return yPDatabaseVersion;
	}

	@JsonProperty("YPDatabaseVersion")
	public void setYPDatabaseVersion(String yPDatabaseVersion) {
	this.yPDatabaseVersion = yPDatabaseVersion;
	}

	@JsonProperty("YPDataServiceVersion")
	public String getYPDataServiceVersion() {
	return yPDataServiceVersion;
	}

	@JsonProperty("YPDataServiceVersion")
	public void setYPDataServiceVersion(String yPDataServiceVersion) {
	this.yPDataServiceVersion = yPDataServiceVersion;
	}

	@JsonProperty("ResponseDateTime")
	public String getResponseDateTime() {
	return responseDateTime;
	}

	@JsonProperty("ResponseDateTime")
	public void setResponseDateTime(String responseDateTime) {
	this.responseDateTime = responseDateTime;
	}

	@JsonProperty("Command")
	public String getCommand() {
	return command;
	}

	@JsonProperty("Command")
	public void setCommand(String command) {
	this.command = command;
	}

	@JsonProperty("Source")
	public String getSource() {
	return source;
	}

	@JsonProperty("Source")
	public void setSource(String source) {
	this.source = source;
	}

	@JsonProperty("DataCount")
	public Integer getDataCount() {
	return dataCount;
	}

	@JsonProperty("DataCount")
	public void setDataCount(Integer dataCount) {
	this.dataCount = dataCount;
	}

	@JsonProperty("Arguments")
	public EngineArguments getArguments() {
	return arguments;
	}

	@JsonProperty("Arguments")
	public void setArguments(EngineArguments arguments) {
	this.arguments = arguments;
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
