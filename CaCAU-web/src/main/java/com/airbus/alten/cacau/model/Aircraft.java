package com.airbus.alten.cacau.model;

public class Aircraft {

	private boolean dummy;
	private String paramName;
	private String paramDesc;
	private String emitter;
	private String fin;
	private String equipment;
	private Integer side;
	private String source;
	private String ata;
	private String system;
	private String type;
	private String unit;
	private Integer label;
	private Integer msb;
	private String hwPn;
	private String swPn;
	private String applicability;
	private Long aircraftID;
	//private String aircraftName;
	//private String version;
	//private String engine;
	//private String acu;
	
	public boolean isDummy() {
		return dummy;
	}
	public void setDummy(boolean dummy) {
		this.dummy = dummy;
	}
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public String getParamDesc() {
		return paramDesc;
	}
	public void setParamDesc(String paramDesc) {
		this.paramDesc = paramDesc;
	}
	public String getEmitter() {
		return emitter;
	}
	public void setEmitter(String emitter) {
		this.emitter = emitter;
	}
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	public Integer getSide() {
		return side;
	}
	public void setSide(Integer side) {
		this.side = side;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getAta() {
		return ata;
	}
	public void setAta(String ata) {
		this.ata = ata;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
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
	public Integer getLabel() {
		return label;
	}
	public void setLabel(Integer label) {
		this.label = label;
	}
	public Integer getMsb() {
		return msb;
	}
	public void setMsb(Integer msb) {
		this.msb = msb;
	}
	public String getHwPn() {
		return hwPn;
	}
	public void setHwPn(String hwPn) {
		this.hwPn = hwPn;
	}
	public String getSwPn() {
		return swPn;
	}
	public void setSwPn(String swPn) {
		this.swPn = swPn;
	}
	public String getApplicability() {
		return applicability;
	}
	public void setApplicability(String applicability) {
		this.applicability = applicability;
	}
	
	public Long getAircraftID() {
		return aircraftID;
	}
	public void setAircraftID(Long aircraftID) {
		this.aircraftID = aircraftID;
	}
	
}
