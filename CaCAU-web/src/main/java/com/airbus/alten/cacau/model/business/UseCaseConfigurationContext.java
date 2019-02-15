package com.airbus.alten.cacau.model.business;

public class UseCaseConfigurationContext {

	private String title;
	
	private String program;

	private String yellowPageDBVersion;

	private String source;
	
	private String yellowPageDataServiceVersion;

	private String version;
	
	private String engine;
	
	private String apu;

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

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getApu() {
		return apu;
	}

	public void setApu(String apu) {
		this.apu = apu;
	}

}
