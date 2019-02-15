package com.airbus.alten.cacau.model;

import java.util.Calendar;

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

@Entity
@Table(name="RELEASE_T", schema="cacau")
public class Release {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Release_Id")
	private Integer id;  
	
	@NotNull
	@Column(name = "Version")
	@Size(max = 128)
	private String version;
	
	@NotNull
	@Column(name = "Description")
	@Size(max = 512)
	private String description;
	

	@Column(name = "Date")
	private Calendar date;
	
	@NotNull
	@Column(name = "Status")
	@Size(max = 32)
	private String status;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Use_Case_Conf_Id")
    private UseCaseConfiguration useCaseConfiguration;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UseCaseConfiguration getUseCaseConfiguration() {
		return useCaseConfiguration;
	}

	public void setUseCaseConfiguration(UseCaseConfiguration useCaseConfiguration) {
		this.useCaseConfiguration = useCaseConfiguration;
	}
	
}
