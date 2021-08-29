package com.br.webfeira.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Endereco extends AbstractEntity {

	@Column(name="LOGRADOURO", length=34, nullable=false, unique=false)
	private String logradouro;
	@Column(name="NUMERO", length=5, nullable=false, unique=false)
	private String numero;
	@Column(name="BAIRRO", length=20, nullable=false, unique=false)
	private String bairro;
	@Column(name="REFERENCIA", length=24, nullable=false, unique=false)
	private String referencia;

	public Endereco() {
		super();
	}

	public Endereco(String logradouro, String numero, String bairro, String referencia) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.referencia = referencia;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

}
