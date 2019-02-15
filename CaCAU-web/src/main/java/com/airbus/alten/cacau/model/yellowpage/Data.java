package com.airbus.alten.cacau.model.yellowpage;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "BatchNumber", "BatchId", "BatchOpenDateTime", "BatchReOpenDateTime", "BatchCloseDateTime",
		"BatchFrozenDateTime", "BatchStatus", "NewBatchNumber" })

public class Data {

	@JsonProperty("BatchNumber")
	private String batchNumber;
	@JsonProperty("BatchId")
	private Integer batchId;
	@JsonProperty("BatchOpenDateTime")
	private Calendar batchOpenDateTime;
	@JsonProperty("BatchReOpenDateTime")
	private Calendar batchReOpenDateTime;
	@JsonProperty("BatchCloseDateTime")
	private Calendar batchCloseDateTime;
	@JsonProperty("BatchFrozenDateTime")
	private Calendar batchFrozenDateTime;
	@JsonProperty("BatchStatus")
	private String batchStatus;
	@JsonProperty("NewBatchNumber")
	private String newBatchNumber;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("BatchNumber")
	public String getBatchNumber() {
		return batchNumber;
	}

	@JsonProperty("BatchNumber")
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	@JsonProperty("BatchId")
	public Integer getBatchId() {
		return batchId;
	}

	@JsonProperty("BatchId")
	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	@JsonProperty("BatchOpenDateTime")
	public Calendar getBatchOpenDateTime() {
		return batchOpenDateTime;
	}

	@JsonProperty("BatchOpenDateTime")
	public void setBatchOpenDateTime(Calendar batchOpenDateTime) {
		this.batchOpenDateTime = batchOpenDateTime;
	}

	@JsonProperty("BatchReOpenDateTime")
	public Calendar getBatchReOpenDateTime() {
		return batchReOpenDateTime;
	}

	@JsonProperty("BatchReOpenDateTime")
	public void setBatchReOpenDateTime(Calendar batchReOpenDateTime) {
		this.batchReOpenDateTime = batchReOpenDateTime;
	}

	@JsonProperty("BatchCloseDateTime")
	public Calendar getBatchCloseDateTime() {
		return batchCloseDateTime;
	}

	@JsonProperty("BatchCloseDateTime")
	public void setBatchCloseDateTime(Calendar batchCloseDateTime) {
		this.batchCloseDateTime = batchCloseDateTime;
	}

	@JsonProperty("BatchFrozenDateTime")
	public Calendar getBatchFrozenDateTime() {
		return batchFrozenDateTime;
	}

	@JsonProperty("BatchFrozenDateTime")
	public void setBatchFrozenDateTime(Calendar batchFrozenDateTime) {
		this.batchFrozenDateTime = batchFrozenDateTime;
	}

	@JsonProperty("BatchStatus")
	public String getBatchStatus() {
		return batchStatus;
	}

	@JsonProperty("BatchStatus")
	public void setBatchStatus(String batchStatus) {
		this.batchStatus = batchStatus;
	}

	@JsonProperty("NewBatchNumber")
	public String getNewBatchNumber() {
		return newBatchNumber;
	}

	@JsonProperty("NewBatchNumber")
	public void setNewBatchNumber(String newBatchNumber) {
		this.newBatchNumber = newBatchNumber;
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
