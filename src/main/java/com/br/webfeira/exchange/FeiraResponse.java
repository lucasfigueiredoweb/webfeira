package com.br.webfeira.exchange;

import java.util.ArrayList;
import java.util.List;

import com.br.webfeira.models.Feira;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class FeiraResponse {

	private String details;

	private String id;

	private String nomeFeira;
	private String registroFeira;

	private String longitude;
	private String latitude;

	private String nomeCensitario;
	private String areaCensitario;

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
	
	public static FeiraResponse toResponse(Feira feira) {
		FeiraResponse response = new FeiraResponse();
		response.setId(feira.getId().toString());
		response.setNomeFeira(feira.getNomeFeira());
		response.setRegistroFeira(feira.getRegistroFeira());
		response.setLongitude(feira.getLocalizacao().getLongitude());
		response.setLatitude(feira.getLocalizacao().getLatitude());
		response.setNomeCensitario(feira.getSetor().getNomeCensitario());
		response.setAreaCensitario(feira.getSetor().getAreaCensitario());
		response.setCodigoDistrito(feira.getMunicipio().getCodigoDistrito());
		response.setNomeDistrito(feira.getMunicipio().getNomeDistrito());
		response.setCodigoPrefeitura(feira.getMunicipio().getCodigoPrefeitura());
		response.setNomePrefeitura(feira.getMunicipio().getNomePrefeitura());
		response.setRegiao5(feira.getMunicipio().getRegiao5());
		response.setRegiao8(feira.getMunicipio().getRegiao8());
		response.setLogradouro(feira.getEndereco().getLogradouro());
		response.setNumero(feira.getEndereco().getNumero());
		response.setBairro(feira.getEndereco().getBairro());
		response.setReferencia(feira.getEndereco().getReferencia());
		return response;
	}
	
	public static List<FeiraResponse> toResponseList(List<Feira> feiras) {
		List<FeiraResponse> feirasResponse = new ArrayList<FeiraResponse>();

		for (Feira feira : feiras) {
			FeiraResponse response = new FeiraResponse();
			response.setId(feira.getId().toString());
			response.setNomeFeira(feira.getNomeFeira());
			response.setRegistroFeira(feira.getRegistroFeira());
			response.setLongitude(feira.getLocalizacao().getLongitude());
			response.setLatitude(feira.getLocalizacao().getLatitude());
			response.setNomeCensitario(feira.getSetor().getNomeCensitario());
			response.setAreaCensitario(feira.getSetor().getAreaCensitario());
			response.setCodigoDistrito(feira.getMunicipio().getCodigoDistrito());
			response.setNomeDistrito(feira.getMunicipio().getNomeDistrito());
			response.setCodigoPrefeitura(feira.getMunicipio().getCodigoPrefeitura());
			response.setNomePrefeitura(feira.getMunicipio().getNomePrefeitura());
			response.setRegiao5(feira.getMunicipio().getRegiao5());
			response.setRegiao8(feira.getMunicipio().getRegiao8());
			response.setLogradouro(feira.getEndereco().getLogradouro());
			response.setNumero(feira.getEndereco().getNumero());
			response.setBairro(feira.getEndereco().getBairro());
			response.setReferencia(feira.getEndereco().getReferencia());
			feirasResponse.add(response);
		}
		return feirasResponse;
	}
	
	public FeiraResponse() {
		super();
	}

	public FeiraResponse(String details) {
		super();
		this.details = details;
	}

	public FeiraResponse(String details, String id, String nomeFeira, String registroFeira, String longitude,
			String latitude, String nomeCensitario, String areaCensitario, String codigoDistrito, String nomeDistrito,
			String codigoPrefeitura, String nomePrefeitura, String regiao5, String regiao8, String logradouro,
			String numero, String bairro, String referencia) {
		super();
		this.details = details;
		this.id = id;
		this.nomeFeira = nomeFeira;
		this.registroFeira = registroFeira;
		this.longitude = longitude;
		this.latitude = latitude;
		this.nomeCensitario = nomeCensitario;
		this.areaCensitario = areaCensitario;
		this.codigoDistrito = codigoDistrito;
		this.nomeDistrito = nomeDistrito;
		this.codigoPrefeitura = codigoPrefeitura;
		this.nomePrefeitura = nomePrefeitura;
		this.regiao5 = regiao5;
		this.regiao8 = regiao8;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.referencia = referencia;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
