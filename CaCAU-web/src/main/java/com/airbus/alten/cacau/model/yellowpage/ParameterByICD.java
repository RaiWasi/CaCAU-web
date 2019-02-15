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
	"ACUSagem",
	"ACUSagemInstance",
	"ACUTeledyne",
	"ACUTeledyneInstance",
	"Accuracy",
	"AdditionalInfo",
	"Applicability",
	"BinaryMax",
	"BinaryMin",
	"BoolFalse",
	"BoolTrue",
	"BusConfigRef",
	"BusSide",
	"Description",
	"EnumPattern",
	"EnumType",
	"EnumValue",
	"Identifier",
	"LSBPosition",
	"Label",
	"LabelName",
	"MSBPosition",
	"MaxTransmissionInterval",
	"MinTransmissionInterval",
	"NumberOfBits",
	"Offset",
	"OperatingMax",
	"OperatingMin",
	"Order",
	"ParA320",
	"ParA321",
	"ParAcCeo",
	"ParAcNeo",
	"ParApuHwl",
	"ParApuPw",
	"ParEngCfm",
	"ParEngIae",
	"ParEngPw",
	"ParTypeId",
	"ParameterName",
	"Parameterid",
	"Resolution",
	"SDIRef",
	"ScaleFactor",
	"Sdi",
	"Signed",
	"SignedBitPosition",
	"Source",
	"SubOrder",
	"TransmissionInterval",
	"Type",
	"Unit",
	"UnitRef",
	"Validated",
	"parEnabled",
	"parService"
})

public class ParameterByICD {

	@JsonProperty("ACUSagem")
	private String aCUSagem;
	@JsonProperty("ACUSagemInstance")
	private String aCUSagemInstance;
	@JsonProperty("ACUTeledyne")
	private String aCUTeledyne;
	@JsonProperty("ACUTeledyneInstance")
	private Object aCUTeledyneInstance;
	@JsonProperty("Accuracy")
	private Object accuracy;
	@JsonProperty("AdditionalInfo")
	private Object additionalInfo;
	@JsonProperty("Applicability")
	private String applicability;
	@JsonProperty("BinaryMax")
	private String binaryMax;
	@JsonProperty("BinaryMin")
	private String binaryMin;
	@JsonProperty("BoolFalse")
	private String boolFalse;
	@JsonProperty("BoolTrue")
	private String boolTrue;
	@JsonProperty("BusConfigRef")
	private Integer busConfigRef;
	@JsonProperty("BusSide")
	private String busSide;
	@JsonProperty("Description")
	private String description;
	@JsonProperty("EnumPattern")
	private String enumPattern;
	@JsonProperty("EnumType")
	private Object enumType;
	@JsonProperty("EnumValue")
	private String enumValue;
	@JsonProperty("Identifier")
	private Object identifier;
	@JsonProperty("LSBPosition")
	private Integer lSBPosition;
	@JsonProperty("Label")
	private String label;
	@JsonProperty("LabelName")
	private String labelName;
	@JsonProperty("MSBPosition")
	private Integer mSBPosition;
	@JsonProperty("MaxTransmissionInterval")
	private String maxTransmissionInterval;
	@JsonProperty("MinTransmissionInterval")
	private String minTransmissionInterval;
	@JsonProperty("NumberOfBits")
	private Integer numberOfBits;
	@JsonProperty("Offset")
	private Object offset;
	@JsonProperty("OperatingMax")
	private String operatingMax;
	@JsonProperty("OperatingMin")
	private String operatingMin;
	@JsonProperty("Order")
	private Integer order;
	@JsonProperty("ParA320")
	private Boolean parA320;
	@JsonProperty("ParA321")
	private Object parA321;
	@JsonProperty("ParAcCeo")
	private Boolean parAcCeo;
	@JsonProperty("ParAcNeo")
	private Boolean parAcNeo;
	@JsonProperty("ParApuHwl")
	private Boolean parApuHwl;
	@JsonProperty("ParApuPw")
	private Boolean parApuPw;
	@JsonProperty("ParEngCfm")
	private Boolean parEngCfm;
	@JsonProperty("ParEngIae")
	private Boolean parEngIae;
	@JsonProperty("ParEngPw")
	private Boolean parEngPw;
	@JsonProperty("ParTypeId")
	private Integer parTypeId;
	@JsonProperty("ParameterName")
	private String parameterName;
	@JsonProperty("Parameterid")
	private Integer parameterid;
	@JsonProperty("Resolution")
	private Object resolution;
	@JsonProperty("SDIRef")
	private Integer sDIRef;
	@JsonProperty("ScaleFactor")
	private Object scaleFactor;
	@JsonProperty("Sdi")
	private String sdi;
	@JsonProperty("Signed")
	private Boolean signed;
	@JsonProperty("SignedBitPosition")
	private Integer signedBitPosition;
	@JsonProperty("Source")
	private String source;
	@JsonProperty("SubOrder")
	private String subOrder;
	@JsonProperty("TransmissionInterval")
	private Integer transmissionInterval;
	@JsonProperty("Type")
	private String type;
	@JsonProperty("Unit")
	private String unit;
	@JsonProperty("UnitRef")
	private Integer unitRef;
	@JsonProperty("Validated")
	private Boolean validated;
	@JsonProperty("parEnabled")
	private Boolean parEnabled;
	@JsonProperty("parService")
	private Object parService;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("ACUSagem")
	public String getACUSagem() {
		return aCUSagem;
	}

