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
	"EquipmentATA",
	"EquipmentCode",
	"EquipmentDescription",
	"EquipmentDesignation",
	"EquipmentFIN",
	"EquipmentLoadable",
	"EquipmentName",
	"EquipmentNote",
	"EquipmentOption",
	"EquipmentSupplier",
	"EquipmentSystem",
	"EquipmentType",
	"Equipmentid"
})
public class Equipment {

	@JsonProperty("EquipmentATA")
	private String equipmentATA;
	@JsonProperty("EquipmentCode")
	private String equipmentCode;
	@JsonProperty("EquipmentDescription")
	private Object equipmentDescription;
	@JsonProperty("EquipmentDesignation")
	private Object equipmentDesignation;
	@JsonProperty("EquipmentFIN")
	private String equipmentFIN;
	@JsonProperty("EquipmentLoadable")
	private String equipmentLoadable;
	@JsonProperty("EquipmentName")
	private String equipmentName;
	@JsonProperty("EquipmentNote")
	private Object equipmentNote;
	@JsonProperty("EquipmentOption")
	private String equipmentOption;
	@JsonProperty("EquipmentSupplier")
	private Object equipmentSupplier;
	@JsonProperty("EquipmentSystem")
	private String equipmentSystem;
	@JsonProperty("EquipmentType")
	private Object equipmentType;
	@JsonProperty("Equipmentid")
	private Integer equipmentid;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("EquipmentATA")
	public String getEquipmentATA() {
		return equipmentATA;
	}

	@JsonProperty("EquipmentATA")
	public void setEquipmentATA(String equipmentATA) {
		this.equipmentATA = equipmentATA;
	}

	@JsonProperty("EquipmentCode")
	public String getEquipmentCode() {
		return equipmentCode;
	}

	@JsonProperty("EquipmentCode")
	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}

	@JsonProperty("EquipmentDescription")
	public Object getEquipmentDescription() {
		return equipmentDescription;
	}

	@JsonProperty("EquipmentDescription")
	public void setEquipmentDescription(Object equipmentDescription) {
		this.equipmentDescription = equipmentDescription;
	}

	@JsonProperty("EquipmentDesignation")
	public Object getEquipmentDesignation() {
		return equipmentDesignation;
	}

	@JsonProperty("EquipmentDesignation")
	public void setEquipmentDesignation(Object equipmentDesignation) {
		this.equipmentDesignation = equipmentDesignation;
	}

	@JsonProperty("EquipmentFIN")
	public String getEquipmentFIN() {
		return equipmentFIN;
	}

	@JsonProperty("EquipmentFIN")
	public void setEquipmentFIN(String equipmentFIN) {
		this.equipmentFIN = equipmentFIN;
	}

	@JsonProperty("EquipmentLoadable")
	public String getEquipmentLoadable() {
		return equipmentLoadable;
	}

	@JsonProperty("EquipmentLoadable")
	public void setEquipmentLoadable(String equipmentLoadable) {
		this.equipmentLoadable = equipmentLoadable;
	}

	@JsonProperty("EquipmentName")
	public String getEquipmentName() {
		return equipmentName;
	}

	@JsonProperty("EquipmentName")
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	@JsonProperty("EquipmentNote")
	public Object getEquipmentNote() {
		return equipmentNote;
	}

	@JsonProperty("EquipmentNote")
	public void setEquipmentNote(Object equipmentNote) {
		this.equipmentNote = equipmentNote;
	}

	@JsonProperty("EquipmentOption")
	public String getEquipmentOption() {
		return equipmentOption;
	}

	@JsonProperty("EquipmentOption")
	public void setEquipmentOption(String equipmentOption) {
		this.equipmentOption = equipmentOption;
	}

	@JsonProperty("EquipmentSupplier")
	public Object getEquipmentSupplier() {
		return equipmentSupplier;
	}

	@JsonProperty("EquipmentSupplier")
	public void setEquipmentSupplier(Object equipmentSupplier) {
		this.equipmentSupplier = equipmentSupplier;
	}

	@JsonProperty("EquipmentSystem")
	public String getEquipmentSystem() {
		return equipmentSystem;
	}

	@JsonProperty("EquipmentSystem")
	public void setEquipmentSystem(String equipmentSystem) {
		this.equipmentSystem = equipmentSystem;
	}

	@JsonProperty("EquipmentType")
	public Object getEquipmentType() {
		return equipmentType;
	}

	@JsonProperty("EquipmentType")
	public void setEquipmentType(Object equipmentType) {
		this.equipmentType = equipmentType;
	}

	@JsonProperty("Equipmentid")
	public Integer getEquipmentid() {
		return equipmentid;
	}

	@JsonProperty("Equipmentid")
	public void setEquipmentid(Integer equipmentid) {
		this.equipmentid = equipmentid;
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
