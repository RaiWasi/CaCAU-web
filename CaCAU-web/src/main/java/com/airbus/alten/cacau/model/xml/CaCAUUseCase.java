package com.airbus.alten.cacau.model.xml;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CaCAUUseCase {

	private int idCacau;
	private String nameCacau;
	private int versionCacau;

	public int getIdCacau() {
		return idCacau;
	}

	@XmlAttribute
	public void setIdCacau(int idCacau) {
		this.idCacau = idCacau;
	}

	public String getNameCacau() {
		return nameCacau;
	}


	@XmlElement
	public void setNameCacau(String nameCacau) {
		this.nameCacau = nameCacau;
	}

	public int getVersionCacau() {
		return versionCacau;
	}

	@XmlElement

	public void setVersionCacau(int versionCacau) {
		this.versionCacau = versionCacau;
	}

}