	@JsonProperty("ACUSagem")
	public void setACUSagem(String aCUSagem) {
		this.aCUSagem = aCUSagem;
	}

	@JsonProperty("ACUSagemInstance")
	public String getACUSagemInstance() {
		return aCUSagemInstance;
	}

	@JsonProperty("ACUSagemInstance")
	public void setACUSagemInstance(String aCUSagemInstance) {
		this.aCUSagemInstance = aCUSagemInstance;
	}

	@JsonProperty("ACUTeledyne")
	public String getACUTeledyne() {
		return aCUTeledyne;
	}

	@JsonProperty("ACUTeledyne")
	public void setACUTeledyne(String aCUTeledyne) {
		this.aCUTeledyne = aCUTeledyne;
	}

	@JsonProperty("ACUTeledyneInstance")
	public Object getACUTeledyneInstance() {
		return aCUTeledyneInstance;
	}

	@JsonProperty("ACUTeledyneInstance")
	public void setACUTeledyneInstance(Object aCUTeledyneInstance) {
		this.aCUTeledyneInstance = aCUTeledyneInstance;
	}

	@JsonProperty("Accuracy")
	public Object getAccuracy() {
		return accuracy;
	}

	@JsonProperty("Accuracy")
	public void setAccuracy(Object accuracy) {
		this.accuracy = accuracy;
	}

	@JsonProperty("AdditionalInfo")
	public Object getAdditionalInfo() {
		return additionalInfo;
	}

