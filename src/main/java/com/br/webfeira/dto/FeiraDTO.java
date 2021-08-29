package com.br.webfeira.dto;

import com.br.webfeira.model.Feira;

import lombok.Data;

@Data
public class FeiraDTO {

	private String longitude;
	private String latitude;

	private String nomeCensitario;
	private String areaCensitario;

	private String nomeFeira;
	private String registroFeira;

	private String codigoDistrito;
	private String nomeDistrito;
	private String codigoPrefeitura;
	private String nomePrefeitura;
	private String regiao5;
	private String regiao8;

	private String logradouro;
	private String numero;
	private String bairro;
	private String referencia;

	public static FeiraDTO toDTO(Feira feira) {
		FeiraDTO dto = new FeiraDTO();
		dto.setLongitude(feira.getLocalizacao().getLongitude());
		dto.setLongitude(feira.getLocalizacao().getLatitude());
		dto.setNomeCensitario(feira.getSetor().getNomeCensitario());
		dto.setAreaCensitario(feira.getSetor().getAreaCensitario());
		dto.setCodigoDistrito(feira.getMunicipio().getCodigoDistrito());
		dto.setNomeDistrito(feira.getMunicipio().getNomeDistrito());
		dto.setCodigoPrefeitura(feira.getMunicipio().getCodigoPrefeitura());
		dto.setNomePrefeitura(feira.getMunicipio().getNomePrefeitura());
		dto.setRegiao5(feira.getMunicipio().getRegiao5());
		dto.setRegiao8(feira.getMunicipio().getRegiao8());
		dto.setLogradouro(feira.getEndereco().getLogradouro());
		dto.setNumero(feira.getEndereco().getNumero());
		dto.setBairro(feira.getEndereco().getBairro());
		dto.setReferencia(feira.getEndereco().getReferencia());
		return dto;
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
