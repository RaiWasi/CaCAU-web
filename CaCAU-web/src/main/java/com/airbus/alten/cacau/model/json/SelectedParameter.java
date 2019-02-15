package com.airbus.alten.cacau.model.json;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//new generated SelectedParameter as Parameter - 30.10
//including the new changes:
//added Emitter, LabelSigned, EngineType, ApuType, acType, Version
//many fields missing - all files were written manually since YP still doesnt have the values
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

public class SelectedParameter {

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
	private Integer hiPinNumber;
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
	
	public Object getAcType() {
		return acType;
	}
	public void setAcType(Object acType) {
		this.acType = acType;
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
	public Object getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(Object accuracy) {
		this.accuracy = accuracy;
	}
	public Object getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(Object additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	public String getApplicability() {
		return applicability;
	}
	public void setApplicability(String applicability) {
		this.applicability = applicability;
	}
	public String getApuType() {
		return apuType;
	}
	public void setApuType(String apuType) {
		this.apuType = apuType;
	}
	public Object getBinaryMax() {
		return binaryMax;
	}
	public void setBinaryMax(Object binaryMax) {
		this.binaryMax = binaryMax;
	}
	public Object getBinaryMin() {
		return binaryMin;
	}
	public void setBinaryMin(Object binaryMin) {
		this.binaryMin = binaryMin;
	}
	public Object getBoolFalse() {
		return boolFalse;
	}
	public void setBoolFalse(Object boolFalse) {
		this.boolFalse = boolFalse;
	}
	public Object getBoolTrue() {
		return boolTrue;
	}
	public void setBoolTrue(Object boolTrue) {
		this.boolTrue = boolTrue;
	}
	public Integer getBusConfigRef() {
		return busConfigRef;
	}
	public void setBusConfigRef(Integer busConfigRef) {
		this.busConfigRef = busConfigRef;
	}
	public Object getBusSide() {
		return busSide;
	}
	public void setBusSide(Object busSide) {
		this.busSide = busSide;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEmitter() {
		return emitter;
	}
	public void setEmitter(String emitter) {
		this.emitter = emitter;
	}
	public Object getEngineType() {
		return engineType;
	}
	public void setEngineType(Object engineType) {
		this.engineType = engineType;
	}
	public Object getEnumPattern() {
		return enumPattern;
	}
	public void setEnumPattern(Object enumPattern) {
		this.enumPattern = enumPattern;
	}
	public Object getEnumType() {
		return enumType;
	}
	public void setEnumType(Object enumType) {
		this.enumType = enumType;
	}
	public Object getEnumValue() {
		return enumValue;
	}
	public void setEnumValue(Object enumValue) {
		this.enumValue = enumValue;
	}
	public Object getIdentifier() {
		return identifier;
	}
	public void setIdentifier(Object identifier) {
		this.identifier = identifier;
	}
	public Integer getlSBPosition() {
		return lSBPosition;
	}
	public void setlSBPosition(Integer lSBPosition) {
		this.lSBPosition = lSBPosition;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Object getLabelName() {
		return labelName;
	}
	public void setLabelName(Object labelName) {
		this.labelName = labelName;
	}
	public Object getLabelSigned() {
		return labelSigned;
	}
	public void setLabelSigned(Object labelSigned) {
		this.labelSigned = labelSigned;
	}
	public Integer getLabelWordRef() {
		return labelWordRef;
	}
	public void setLabelWordRef(Integer labelWordRef) {
		this.labelWordRef = labelWordRef;
	}
	public Integer getmSBPosition() {
		return mSBPosition;
	}
	public void setmSBPosition(Integer mSBPosition) {
		this.mSBPosition = mSBPosition;
	}
	public Object getMaxTransmissionInterval() {
		return maxTransmissionInterval;
	}
	public void setMaxTransmissionInterval(Object maxTransmissionInterval) {
		this.maxTransmissionInterval = maxTransmissionInterval;
	}
	public Object getMinTransmissionInterval() {
		return minTransmissionInterval;
	}
	public void setMinTransmissionInterval(Object minTransmissionInterval) {
		this.minTransmissionInterval = minTransmissionInterval;
	}
	public Integer getNumberOfBits() {
		return numberOfBits;
	}
	public void setNumberOfBits(Integer numberOfBits) {
		this.numberOfBits = numberOfBits;
	}
	public Object getOffset() {
		return offset;
	}
	public void setOffset(Object offset) {
		this.offset = offset;
	}
	public Object getOperatingMax() {
		return operatingMax;
	}
	public void setOperatingMax(Object operatingMax) {
		this.operatingMax = operatingMax;
	}
	public Object getOperatingMin() {
		return operatingMin;
	}
	public void setOperatingMin(Object operatingMin) {
		this.operatingMin = operatingMin;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public Object getParA320() {
		return parA320;
	}
	public void setParA320(Object parA320) {
		this.parA320 = parA320;
	}
	public Object getParA321() {
		return parA321;
	}
	public void setParA321(Object parA321) {
		this.parA321 = parA321;
	}
	public Object getParA330() {
		return parA330;
	}
	public void setParA330(Object parA330) {
		this.parA330 = parA330;
	}
	public Object getParA340() {
		return parA340;
	}
	public void setParA340(Object parA340) {
		this.parA340 = parA340;
	}
	public Object getParA350() {
		return parA350;
	}
	public void setParA350(Object parA350) {
		this.parA350 = parA350;
	}
	public Object getParA380() {
		return parA380;
	}
	public void setParA380(Object parA380) {
		this.parA380 = parA380;
	}
	public Object getParAcCeo() {
		return parAcCeo;
	}
	public void setParAcCeo(Object parAcCeo) {
		this.parAcCeo = parAcCeo;
	}
	public Object getParAcNeo() {
		return parAcNeo;
	}
	public void setParAcNeo(Object parAcNeo) {
		this.parAcNeo = parAcNeo;
	}
	public Object getParApuHwl() {
		return parApuHwl;
	}
	public void setParApuHwl(Object parApuHwl) {
		this.parApuHwl = parApuHwl;
	}
	public Object getParApuPw() {
		return parApuPw;
	}
	public void setParApuPw(Object parApuPw) {
		this.parApuPw = parApuPw;
	}
	public Object getParEngCfm() {
		return parEngCfm;
	}
	public void setParEngCfm(Object parEngCfm) {
		this.parEngCfm = parEngCfm;
	}
	public Object getParEngIae() {
		return parEngIae;
	}
	public void setParEngIae(Object parEngIae) {
		this.parEngIae = parEngIae;
	}
	public Object getParEngPw() {
		return parEngPw;
	}
	public void setParEngPw(Object parEngPw) {
		this.parEngPw = parEngPw;
	}
	public Object getParEngRR() {
		return parEngRR;
	}
	public void setParEngRR(Object parEngRR) {
		this.parEngRR = parEngRR;
	}
	public Object getParTypeId() {
		return parTypeId;
	}
	public void setParTypeId(Object parTypeId) {
		this.parTypeId = parTypeId;
	}
	public Object getParameterName() {
		return parameterName;
	}
	public void setParameterName(Object parameterName) {
		this.parameterName = parameterName;
	}
	public Integer getParameterid() {
		return parameterid;
	}
	public void setParameterid(Integer parameterid) {
		this.parameterid = parameterid;
	}
	public Object getResolution() {
		return resolution;
	}
	public void setResolution(Object resolution) {
		this.resolution = resolution;
	}
	public Integer getsDIRef() {
		return sDIRef;
	}
	public void setsDIRef(Integer sDIRef) {
		this.sDIRef = sDIRef;
	}
	public Object getScaleFactor() {
		return scaleFactor;
	}
	public void setScaleFactor(Object scaleFactor) {
		this.scaleFactor = scaleFactor;
	}
	public Object getSdi() {
		return sdi;
	}
	public void setSdi(Object sdi) {
		this.sdi = sdi;
	}
	public Boolean getSigned() {
		return signed;
	}
	public void setSigned(Boolean signed) {
		this.signed = signed;
	}
	public Integer getSignedBitPosition() {
		return signedBitPosition;
	}
	public void setSignedBitPosition(Integer signedBitPosition) {
		this.signedBitPosition = signedBitPosition;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Object getSubOrder() {
		return subOrder;
	}
	public void setSubOrder(Object subOrder) {
		this.subOrder = subOrder;
	}
	public Object getTransmissionInterval() {
		return transmissionInterval;
	}
	public void setTransmissionInterval(Object transmissionInterval) {
		this.transmissionInterval = transmissionInterval;
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
	public Object getUnitRef() {
		return unitRef;
	}
	public void setUnitRef(Object unitRef) {
		this.unitRef = unitRef;
	}
	public Object getValidated() {
		return validated;
	}
	public void setValidated(Object validated) {
		this.validated = validated;
	}
	public Object getVersion() {
		return version;
	}
	public void setVersion(Object version) {
		this.version = version;
	}
	public Integer getParConversion() {
		return parConversion;
	}
	public void setParConversion(Integer parConversion) {
		this.parConversion = parConversion;
	}
	public Boolean getParEnabled() {
		return parEnabled;
	}
	public void setParEnabled(Boolean parEnabled) {
		this.parEnabled = parEnabled;
	}
	public Object getParPostEisConfig() {
		return parPostEisConfig;
	}
	public void setParPostEisConfig(Object parPostEisConfig) {
		this.parPostEisConfig = parPostEisConfig;
	}
	public Object getParService() {
		return parService;
	}
	public void setParService(Object parService) {
		this.parService = parService;
	}
	public Object getParSpecificConfig() {
		return parSpecificConfig;
	}
	public void setParSpecificConfig(Object parSpecificConfig) {
		this.parSpecificConfig = parSpecificConfig;
	}
	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}
	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
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
	public Integer getHiPinNumber() {
		return hiPinNumber;
	}
	public void setHiPinNumber(Integer hiPinNumber) {
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
	public void setHiPinNumber1(Integer hiPinNumber) {
		this.hiPinNumber = hiPinNumber;
	}
}
