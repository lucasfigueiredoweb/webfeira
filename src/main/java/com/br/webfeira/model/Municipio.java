package com.br.webfeira.model;

import javax.persistence.Entity;

@Entity
public class Municipio extends AbstractEntity {

	private String codigoDistrito;
	private String nomeDistrito;
	private String codigoPrefeitura;
	private String nomePrefeitura;
	private String regiao5;
	private String regiao8;

	public Municipio() {
		super();
	}

	public Municipio(String codigoDistrito, String nomeDistrito, String codigoPrefeitura, String nomePrefeitura,
			String regiao5, String regiao8) {
		super();
		this.codigoDistrito = codigoDistrito;
		this.nomeDistrito = nomeDistrito;
		this.codigoPrefeitura = codigoPrefeitura;
		this.nomePrefeitura = nomePrefeitura;
		this.regiao5 = regiao5;
		this.regiao8 = regiao8;
	}

	public String getCodigoDistrito() {
		return codigoDistrito;
	}

	public void setCodigoDistrito(String codigoDistrito) {
		this.codigoDistrito = codigoDistrito;
	}

	public String getNomeDistrito() {
		return nomeDistrito;
	}

	public void setNomeDistrito(String nomeDistrito) {
		this.nomeDistrito = nomeDistrito;
	}

	public String getCodigoPrefeitura() {
		return codigoPrefeitura;
	}

	public void setCodigoPrefeitura(String codigoPrefeitura) {
		this.codigoPrefeitura = codigoPrefeitura;
	}

	public String getNomePrefeitura() {
		return nomePrefeitura;
	}

	public void setNomePrefeitura(String nomePrefeitura) {
		this.nomePrefeitura = nomePrefeitura;
	}

	public String getRegiao5() {
		return regiao5;
	}

	public void setRegiao5(String regiao5) {
		this.regiao5 = regiao5;
	}

	public String getRegiao8() {
		return regiao8;
	}

	public void setRegiao8(String regiao8) {
		this.regiao8 = regiao8;
	}

}
