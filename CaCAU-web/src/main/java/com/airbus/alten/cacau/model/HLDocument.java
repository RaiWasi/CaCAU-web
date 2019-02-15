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
@Table(name="Hl_Document_T", schema="cacau")
public class HLDocument {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Hl_Document_Id")
	private Integer id;  
	
	@NotNull
	@Column(name = "Title")
	@Size(max = 512)
	private String title;
	
	@NotNull
	@Column(name = "Reference")
	@Size(max = 256)
	private String reference;
	
	@NotNull
	@Column(name = "Issue")
	@Size(max = 256)
	private String issue;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Use_Case_Conf_Id")
    private UseCaseConfiguration useCaseConfiguration;
	
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

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public UseCaseConfiguration getUseCaseConfiguration() {
		return useCaseConfiguration;
	}

	public void setUseCaseConfiguration(UseCaseConfiguration useCaseConfiguration) {
		this.useCaseConfiguration = useCaseConfiguration;
	}
}
