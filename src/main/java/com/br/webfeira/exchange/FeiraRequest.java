package com.br.webfeira.exchange;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.br.webfeira.models.Endereco;
import com.br.webfeira.models.Feira;
import com.br.webfeira.models.Localizacao;
import com.br.webfeira.models.Municipio;
import com.br.webfeira.models.SetorCensitario;

public class FeiraRequest implements Serializable {

	private static final long serialVersionUID = 4123309474876952526L;

	@NotBlank(message = "Nome da Feira e obrigatorio")
	@Size(min = 4, max = 30)
	private String nomeFeira;

	private String registroFeira;

	private String longitude;

	private String latitude;

	@NotBlank(message = "Codigo do Setor Censitario da Feira e obrigatorio e nao pode ser nulo ou vazio")
	@Size(min = 4, max = 15)
	private String codigoCensitario;

	@NotBlank(message = "Area do Setor Censitario da Feira e obrigatorio e nao pode ser nulo ou vazio")
	@Size(min = 4, max = 13)
	private String areaCensitario;

	@NotBlank(message = "Código do Distrito Municipal da Feira e obrigatorio")
	@Size(min = 1, max = 9)
	private String codigoDistrito;

	@NotBlank(message = "Código do Distrito Municipal da Feira e obrigatorioo")
	@Size(min = 4, max = 18)
	private String nomeDistrito;

	@NotBlank(message = "Código de Registro da Prefeitura responsavel pela Feira e obrigatorio")
	@Size(min = 1, max = 2)
	private String codigoPrefeitura;

	@NotBlank(message = "Nome da Prefeitura responsavel pela Feira e obrigatorio")
	@Size(min = 4, max = 25)
	private String nomePrefeitura;

	private String regiao5;

	private String regiao8;

	@NotBlank(message = "Logradouro da Feira e obrigatorio")
	@Size(min = 4, max = 34)
	private String logradouro;

	@NotBlank(message = "Numero do Logradouro da Feira e obrigatorio")
	@Size(min = 1, max = 5)
	private String numero;

	@NotBlank(message = "Bairro de Registro da Feira e obrigatorio")
	@Size(min = 4, max = 20)
	private String bairro;

	private String referencia;

	public void copyToModel(Feira feira) {
		feira.setNomeFeira(this.nomeFeira);
		
		if(this.registroFeira == null || this.registroFeira.equals("")) {
			throw new IllegalArgumentException("Codigo de Registro da Feira e obrigatorio");
		}
		
		feira.setRegistroFeira(this.registroFeira);

		feira.setLocalizacao(new Localizacao(this.longitude, this.latitude));
		feira.setSetor(new SetorCensitario(this.codigoCensitario, this.areaCensitario));
		feira.setMunicipio(new Municipio(this.codigoDistrito, this.nomeDistrito, this.codigoPrefeitura,
				this.nomePrefeitura, this.regiao5, this.regiao8));
		feira.setEndereco(new Endereco(this.logradouro, this.numero, this.bairro, this.referencia));
	}
	
	public void copyToModelUpdate(Feira feira) {
		feira.setNomeFeira(this.nomeFeira);
		
		feira.setLocalizacao(new Localizacao(this.longitude, this.latitude));
		feira.setSetor(new SetorCensitario(this.codigoCensitario, this.areaCensitario));
		feira.setMunicipio(new Municipio(this.codigoDistrito, this.nomeDistrito, this.codigoPrefeitura,
				this.nomePrefeitura, this.regiao5, this.regiao8));
		feira.setEndereco(new Endereco(this.logradouro, this.numero, this.bairro, this.referencia));
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

	public String getCodigoCensitario() {
		return codigoCensitario;
	}

	public void setCodigoCensitario(String codigoCensitario) {
		this.codigoCensitario = codigoCensitario;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
