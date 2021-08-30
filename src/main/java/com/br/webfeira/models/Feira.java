package com.br.webfeira.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(indexes = { @Index(name = "IDX_NOMEFEIRAIDX1", columnList = "NOME_FEIRA") })
public class Feira extends AbstractEntity {
	
	@Column(name="NOME_FEIRA", length=30, nullable=false, unique=false)
	private String nomeFeira;
	
	@Column(name="REGISTRO", length=6, nullable=false, unique=false)
	private String codigoRegistroFeira;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "LOCALIZACAO_ID")
	private Localizacao localizacao;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "SETOR_ID")
	private SetorCensitario setor;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "MUNICIPIO_ID")
	private Municipio municipio;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "ENDERECO_ID")
	private Endereco endereco;
	
	public Feira() {
		super();
	}

	public Feira(Localizacao localizacao, SetorCensitario setor, Municipio municipio, Endereco endereco,
			String nomeFeira, String registroFeira) {
		super();
		this.localizacao = localizacao;
		this.setor = setor;
		this.municipio = municipio;
		this.endereco = endereco;
		this.nomeFeira = nomeFeira;
		this.codigoRegistroFeira = registroFeira;
	}


	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public SetorCensitario getSetor() {
		return setor;
	}

	public void setSetor(SetorCensitario setor) {
		this.setor = setor;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNomeFeira() {
		return nomeFeira;
	}

	public void setNomeFeira(String nomeFeira) {
		this.nomeFeira = nomeFeira;
	}

	public String getRegistroFeira() {
		return codigoRegistroFeira;
	}

	public void setRegistroFeira(String registroFeira) {
		this.codigoRegistroFeira = registroFeira;
	}
}
