package com.br.webfeira.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(indexes = { @Index(name = "IDX_NOMEDISTRITOIDX1", columnList = "CODDIST"),
	@Index(name = "IDX_REGIAO5IDX1", columnList = "REGIAO5") })
public class Municipio extends AbstractEntity {

	@Column(name = "CODDIST", length = 9, nullable = false, unique = false)
	private String codigoDistrito;
	@Column(name = "DISTRITO", length = 18, nullable = false, unique = false)
	private String nomeDistrito;
	@Column(name = "CODSUBPREF", length = 2, nullable = false, unique = false)
	private String codigoPrefeitura;
	@Column(name = "SUBPREF", length = 25, nullable = false, unique = false)
	private String nomePrefeitura;
	@Column(name = "REGIAO5", length = 6, nullable = false, unique = false)
	private String regiao5;
	@Column(name = "REGIAO8", length = 7, nullable = false, unique = false)
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
