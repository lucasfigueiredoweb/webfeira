package com.br.webfeira.model;

import javax.persistence.Entity;

@Entity
public class Localizacao extends AbstractEntity {

	private String longitude;
	private String latitude;

	public Localizacao() {
		super();
	}

	public Localizacao(String longitude, String latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

}
