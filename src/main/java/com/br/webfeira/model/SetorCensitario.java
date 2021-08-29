package com.br.webfeira.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetorCensitario extends AbstractEntity {

	private String nomeCensitario;
	private String areaCensitario;

	public SetorCensitario() {
		super();
	}

	public SetorCensitario(String nomeCensitario, String areaCensitario) {
		super();
		this.nomeCensitario = nomeCensitario;
		this.areaCensitario = areaCensitario;
	}

	public String getNomeCensitario() {
		return nomeCensitario;
	}

	public void setNomeCensitario(String nomeCensitario) {
		this.nomeCensitario = nomeCensitario;
	}

	public String getAreaCensitario() {
		return areaCensitario;
	}

	public void setAreaCensitario(String areaCensitario) {
		this.areaCensitario = areaCensitario;
	}

}
