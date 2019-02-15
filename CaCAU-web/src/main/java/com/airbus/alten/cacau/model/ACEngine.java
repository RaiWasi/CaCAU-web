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



@Entity
@Table(name="AC_ENGINE_T", schema="cacau")
public class ACEngine {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Engine_Id")
	private Integer id;  
	
	@NotNull
	@Column(name = "Engine_Name")
	@Size(max = 32)
	private String engineName;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Use_Case_Conf_Id")
    private UseCaseConfiguration useCaseConfiguration;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEngineName() {
		return engineName;
	}

	public void setEngineName(String engineName) {
		this.engineName = engineName;
	}

	public UseCaseConfiguration getUseCaseConfiguration() {
		return useCaseConfiguration;
	}

	public void setUseCaseConfiguration(UseCaseConfiguration useCaseConfiguration) {
		this.useCaseConfiguration = useCaseConfiguration;
	}
	
}
