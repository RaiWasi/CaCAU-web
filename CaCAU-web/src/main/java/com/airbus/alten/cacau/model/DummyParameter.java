package com.airbus.alten.cacau.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.vaadin.data.util.BeanContainer;

@Entity
@Table(name = "DUMMY_PARAMETER_T", schema="cacau")
public class DummyParameter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Dummy_Parameter_Id")
	private Integer id;

	@Column(name = "Parameter_Name")
	@Size(max = 128)
	private String parameterName;

	@Column(name = "Parameter_Description", nullable = false)
	@Size(max = 512)
	private String parameterDescription;

	@Column(name = "Emitter")
	@Size(max = 64)
	private String emitter;

	@Column(name = "Equipment_Name")
	@Size(max = 64)
	private String equipmentName;
	
	@Column(name = "System")
	@Size(max = 64)
	private String system;

	@Column(name = "Source")
	@Size(max = 64)
	private String source;
	
	@Column(name = "Label")
	@Size(max = 3)
	private String label;
	
	@Column(name = "Side")
	@Size(max = 3)
	private String side;
	
	@Column(name = "Msb")
	@Size(max = 8)
	private String msb;
	
	@Column(name = "Applicability")
	@Size(max = 16)
	private String applicability;
	
	@Column(name = "Ata")
	@Size(max = 16)
	private String ata;
	
	@Column(name = "Fin")
	@Size(max = 16)
	private String fin;
	
	@Column(name = "Type")
	@Size(max = 16)
	private String type;
	
	@Column(name = "Unit")
	@Size(max = 32)
	private String unit;
	
	@Column(name = "Hardware_Part_Number")
	@Size(max = 16)
	private String hardwarePartNumber;
	
	@Column(name = "Software_Part_Number")
	@Size(max = 16)
	private String softwarePartNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterDescription() {
		return parameterDescription;
	}

	public void setParameterDescription(String parameterDescription) {
		this.parameterDescription = parameterDescription;
	}

	public String getEmitter() {
		return emitter;
	}

	public void setEmitter(String emitter) {
		this.emitter = emitter;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getMsb() {
		return msb;
	}

	public void setMsb(String msb) {
		this.msb = msb;
	}

	public String getApplicability() {
		return applicability;
	}

	public void setApplicability(String applicability) {
		this.applicability = applicability;
	}

	public String getAta() {
		return ata;
	}

	public void setAta(String ata) {
		this.ata = ata;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getHardwarePartNumber() {
		return hardwarePartNumber;
	}

	public void setHardwarePartNumber(String hardwarePartNumber) {
		this.hardwarePartNumber = hardwarePartNumber;
	}

	public String getSoftwarePartNumber() {
		return softwarePartNumber;
	}

	public void setSoftwarePartNumber(String softwarePartNumber) {
		this.softwarePartNumber = softwarePartNumber;
	}

	public boolean contains(BeanContainer<Integer, UserDummyParameter> temporaryListContainer) {
		// TODO Auto-generated method stub
		return false;
	}

}
