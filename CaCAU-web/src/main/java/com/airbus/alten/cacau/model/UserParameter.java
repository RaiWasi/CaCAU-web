package com.airbus.alten.cacau.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "USER_TEMP_PARAMETER_T")
public class UserParameter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_TEMPORARY_LIST")
	private int tempListID;

	@NotNull
	@Column(name = "USERNAME") 
	@Size(max = 15)
	private String username;

	@NotNull
	@Column(name = "SAVED_DATE")
	private String savedDate;
	
	@Column(name = "ID_CONTENT")
	private int ContentID;

	@Column(name = "CONTENT_TITLE")
	@Size(max = 60)
	private String contentTitle;

	@Column(name = "CONTENT_TYPE")
	@Size(max = 20)
	private String contentType;

	@Column(name = "APPLICABILITY_PROGRAM_ACTYPE")
	@Size(max = 4)
	private String applicabilityProgramAcType;

	@Column(name = "APPLICABILITY_ENGINE")
	@Size(max = 10)
	private String applicabilityEngine;

	@Column(name = "ID_EMITTER")
	private int emitterID;

	@Column(name = "EMITTER_NAME")
	@Size(max = 15)
	private String emitterName;

	@Column(name = "EQUIPMENT_CODE")
	@Size(max = 6)
	private String equipmentCode;

	@Column(name = "SIDE")
	private int side;

	@Column(name = "BUS_FUNCTION")
	@Size(max = 45)
	private String busFunction;

	@Column(name = "PORT_CHANNEL_NUMBER")
	private int portChannelNumber;

	@Column(name = "INLAY")
	@Size(max = 4)
	private String inlay;

	@Column(name = "HI_PIN_NUMBER")
	private int hiPinNumber;

	@Column(name = "HI_PIN_CHAR")
	@Size(max = 2)
	private String hiPinChar;

	@Column(name = "parameterId")
	private int parameterId;

	@Column(name = "ID_YP_PARAMETER")
	@Size(max = 45)
	private String ypParameterID;

	@Column(name = "PARAMETER_NAME")
	@Size(max = 60)
	private String parameterName;

	@Column(name = "PARAMETER_DESCRIPTION")
	@Size(max = 45)
	private String parameterDescription;

	@Column(name = "MIN_SAMPLING_FREQUENCE")
	private int minSamplingFrequence;

	@Column(name = "ID_LABEL")
	private int labelID;

	@Column(name = "NUMBER_OCTAL")
	private int octalNumber;

	@Column(name = "LABEL_ORDER")
	private int labelOrder;

	@Column(name = "LABEL_SDI")
	private int labelSDI;

	@Column(name = "LABEL_LEN")
	private int labelLen;

	@Column(name = "LABEL_SIGNED", nullable=false, columnDefinition="TINYINT", length = 1)
	private boolean labelSigned;

	@Column(name = "FIN")
	@Size(max = 45)
	private String fin;

	@Column(name = "SOURCE")
	@Size(max = 45)
	private String source;

	@Column(name = "ATA")
	@Size(max = 10)
	private String ata;

	@Column(name = "SYSTEM")
	@Size(max = 45)
	private String system;

	@Column(name = "TYPE")
	@Size(max = 45)
	private String type;

	@Column(name = "UNIT")
	@Size(max = 20)
	private String unit;

	@Column(name = "LABEL")
	@Size(max = 20)
	private String label;

	@Column(name = "MSB")
	@Size(max = 20)
	private String msb;

	@Column(name = "HARDWARE_PART_NUMBER")
	@Size(max = 20)
	private String hardwarePartNumber;

	@Column(name = "SOFTWARE_PART_NUMBER")
	@Size(max = 20)
	private String softwarePartNumber;

	@Column(name = "APPLICABILITY")
	@Size(max = 20)
	private String applicability;

	@Column(name = "Start_Version")
	private Long startVersion;
	
	@Column(name = "End_Version")
	private Long endVersion;
	
	@NotNull
	@Size(max = 10)
	@Column(name = "Version_Status")
	private String versionStatus = "CREATED";
	
	@NotNull
	@Column(name = "Is_Delete")
	@Value("${props.isFPL:false}")
	private boolean parameterDelete;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USE_CASE_CONF_ID")
    private UseCaseConfiguration useCaseConfiguration;
	
	public Long getStartVersion() {
		return startVersion;
	}

	public void setStartVersion(Long startVersion) {
		this.startVersion = startVersion;
	}

	public Long getEndVersion() {
		return endVersion;
	}

	public void setEndVersion(Long endVersion) {
		this.endVersion = endVersion;
	}

	public String getVersionStatus() {
		return versionStatus;
	}

	public void setVersionStatus(String versionStatus) {
		this.versionStatus = versionStatus;
	}

	public boolean isParameterDelete() {
		return parameterDelete;
	}

	public void setParameterDelete(boolean parameterDelete) {
		this.parameterDelete = parameterDelete;
	}

	public int getTempListID() {
		return tempListID;
	}

	public void setTempListID(int i) {
		this.tempListID = i;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSavedDate() {
		return savedDate;
	}

	public void setSavedDate(String savedDate) {
		this.savedDate = savedDate;
	}
	
	public int getContentID() {
		return ContentID;
	}

	public void setContentID(int contentID) {
		ContentID = contentID;
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getApplicabilityProgramAcType() {
		return applicabilityProgramAcType;
	}

	public void setApplicabilityProgramAcType(String applicabilityProgramAcType) {
		this.applicabilityProgramAcType = applicabilityProgramAcType;
	}

	public String getApplicabilityEngine() {
		return applicabilityEngine;
	}

	public void setApplicabilityEngine(String applicabilityEngine) {
		this.applicabilityEngine = applicabilityEngine;
	}

	public int getEmitterID() {
		return emitterID;
	}

	public void setEmitterID(int emitterID) {
		this.emitterID = emitterID;
	}

	public String getEmitterName() {
		return emitterName;
	}

	public void setEmitterName(String emitterName) {
		this.emitterName = emitterName;
	}

	public String getEquipmentCode() {
		return equipmentCode;
	}

	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	public String getBusFunction() {
		return busFunction;
	}

	public void setBusFunction(String busFunction) {
		this.busFunction = busFunction;
	}

	public int getPortChannelNumber() {
		return portChannelNumber;
	}

	public void setPortChannelNumber(int portChannelNumber) {
		this.portChannelNumber = portChannelNumber;
	}

	public String getInlay() {
		return inlay;
	}

	public void setInl8ay(String inlay) {
		this.inlay = inlay;
	}

	public int getHiPinNumber() {
		return hiPinNumber;
	}

	public void setHiPinNumber(int hiPinNumber) {
		this.hiPinNumber = hiPinNumber;
	}

	public String getHiPinChar() {
		return hiPinChar;
	}

	public void setHiPinChar(String hiPinChar) {
		this.hiPinChar = hiPinChar;
	}

	public int getParameterId() {
		return parameterId;
	}

	public void setParameterId(int parameterId) {
		this.parameterId = parameterId;
	}

	public String getYpParameterID() {
		return ypParameterID;
	}

	public void setYpParameterID(String ypParameterID) {
		this.ypParameterID = ypParameterID;
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

	public int getMinSamplingFrequence() {
		return minSamplingFrequence;
	}

	public void setMinSamplingFrequence(int minSamplingFrequence) {
		this.minSamplingFrequence = minSamplingFrequence;
	}

	public int getLabelID() {
		return labelID;
	}

	public void setLabelID(int labelID) {
		this.labelID = labelID;
	}

	public int getOctalNumber() {
		return octalNumber;
	}

	public void setOctalNumber(int octalNumber) {
		this.octalNumber = octalNumber;
	}

	public int getLabelOrder() {
		return labelOrder;
	}

	public void setLabelOrder(int labelOrder) {
		this.labelOrder = labelOrder;
	}

	public int getLabelSDI() {
		return labelSDI;
	}

	public void setLabelSDI(int labelSDI) {
		this.labelSDI = labelSDI;
	}

	public int getLabelLen() {
		return labelLen;
	}

	public void setLabelLen(int labelLen) {
		this.labelLen = labelLen;
	}

	public boolean getLabelSigned() {
		return labelSigned;
	}

	public void setLabelSigned(boolean labelSigned) {
		this.labelSigned = labelSigned;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getMsb() {
		return msb;
	}

	public void setMsb(String msb) {
		this.msb = msb;
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

	public String getApplicability() {
		return applicability;
	}

	public void setApplicability(String applicability) {
		this.applicability = applicability;
	}

	public void setBusFunction(Integer busConfigRef) {
		// TODO Auto-generated method stub
		
	}

	public UseCaseConfiguration getUseCaseConfiguration() {
		return useCaseConfiguration;
	}

	public void setUseCaseConfiguration(UseCaseConfiguration useCaseConfiguration) {
		this.useCaseConfiguration = useCaseConfiguration;
	}

	/*public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}*/
	
	
}

