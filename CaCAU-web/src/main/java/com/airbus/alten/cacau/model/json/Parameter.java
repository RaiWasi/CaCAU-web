package com.airbus.alten.cacau.model.json;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//added Emitter, LabelSigned, EngineType, ApuType, acType, Version
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"AcType",
	"ACUSagem",
	"ACUSagemInstance",
	"ACUTeledyne",
	"ACUTeledyneInstance",
	"Accuracy",
	"AdditionalInfo",
	"Applicability",
	"ApuType",
	"Ata",
	"BinaryMax",
	"BinaryMin",
	"BoolFalse",
	"BoolTrue",
	"BusConfigRef",
	"BusFunction",
	"BusSide",
	"Description",
	"Emitter",
	"EngineType",
	"EnumPattern",
	"EnumType",
	"EnumValue",
	"EquipmentCode",
	"EquipmentName",
	"Fd",
	"Fin",
	"HiPinNumber",
	"HiPinChar",
	"HwPn",
	"icaoCode",
	"Identifier",
	"Inlay",
	"LSBPosition",
	"Label",
	"LabelName",
	"LabelSigned",
	"LabelWordRef",
	"MSBPosition",
	"MaxTransmissionInterval",
	"MinTransmissionInterval",
	"MinSamplingFreq",
	"NumberOfBits",
	"OctalLabel",
	"Offset",
	"OperatingMax",
	"OperatingMin",
	"Order",
	"ParA320",
	"ParA321",
	"ParA330",
	"ParA340",
	"ParA350",
	"ParA380",
	"ParAcCeo",
	"ParAcNeo",
	"ParApuHwl",
	"ParApuPw",
	"ParEngCfm",
	"ParEngIae",
	"ParEngPw",
	"ParEngRR",
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
	"System",
	"SwPn",
	"TransmissionInterval",
	"Type",
	"Unit",
	"UnitRef",
	"YpParameterId",
	"Validated",
	"Version",
	"parConversion",
	"parEnabled",
	"parPostEisConfig",
	"parService",
	"parSpecificConfig"
})

public class Parameter {

