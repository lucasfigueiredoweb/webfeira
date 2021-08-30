package com.br.webfeira.dto;

import java.util.ArrayList;
import java.util.List;

import com.br.webfeira.model.Endereco;
import com.br.webfeira.model.Feira;
import com.br.webfeira.model.Localizacao;
import com.br.webfeira.model.Municipio;
import com.br.webfeira.model.SetorCensitario;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FeiraDTO {

	@JsonProperty("ID")
	private String id;

	@JsonProperty("NOME_FEIRA")
	private String nomeFeira;
	@JsonProperty("REGISTRO")
	private String registroFeira;

	@JsonProperty("LONG")
	private String longitude;
	@JsonProperty("LAT")
	private String latitude;

	@JsonProperty("SETCENS")
	private String nomeCensitario;
	@JsonProperty("AREAP")
	private String areaCensitario;

	@JsonProperty("CODDIST")
	private String codigoDistrito;
	@JsonProperty("DISTRITO")
	private String nomeDistrito;
	@JsonProperty("CODSUBPREF")
	private String codigoPrefeitura;
	@JsonProperty("SUBPREFE")
	private String nomePrefeitura;
	@JsonProperty("REGIAO5")
	private String regiao5;
	@JsonProperty("REGIAO8")
	private String regiao8;

	@JsonProperty("LOGRADOURO")
	private String logradouro;
	@JsonProperty("NUMERO")
	private String numero;
	@JsonProperty("BAIRRO")
	private String bairro;
	@JsonProperty("REFERENCIA")
	private String referencia;

	public static FeiraDTO toDTO(Feira feira) {
		FeiraDTO dto = new FeiraDTO();
		dto.setId(feira.getId().toString());
		dto.setNomeFeira(feira.getNomeFeira());
		dto.setRegistroFeira(feira.getRegistroFeira());
		dto.setLongitude(feira.getLocalizacao().getLongitude());
		dto.setLatitude(feira.getLocalizacao().getLatitude());
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

	public static List<FeiraDTO> toDTOList(List<Feira> feiras) {
		List<FeiraDTO> feirasDTO = new ArrayList<FeiraDTO>();

		for (Feira feira : feiras) {
			FeiraDTO dto = new FeiraDTO();
			dto.setId(feira.getId().toString());
			dto.setNomeFeira(feira.getNomeFeira());
			dto.setRegistroFeira(feira.getRegistroFeira());
			dto.setLongitude(feira.getLocalizacao().getLongitude());
			dto.setLatitude(feira.getLocalizacao().getLatitude());
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
			feirasDTO.add(dto);
		}
		return feirasDTO;
	}

	public static Feira fromDTO(FeiraDTO dto) {
		Feira feira = new Feira();
		feira.setNomeFeira(dto.getNomeFeira());
		feira.setRegistroFeira(dto.getRegistroFeira());

		feira.setLocalizacao(new Localizacao(dto.getLongitude(), dto.getLatitude()));
		feira.setEndereco(new Endereco(dto.getLogradouro(), dto.getNumero(), dto.getBairro(), dto.getReferencia()));
		feira.setMunicipio(new Municipio(dto.getCodigoDistrito(), dto.getNomeDistrito(), dto.getCodigoPrefeitura(),
				dto.getNomePrefeitura(), dto.getRegiao5(), dto.getRegiao8()));
		feira.setSetor(new SetorCensitario(dto.getNomeCensitario(), dto.getAreaCensitario()));
		return feira;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
