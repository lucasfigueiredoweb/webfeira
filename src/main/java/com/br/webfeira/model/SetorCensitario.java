package com.br.webfeira.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class SetorCensitario extends AbstractEntity {

	@Column(name="SETCENS", length=15, nullable=false, unique=false)
	private String codigoCensitario;
	@Column(name="AREAP", length=13, nullable=false, unique=false)
	private String areaCensitario;

	public SetorCensitario() {
		super();
	}

	public SetorCensitario(String nomeCensitario, String areaCensitario) {
		super();
		this.codigoCensitario = nomeCensitario;
		this.areaCensitario = areaCensitario;
	}

	public String getNomeCensitario() {
		return codigoCensitario;
	}

	public void setNomeCensitario(String nomeCensitario) {
		this.codigoCensitario = nomeCensitario;
	}

	public String getAreaCensitario() {
		return areaCensitario;
	}

	public void setAreaCensitario(String areaCensitario) {
		this.areaCensitario = areaCensitario;
	}

}