	@JsonProperty("AdditionalInfo")
	public void setAdditionalInfo(Object additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	@JsonProperty("Applicability")
	public String getApplicability() {
		return applicability;
	}

	@JsonProperty("Applicability")
	public void setApplicability(String applicability) {
		this.applicability = applicability;
	}

	@JsonProperty("BinaryMax")
	public String getBinaryMax() {
		return binaryMax;
	}

	@JsonProperty("BinaryMax")
	public void setBinaryMax(String binaryMax) {
		this.binaryMax = binaryMax;
	}

	@JsonProperty("BinaryMin")
	public String getBinaryMin() {
		return binaryMin;
	}

	@JsonProperty("BinaryMin")
	public void setBinaryMin(String binaryMin) {
		this.binaryMin = binaryMin;
	}

	@JsonProperty("BoolFalse")
	public String getBoolFalse() {
		return boolFalse;
	}

	@JsonProperty("BoolFalse")
	public void setBoolFalse(String boolFalse) {
		this.boolFalse = boolFalse;
	}

	@JsonProperty("BoolTrue")
	public String getBoolTrue() {
		return boolTrue;
	}

	@JsonProperty("BoolTrue")
	public void setBoolTrue(String boolTrue) {
		this.boolTrue = boolTrue;
	}

	@JsonProperty("BusConfigRef")
	public Integer getBusConfigRef() {
		return busConfigRef;
	}

	@JsonProperty("BusConfigRef")
	public void setBusConfigRef(Integer busConfigRef) {
		this.busConfigRef = busConfigRef;
	}

	@JsonProperty("BusSide")
	public String getBusSide() {
		return busSide;
	}

	@JsonProperty("BusSide")
	public void setBusSide(String busSide) {
		this.busSide = busSide;
	}

	@JsonProperty("Description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("Description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("EnumPattern")
	public String getEnumPattern() {
		return enumPattern;
	}

	@JsonProperty("EnumPattern")
	public void setEnumPattern(String enumPattern) {
		this.enumPattern = enumPattern;
	}

	@JsonProperty("EnumType")
	public Object getEnumType() {
		return enumType;
	}

	@JsonProperty("EnumType")
	public void setEnumType(Object enumType) {
		this.enumType = enumType;
	}

	@JsonProperty("EnumValue")
	public String getEnumValue() {
		return enumValue;
	}

	@JsonProperty("EnumValue")
	public void setEnumValue(String enumValue) {
		this.enumValue = enumValue;
	}

	@JsonProperty("Identifier")
	public Object getIdentifier() {
		return identifier;
	}

	@JsonProperty("Identifier")
	public void setIdentifier(Object identifier) {
		this.identifier = identifier;
	}

	@JsonProperty("LSBPosition")
	public Integer getLSBPosition() {
		return lSBPosition;
	}

	@JsonProperty("LSBPosition")
	public void setLSBPosition(Integer lSBPosition) {
		this.lSBPosition = lSBPosition;
	}

	@JsonProperty("Label")
	public String getLabel() {
		return label;
	}

	@JsonProperty("Label")
	public void setLabel(String label) {
		this.label = label;
	}

	@JsonProperty("LabelName")
	public String getLabelName() {
		return labelName;
	}

	@JsonProperty("LabelName")
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	@JsonProperty("MSBPosition")
	public Integer getMSBPosition() {
		return mSBPosition;
	}

	@JsonProperty("MSBPosition")
	public void setMSBPosition(Integer mSBPosition) {
		this.mSBPosition = mSBPosition;
	}

	@JsonProperty("MaxTransmissionInterval")
	public String getMaxTransmissionInterval() {
		return maxTransmissionInterval;
	}

	@JsonProperty("MaxTransmissionInterval")
	public void setMaxTransmissionInterval(String maxTransmissionInterval) {
		this.maxTransmissionInterval = maxTransmissionInterval;
	}

	@JsonProperty("MinTransmissionInterval")
	public String getMinTransmissionInterval() {
		return minTransmissionInterval;
	}

	@JsonProperty("MinTransmissionInterval")
	public void setMinTransmissionInterval(String minTransmissionInterval) {
		this.minTransmissionInterval = minTransmissionInterval;
	}

	@JsonProperty("NumberOfBits")
	public Integer getNumberOfBits() {
		return numberOfBits;
	}

	@JsonProperty("NumberOfBits")
	public void setNumberOfBits(Integer numberOfBits) {
		this.numberOfBits = numberOfBits;
	}

	@JsonProperty("Offset")
	public Object getOffset() {
		return offset;
	}

	@JsonProperty("Offset")
	public void setOffset(Object offset) {
		this.offset = offset;
	}

	@JsonProperty("OperatingMax")
	public String getOperatingMax() {
		return operatingMax;
	}

	@JsonProperty("OperatingMax")
	public void setOperatingMax(String operatingMax) {
		this.operatingMax = operatingMax;
	}

	@JsonProperty("OperatingMin")
	public String getOperatingMin() {
		return operatingMin;
	}

	@JsonProperty("OperatingMin")
	public void setOperatingMin(String operatingMin) {
		this.operatingMin = operatingMin;
	}

	@JsonProperty("Order")
	public Integer getOrder() {
		return order;
	}

	@JsonProperty("Order")
	public void setOrder(Integer order) {
		this.order = order;
	}

	@JsonProperty("ParA320")
	public Boolean getParA320() {
		return parA320;
	}

	@JsonProperty("ParA320")
	public void setParA320(Boolean parA320) {
		this.parA320 = parA320;
	}

	@JsonProperty("ParA321")
	public Object getParA321() {
		return parA321;
	}

	@JsonProperty("ParA321")
	public void setParA321(Object parA321) {
		this.parA321 = parA321;
	}

	@JsonProperty("ParAcCeo")
	public Boolean getParAcCeo() {
		return parAcCeo;
	}

	@JsonProperty("ParAcCeo")
	public void setParAcCeo(Boolean parAcCeo) {
		this.parAcCeo = parAcCeo;
	}

	@JsonProperty("ParAcNeo")
	public Boolean getParAcNeo() {
		return parAcNeo;
	}

	@JsonProperty("ParAcNeo")
	public void setParAcNeo(Boolean parAcNeo) {
		this.parAcNeo = parAcNeo;
	}

	@JsonProperty("ParApuHwl")
	public Boolean getParApuHwl() {
		return parApuHwl;
	}

	@JsonProperty("ParApuHwl")
	public void setParApuHwl(Boolean parApuHwl) {
		this.parApuHwl = parApuHwl;
	}

	@JsonProperty("ParApuPw")
	public Boolean getParApuPw() {
		return parApuPw;
	}

	@JsonProperty("ParApuPw")
	public void setParApuPw(Boolean parApuPw) {
		this.parApuPw = parApuPw;
	}

	@JsonProperty("ParEngCfm")
	public Boolean getParEngCfm() {
		return parEngCfm;
	}

	@JsonProperty("ParEngCfm")
	public void setParEngCfm(Boolean parEngCfm) {
		this.parEngCfm = parEngCfm;
	}

	@JsonProperty("ParEngIae")
	public Boolean getParEngIae() {
		return parEngIae;
	}

	@JsonProperty("ParEngIae")
	public void setParEngIae(Boolean parEngIae) {
		this.parEngIae = parEngIae;
	}

	@JsonProperty("ParEngPw")
	public Boolean getParEngPw() {
		return parEngPw;
	}

	@JsonProperty("ParEngPw")
	public void setParEngPw(Boolean parEngPw) {
		this.parEngPw = parEngPw;
	}

	@JsonProperty("ParTypeId")
	public Integer getParTypeId() {
		return parTypeId;
	}

	@JsonProperty("ParTypeId")
	public void setParTypeId(Integer parTypeId) {
		this.parTypeId = parTypeId;
	}

	@JsonProperty("ParameterName")
	public String getParameterName() {
		return parameterName;
	}

	@JsonProperty("ParameterName")
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	@JsonProperty("Parameterid")
	public Integer getParameterid() {
		return parameterid;
	}

	@JsonProperty("Parameterid")
	public void setParameterid(Integer parameterid) {
		this.parameterid = parameterid;
	}

	@JsonProperty("Resolution")
	public Object getResolution() {
		return resolution;
	}

	@JsonProperty("Resolution")
	public void setResolution(Object resolution) {
		this.resolution = resolution;
	}

	@JsonProperty("SDIRef")
	public Integer getSDIRef() {
		return sDIRef;
	}

	@JsonProperty("SDIRef")
	public void setSDIRef(Integer sDIRef) {
		this.sDIRef = sDIRef;
	}

	@JsonProperty("ScaleFactor")
	public Object getScaleFactor() {
		return scaleFactor;
	}

	@JsonProperty("ScaleFactor")
	public void setScaleFactor(Object scaleFactor) {
		this.scaleFactor = scaleFactor;
	}

	@JsonProperty("Sdi")
	public String getSdi() {
		return sdi;
	}

	@JsonProperty("Sdi")
	public void setSdi(String sdi) {
		this.sdi = sdi;
	}

	@JsonProperty("Signed")
	public Boolean getSigned() {
		return signed;
	}

	@JsonProperty("Signed")
	public void setSigned(Boolean signed) {
		this.signed = signed;
	}

	@JsonProperty("SignedBitPosition")
	public Integer getSignedBitPosition() {
		return signedBitPosition;
	}

	@JsonProperty("SignedBitPosition")
	public void setSignedBitPosition(Integer signedBitPosition) {
		this.signedBitPosition = signedBitPosition;
	}

	@JsonProperty("Source")
	public String getSource() {
		return source;
	}

	@JsonProperty("Source")
	public void setSource(String source) {
		this.source = source;
	}

	@JsonProperty("SubOrder")
	public String getSubOrder() {
		return subOrder;
	}

	@JsonProperty("SubOrder")
	public void setSubOrder(String subOrder) {
		this.subOrder = subOrder;
	}

	@JsonProperty("TransmissionInterval")
	public Integer getTransmissionInterval() {
		return transmissionInterval;
	}

	@JsonProperty("TransmissionInterval")
	public void setTransmissionInterval(Integer transmissionInterval) {
		this.transmissionInterval = transmissionInterval;
	}

	@JsonProperty("Type")
	public String getType() {
		return type;
	}

	@JsonProperty("Type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("Unit")
	public String getUnit() {
		return unit;
	}

	@JsonProperty("Unit")
	public void setUnit(String unit) {
		this.unit = unit;
	}

	@JsonProperty("UnitRef")
	public Integer getUnitRef() {
		return unitRef;
	}

	@JsonProperty("UnitRef")
	public void setUnitRef(Integer unitRef) {
		this.unitRef = unitRef;
	}

	@JsonProperty("Validated")
	public Boolean getValidated() {
		return validated;
	}

	@JsonProperty("Validated")
	public void setValidated(Boolean validated) {
		this.validated = validated;
	}

	@JsonProperty("parEnabled")
	public Boolean getParEnabled() {
		return parEnabled;
	}

	@JsonProperty("parEnabled")
	public void setParEnabled(Boolean parEnabled) {
		this.parEnabled = parEnabled;
	}

	@JsonProperty("parService")
	public Object getParService() {
		return parService;
	}

	@JsonProperty("parService")
	public void setParService(Object parService) {
		this.parService = parService;
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