	@JsonProperty("AcType")
	private Object acType;
	@JsonProperty("ACUSagem")
	private Object aCUSagem;
	@JsonProperty("ACUSagemInstance")
	private Object aCUSagemInstance;
	@JsonProperty("ACUTeledyne")
	private Object aCUTeledyne;
	@JsonProperty("ACUTeledyneInstance")
	private Object aCUTeledyneInstance;
	@JsonProperty("Accuracy")
	private Object accuracy;
	@JsonProperty("AdditionalInfo")
	private Object additionalInfo;
	@JsonProperty("Applicability")
	private String applicability;
	@JsonProperty("ApuType")
	private String apuType;
	@JsonProperty("Ata")
	private String ata;
	@JsonProperty("BinaryMax")
	private Object binaryMax;
	@JsonProperty("BinaryMin")
	private Object binaryMin;
	@JsonProperty("BoolFalse")
	private Object boolFalse;
	@JsonProperty("BoolTrue")
	private Object boolTrue;
	@JsonProperty("BusConfigRef")
	private Integer busConfigRef;
	@JsonProperty("BusFunction")
	private String busFunction;
	@JsonProperty("BusSide")
	private Object busSide;
	@JsonProperty("Description")
	private String description;
	@JsonProperty("Emitter")
	private String emitter;
	@JsonProperty("EngineType")
	private Object engineType;
	@JsonProperty("EnumPattern")
	private Object enumPattern;
	@JsonProperty("EnumType")
	private Object enumType;
	@JsonProperty("EnumValue")
	private Object enumValue;
	@JsonProperty("EquipmentCode")
	private String equipmentCode;
	@JsonProperty("EquipmentName")
	private String equipmentName;
	@JsonProperty("Fd")
	private String fd;
	@JsonProperty("Fin")
	private String fin;
	@JsonProperty("HiPinNumber")
	private String hiPinNumber;
	@JsonProperty("HiPinChar")
	private String hiPinChar;
	@JsonProperty("HwPn")
	private String hwPn;
	@JsonProperty("icaoCode")
	private String icaoCode;
	@JsonProperty("Inlay")
	private String inlay;
	@JsonProperty("Identifier")
	private Object identifier;
	@JsonProperty("LSBPosition")
	private Integer lSBPosition;
	@JsonProperty("Label")
	private String label;
	@JsonProperty("LabelName")
	private Object labelName;
	@JsonProperty("LabelSigned")
	private Object labelSigned;
	@JsonProperty("LabelWordRef")
	private Integer labelWordRef;
	@JsonProperty("MSBPosition")
	private Integer mSBPosition;
	@JsonProperty("MaxTransmissionInterval")
	private Object maxTransmissionInterval;
	@JsonProperty("MinTransmissionInterval")
	private Object minTransmissionInterval;
	@JsonProperty("MinSamplingFreq")
	private Integer minSamplingFreq;
	@JsonProperty("NumberOfBits")
	private Integer numberOfBits;
	@JsonProperty("OctalLabel")
	private String octalLabel;
	@JsonProperty("Offset")
	private Object offset;
	@JsonProperty("OperatingMax")
	private Object operatingMax;
	@JsonProperty("OperatingMin")
	private Object operatingMin;
	@JsonProperty("Order")
	private Integer order;
	@JsonProperty("ParA320")
	private Object parA320;
	@JsonProperty("ParA321")
	private Object parA321;
	@JsonProperty("ParA330")
	private Object parA330;
	@JsonProperty("ParA340")
	private Object parA340;
	@JsonProperty("ParA350")
	private Object parA350;
	@JsonProperty("ParA380")
	private Object parA380;
	@JsonProperty("ParAcCeo")
	private Object parAcCeo;
	@JsonProperty("ParAcNeo")
	private Object parAcNeo;
	@JsonProperty("ParApuHwl")
	private Object parApuHwl;
	@JsonProperty("ParApuPw")
	private Object parApuPw;
	@JsonProperty("ParEngCfm")
	private Object parEngCfm;
	@JsonProperty("ParEngIae")
	private Object parEngIae;
	@JsonProperty("ParEngPw")
	private Object parEngPw;
	@JsonProperty("ParEngRR")
	private Object parEngRR;
	@JsonProperty("ParTypeId")
	private Object parTypeId;
	@JsonProperty("ParameterName")
	private Object parameterName;
	@JsonProperty("Parameterid")
	private Integer parameterid;
	@JsonProperty("Resolution")
	private Object resolution;
	@JsonProperty("SDIRef")
	private Integer sDIRef;
	@JsonProperty("ScaleFactor")
	private Object scaleFactor;
	@JsonProperty("Sdi")
	private Object sdi;
	@JsonProperty("Signed")
	private Boolean signed;
	@JsonProperty("SignedBitPosition")
	private Integer signedBitPosition;
	@JsonProperty("Source")
	private String source;
	@JsonProperty("SubOrder")
	private Object subOrder;
	@JsonProperty("System")
	private Object system;
	@JsonProperty("SwPn")
	private Object swPn;
	@JsonProperty("TransmissionInterval")
	private Object transmissionInterval;
	@JsonProperty("Tailnumber")
	private String tailnumber;
	@JsonProperty("Type")
	private String type;
	@JsonProperty("Unit")
	private String unit;
	@JsonProperty("UnitRef")
	private Object unitRef;
	@JsonProperty("YpParameterId")
	private Object ypParameterId;
	@JsonProperty("Validated")
	private Object validated;
	@JsonProperty("Version")
	private Object version;
	@JsonProperty("parConversion")
	private Integer parConversion;
	@JsonProperty("parEnabled")
	private Boolean parEnabled;
	@JsonProperty("parPostEisConfig")
	private Object parPostEisConfig;
	@JsonProperty("parService")
	private Object parService;
	@JsonProperty("parSpecificConfig")
	private Object parSpecificConfig;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("ACUSagem")
	public Object getACUSagem() {
		return aCUSagem;
	}

	@JsonProperty("ACUSagem")
	public void setACUSagem(Object aCUSagem) {
		this.aCUSagem = aCUSagem;
	}

	@JsonProperty("ACUSagemInstance")
	public Object getACUSagemInstance() {
		return aCUSagemInstance;
	}

	@JsonProperty("ACUSagemInstance")
	public void setACUSagemInstance(Object aCUSagemInstance) {
		this.aCUSagemInstance = aCUSagemInstance;
	}

	@JsonProperty("ACUTeledyne")
	public Object getACUTeledyne() {
		return aCUTeledyne;
	}

