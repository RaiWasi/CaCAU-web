package com.airbus.alten.cacau.logic;

public class ParameterToSearch {

	private String name;
	private String description;
	private String label;
	private String emitter;
	private String source;

	public ParameterToSearch() {
	}
	
	public ParameterToSearch(String name, String description, String label, String emitter, String source) {

		this.name = name;
		this.description = description;
		this.label = label;
		this.emitter = emitter;
		this.source = source;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getEmitter() {
		return emitter;
	}

	public void setEmitter(String emitter) {
		this.emitter = emitter;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}
