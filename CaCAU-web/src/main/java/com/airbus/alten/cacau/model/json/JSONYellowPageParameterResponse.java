package com.airbus.alten.cacau.model.json;

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
	"Arguments",
	"Command",
	"Data",
	"DataCount",
	"Message",
	"ResponseDateTime",
	"Source",
	"Status",
	"YPDataServiceVersion",
	"YPDatabaseVersion"
})

public class JSONYellowPageParameterResponse {

	@JsonProperty("Arguments")
	private List<Object> arguments = null;
	@JsonProperty("Command")
	private String command;
	@JsonProperty("Data")
	private List<Parameter> data = null;
	@JsonProperty("DataCount")
	private Integer dataCount;
	@JsonProperty("Message")
	private String message;
	@JsonProperty("ResponseDateTime")
	private String responseDateTime;
	@JsonProperty("Source")
	private String source;
	@JsonProperty("Status")
	private Integer status;
	@JsonProperty("YPDataServiceVersion")
	private String yPDataServiceVersion;
	@JsonProperty("YPDatabaseVersion")
	private String yPDatabaseVersion;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("Arguments")
	public List<Object> getArguments() {
		return arguments;
	}

	@JsonProperty("Arguments")
	public void setArguments(List<Object> arguments) {
		this.arguments = arguments;
	}

	@JsonProperty("Command")
	public String getCommand() {
		return command;
	}

	@JsonProperty("Command")
	public void setCommand(String command) {
		this.command = command;
	}

	@JsonProperty("Data")
	public List<Parameter> getData() {
		return data;
	}

	@JsonProperty("Data")
	public void setData(List<Parameter> data) {
		this.data = data;
	}

	@JsonProperty("DataCount")
	public Integer getDataCount() {
		return dataCount;
	}

	@JsonProperty("DataCount")
	public void setDataCount(Integer dataCount) {
		this.dataCount = dataCount;
	}

	@JsonProperty("Message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("Message")
	public void setMessage(String message) {
		this.message = message;
	}

	@JsonProperty("ResponseDateTime")
	public String getResponseDateTime() {
		return responseDateTime;
	}

	@JsonProperty("ResponseDateTime")
	public void setResponseDateTime(String responseDateTime) {
		this.responseDateTime = responseDateTime;
	}

	@JsonProperty("Source")
	public String getSource() {
		return source;
	}

	@JsonProperty("Source")
	public void setSource(String source) {
		this.source = source;
	}

	@JsonProperty("Status")
	public Integer getStatus() {
		return status;
	}

	@JsonProperty("Status")
	public void setStatus(Integer status) {
		this.status = status;
	}

	@JsonProperty("YPDataServiceVersion")
	public String getYPDataServiceVersion() {
		return yPDataServiceVersion;
	}

	@JsonProperty("YPDataServiceVersion")
	public void setYPDataServiceVersion(String yPDataServiceVersion) {
		this.yPDataServiceVersion = yPDataServiceVersion;
	}

	@JsonProperty("YPDatabaseVersion")
	public String getYPDatabaseVersion() {
		return yPDatabaseVersion;
	}

	@JsonProperty("YPDatabaseVersion")
	public void setYPDatabaseVersion(String yPDatabaseVersion) {
		this.yPDatabaseVersion = yPDatabaseVersion;
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