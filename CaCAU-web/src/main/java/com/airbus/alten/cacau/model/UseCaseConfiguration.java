package com.airbus.alten.cacau.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="USE_CASE_CONFIGURATION_T", schema="cacau")
public class UseCaseConfiguration {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Use_Case_Conf_Id")
	private Integer id;  
	
	@NotNull
	@Column(name = "title")
	@Size(max = 512)
	private String title;
	
	@NotNull
	@Column(name = "program")
	@Size(max = 32)
	private String program;
	
	@Column(name = "YP_Database_Version")
	@Size(max = 32)
	private String yellowPageDBVersion;
	
	@Column(name = "source")
	@Size(max = 64)
	private String source;
	
	@Column(name = "YP_Data_Service_Version")
	@Size(max = 32)
	private String yellowPageDataServiceVersion;

	@NotNull
	@OneToMany(mappedBy = "useCaseConfiguration", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, targetEntity = ACVersion.class, orphanRemoval = true)
	private List<ACVersion> versions = new ArrayList<ACVersion>();
	
	@NotNull
	@OneToMany(mappedBy = "useCaseConfiguration", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, targetEntity = ACEngine.class, orphanRemoval = true)
	private List<ACEngine> engines = new ArrayList<ACEngine>();
	
	@NotNull
	@OneToMany(mappedBy = "useCaseConfiguration", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, targetEntity = ACApu.class, orphanRemoval = true)
	private List<ACApu> apus = new ArrayList<ACApu>();
	
	@OneToMany(mappedBy = "useCaseConfiguration", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, targetEntity = UserParameter.class, orphanRemoval = true)
    private List<UserParameter> userParameters;

	@OneToMany(mappedBy = "useCaseConfiguration", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, targetEntity = UserDummyParameter.class, orphanRemoval = true)
    private List<UserDummyParameter> userDummyParameters;
	

	@OneToMany(mappedBy = "useCaseConfiguration", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, targetEntity = Reference.class, orphanRemoval = true)
	private List<Reference> references = new ArrayList<Reference>();
	
	
	@OneToMany(mappedBy = "useCaseConfiguration", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, targetEntity = Release.class, orphanRemoval = true)
	private List<Release> releases = new ArrayList<Release>();
	
	
	@OneToMany(mappedBy = "useCaseConfiguration", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, targetEntity = HLDocument.class, orphanRemoval = true)
	private List<HLDocument> hlDocuments = new ArrayList<HLDocument>();
	
	
	@NotNull
	@Column(name = "user_id")
	private int userId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getYellowPageDBVersion() {
		return yellowPageDBVersion;
	}

	public void setYellowPageDBVersion(String yellowPageDBVersion) {
		this.yellowPageDBVersion = yellowPageDBVersion;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getYellowPageDataServiceVersion() {
		return yellowPageDataServiceVersion;
	}

	public void setYellowPageDataServiceVersion(String yellowPageDataServiceVersion) {
		this.yellowPageDataServiceVersion = yellowPageDataServiceVersion;
	}

	public List<ACVersion> getVersions() {
		return versions;
	}

	public void setVersions(List<ACVersion> versions) {
		this.versions = versions;
	}

	public List<ACEngine> getEngines() {
		return engines;
	}

	public void setEngines(List<ACEngine> engines) {
		this.engines = engines;
	}

	public List<ACApu> getApus() {
		return apus;
	}

	public void setApus(List<ACApu> apus) {
		this.apus = apus;
	}

	public List<UserParameter> getUserParameters() {
		return userParameters;
	}

	public void setUserParameters(List<UserParameter> userParameters) {
		this.userParameters = userParameters;
	}


	public List<UserDummyParameter> getUserDummyParameters() {
		return userDummyParameters;
	}

	public void setUserDummyParameters(List<UserDummyParameter> userDummyParameters) {
		this.userDummyParameters = userDummyParameters;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Reference> getReferences() {
		return references;
	}

	public void setReferences(List<Reference> references) {
		this.references = references;
	}

	public List<Release> getReleases() {
		return releases;
	}

	public void setReleases(List<Release> releases) {
		this.releases = releases;
	}

	public List<HLDocument> getHlDocuments() {
		return hlDocuments;
	}

	public void setHlDocuments(List<HLDocument> hlDocuments) {
		this.hlDocuments = hlDocuments;
	}
	
}
