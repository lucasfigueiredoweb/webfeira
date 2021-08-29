package com.br.webfeira.model;

import javax.persistence.Entity;

@Entity
public class Feira extends AbstractEntity {

	private Localizacao localizacao;
	private SetorCensitario setor;
	private Municipio municipio;
	private Endereco endereco;

	private String nomeFeira;
	private String registroFeira;
	
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
		this.registroFeira = registroFeira;
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
		return registroFeira;
	}

	public void setRegistroFeira(String registroFeira) {
		this.registroFeira = registroFeira;
	}
}