	@JsonProperty("ACUTeledyne")
	public void setACUTeledyne(Object aCUTeledyne) {
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
	public Object getBinaryMax() {
		return binaryMax;
	}

	@JsonProperty("BinaryMax")
	public void setBinaryMax(Object binaryMax) {
		this.binaryMax = binaryMax;
	}

	@JsonProperty("BinaryMin")
	public Object getBinaryMin() {
		return binaryMin;
	}

	@JsonProperty("BinaryMin")
	public void setBinaryMin(Object binaryMin) {
		this.binaryMin = binaryMin;
	}

	@JsonProperty("BoolFalse")
	public Object getBoolFalse() {
		return boolFalse;
	}

	@JsonProperty("BoolFalse")
	public void setBoolFalse(Object boolFalse) {
		this.boolFalse = boolFalse;
	}

	@JsonProperty("BoolTrue")
	public Object getBoolTrue() {
		return boolTrue;
	}

	@JsonProperty("BoolTrue")
	public void setBoolTrue(Object boolTrue) {
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
	public Object getBusSide() {
		return busSide;
	}

	@JsonProperty("BusSide")
	public void setBusSide(Object busSide) {
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
	
	@JsonProperty("Emitter")
	public String getEmitter() {
		return emitter;
	}

	@JsonProperty("Emitter")
	public void setEmitter(String emitter) {
		this.emitter = emitter;
	}
	
	@JsonProperty("EnumPattern")
	public Object getEnumPattern() {
		return enumPattern;
	}

	@JsonProperty("EnumPattern")
	public void setEnumPattern(Object enumPattern) {
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
	public Object getEnumValue() {
		return enumValue;
	}

	@JsonProperty("EnumValue")
	public void setEnumValue(Object enumValue) {
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
	public Object getLabelName() {
		return labelName;
	}

	@JsonProperty("LabelName")
	public void setLabelName(Object labelName) {
		this.labelName = labelName;
	}

	@JsonProperty("LabelWordRef")
	public Integer getLabelWordRef() {
		return labelWordRef;
	}

	@JsonProperty("LabelWordRef")
	public void setLabelWordRef(Integer labelWordRef) {
		this.labelWordRef = labelWordRef;
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
	public Object getMaxTransmissionInterval() {
		return maxTransmissionInterval;
	}

	@JsonProperty("MaxTransmissionInterval")
	public void setMaxTransmissionInterval(Object maxTransmissionInterval) {
		this.maxTransmissionInterval = maxTransmissionInterval;
	}

	@JsonProperty("MinTransmissionInterval")
	public Object getMinTransmissionInterval() {
		return minTransmissionInterval;
	}

	@JsonProperty("MinTransmissionInterval")
	public void setMinTransmissionInterval(Object minTransmissionInterval) {
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
	public Object getOperatingMax() {
		return operatingMax;
	}

	@JsonProperty("OperatingMax")
	public void setOperatingMax(Object operatingMax) {
		this.operatingMax = operatingMax;
	}

	@JsonProperty("OperatingMin")
	public Object getOperatingMin() {
		return operatingMin;
	}

	@JsonProperty("OperatingMin")
	public void setOperatingMin(Object operatingMin) {
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
	public Object getParA320() {
		return parA320;
	}

	@JsonProperty("ParA320")
	public void setParA320(Object parA320) {
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

	@JsonProperty("ParA330")
	public Object getParA330() {
		return parA330;
	}

	@JsonProperty("ParA330")
	public void setParA330(Object parA330) {
		this.parA330 = parA330;
	}

	@JsonProperty("ParA340")
	public Object getParA340() {
		return parA340;
	}

	@JsonProperty("ParA340")
	public void setParA340(Object parA340) {
		this.parA340 = parA340;
	}

	@JsonProperty("ParA350")
	public Object getParA350() {
		return parA350;
	}

	@JsonProperty("ParA350")
	public void setParA350(Object parA350) {
		this.parA350 = parA350;
	}

	@JsonProperty("ParA380")
	public Object getParA380() {
		return parA380;
	}

	@JsonProperty("ParA380")
	public void setParA380(Object parA380) {
		this.parA380 = parA380;
	}

	@JsonProperty("ParAcCeo")
	public Object getParAcCeo() {
		return parAcCeo;
	}

	@JsonProperty("ParAcCeo")
	public void setParAcCeo(Object parAcCeo) {
		this.parAcCeo = parAcCeo;
	}

	@JsonProperty("ParAcNeo")
	public Object getParAcNeo() {
		return parAcNeo;
	}

	@JsonProperty("ParAcNeo")
	public void setParAcNeo(Object parAcNeo) {
		this.parAcNeo = parAcNeo;
	}

	@JsonProperty("ParApuHwl")
	public Object getParApuHwl() {
		return parApuHwl;
	}

	@JsonProperty("ParApuHwl")
	public void setParApuHwl(Object parApuHwl) {
		this.parApuHwl = parApuHwl;
	}

	@JsonProperty("ParApuPw")
	public Object getParApuPw() {
		return parApuPw;
	}

	@JsonProperty("ParApuPw")
	public void setParApuPw(Object parApuPw) {
		this.parApuPw = parApuPw;
	}

	@JsonProperty("ParEngCfm")
	public Object getParEngCfm() {
		return parEngCfm;
	}

	@JsonProperty("ParEngCfm")
	public void setParEngCfm(Object parEngCfm) {
		this.parEngCfm = parEngCfm;
	}

	@JsonProperty("ParEngIae")
	public Object getParEngIae() {
		return parEngIae;
	}

	@JsonProperty("ParEngIae")
	public void setParEngIae(Object parEngIae) {
		this.parEngIae = parEngIae;
	}

	@JsonProperty("ParEngPw")
	public Object getParEngPw() {
		return parEngPw;
	}

	@JsonProperty("ParEngPw")
	public void setParEngPw(Object parEngPw) {
		this.parEngPw = parEngPw;
	}

	@JsonProperty("ParEngRR")
	public Object getParEngRR() {
		return parEngRR;
	}

	@JsonProperty("ParEngRR")
	public void setParEngRR(Object parEngRR) {
		this.parEngRR = parEngRR;
	}

	@JsonProperty("ParTypeId")
	public Object getParTypeId() {
		return parTypeId;
	}

	@JsonProperty("ParTypeId")
	public void setParTypeId(Object parTypeId) {
		this.parTypeId = parTypeId;
	}

	@JsonProperty("ParameterName")
	public Object getParameterName() {
		return parameterName;
	}

	@JsonProperty("ParameterName")
	public void setParameterName(Object parameterName) {
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
	public Object getSdi() {
		return sdi;
	}

	@JsonProperty("Sdi")
	public void setSdi(Object sdi) {
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
	public Object getSubOrder() {
		return subOrder;
	}

	@JsonProperty("SubOrder")
	public void setSubOrder(Object subOrder) {
		this.subOrder = subOrder;
	}

	@JsonProperty("TransmissionInterval")
	public Object getTransmissionInterval() {
		return transmissionInterval;
	}

	@JsonProperty("TransmissionInterval")
	public void setTransmissionInterval(Object transmissionInterval) {
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
	public Object getUnitRef() {
		return unitRef;
	}

	@JsonProperty("UnitRef")
	public void setUnitRef(Object unitRef) {
		this.unitRef = unitRef;
	}

	@JsonProperty("Validated")
	public Object getValidated() {
		return validated;
	}

	@JsonProperty("Validated")
	public void setValidated(Object validated) {
		this.validated = validated;
	}

	@JsonProperty("parConversion")
	public Integer getParConversion() {
		return parConversion;
	}

	@JsonProperty("parConversion")
	public void setParConversion(Integer parConversion) {
		this.parConversion = parConversion;
	}

	@JsonProperty("parEnabled")
	public Boolean getParEnabled() {
		return parEnabled;
	}

	@JsonProperty("parEnabled")
	public void setParEnabled(Boolean parEnabled) {
		this.parEnabled = parEnabled;
	}

	@JsonProperty("parPostEisConfig")
	public Object getParPostEisConfig() {
		return parPostEisConfig;
	}

	@JsonProperty("parPostEisConfig")
	public void setParPostEisConfig(Object parPostEisConfig) {
		this.parPostEisConfig = parPostEisConfig;
	}

	@JsonProperty("parService")
	public Object getParService() {
		return parService;
	}

	@JsonProperty("parService")
	public void setParService(Object parService) {
		this.parService = parService;
	}

	@JsonProperty("parSpecificConfig")
	public Object getParSpecificConfig() {
		return parSpecificConfig;
	}

	@JsonProperty("parSpecificConfig")
	public void setParSpecificConfig(Object parSpecificConfig) {
		this.parSpecificConfig = parSpecificConfig;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public Object getaCUSagem() {
		return aCUSagem;
	}

	public void setaCUSagem(Object aCUSagem) {
		this.aCUSagem = aCUSagem;
	}

	public Object getaCUSagemInstance() {
		return aCUSagemInstance;
	}

	public void setaCUSagemInstance(Object aCUSagemInstance) {
		this.aCUSagemInstance = aCUSagemInstance;
	}

	public Object getaCUTeledyne() {
		return aCUTeledyne;
	}

	public void setaCUTeledyne(Object aCUTeledyne) {
		this.aCUTeledyne = aCUTeledyne;
	}

	public Object getaCUTeledyneInstance() {
		return aCUTeledyneInstance;
	}

	public void setaCUTeledyneInstance(Object aCUTeledyneInstance) {
		this.aCUTeledyneInstance = aCUTeledyneInstance;
	}

	public Integer getlSBPosition() {
		return lSBPosition;
	}

	public void setlSBPosition(Integer lSBPosition) {
		this.lSBPosition = lSBPosition;
	}

	public Integer getmSBPosition() {
		return mSBPosition;
	}

	public void setmSBPosition(Integer mSBPosition) {
		this.mSBPosition = mSBPosition;
	}

	public Integer getsDIRef() {
		return sDIRef;
	}

	public void setsDIRef(Integer sDIRef) {
		this.sDIRef = sDIRef;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	public Object getLabelSigned() {
		return labelSigned;
	}

	public void setLabelSigned(Object labelSigned) {
		this.labelSigned = labelSigned;
	}

	public Object getAcType() {
		return acType;
	}

	public void setAcType(Object acType) {
		this.acType = acType;
	}

	public Object getVersion() {
		return version;
	}

	public void setVersion(Object version) {
		this.version = version;
	}

	public String getApuType() {
		return apuType;
	}

	public void setApuType(String apuType) {
		this.apuType = apuType;
	}

	public Object getEngineType() {
		return engineType;
	}

	public void setEngineType(Object engineType) {
		this.engineType = engineType;
	}

	public String getAta() {
		return ata;
	}

	public void setAta(String ata) {
		this.ata = ata;
	}

	public String getBusFunction() {
		return busFunction;
	}

	public void setBusFunction(String busFunction) {
		this.busFunction = busFunction;
	}

	public String getEquipmentCode() {
		return equipmentCode;
	}

	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public String getHiPinNumber() {
		return hiPinNumber;
	}

	public void setHiPinNumber(String hiPinNumber) {
		this.hiPinNumber = hiPinNumber;
	}

	public String getHiPinChar() {
		return hiPinChar;
	}

	public void setHiPinChar(String hiPinChar) {
		this.hiPinChar = hiPinChar;
	}

	public String getHwPn() {
		return hwPn;
	}

	public void setHwPn(String hwPn) {
		this.hwPn = hwPn;
	}

	public String getInlay() {
		return inlay;
	}

	public void setInlay(String inlay) {
		this.inlay = inlay;
	}

	public Integer getMinSamplingFreq() {
		return minSamplingFreq;
	}

	public void setMinSamplingFreq(Integer minSamplingFreq) {
		this.minSamplingFreq = minSamplingFreq;
	}

	public String getOctalLabel() {
		return octalLabel;
	}

	public void setOctalLabel(String octalLabel) {
		this.octalLabel = octalLabel;
	}

	public Object getSystem() {
		return system;
	}

	public void setSystem(Object system) {
		this.system = system;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getFd() {
		return fd;
	}

	public void setFd(String fd) {
		this.fd = fd;
	}

	public String getIcaoCode() {
		return icaoCode;
	}

	public void setIcaoCode(String icaoCode) {
		this.icaoCode = icaoCode;
	}

	public Object getSwPn() {
		return swPn;
	}

	public void setSwPn(Object swPn) {
		this.swPn = swPn;
	}

	public String getTailnumber() {
		return tailnumber;
	}

	public void setTailnumber(String tailnumber) {
		this.tailnumber = tailnumber;
	}

	public Object getYpParameterId() {
		return ypParameterId;
	}

	public void setYpParameterId(Object ypParameterId) {
		this.ypParameterId = ypParameterId;
	}
	
}
