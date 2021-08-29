package com.br.webfeira.exchange;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.br.webfeira.model.Feira;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeiraRequest implements Serializable {

	private static final long serialVersionUID = 4123309474876952526L;

	@NotBlank(message = "Nome da Feira e obrigatorio")
	@Pattern(regexp = "[0-9 ()-]{4,12}")
	private String nomeFeira;

	@NotNull(message = "Codigo de registro da Feira e obrigatorio")
	private String registroFeira;

	public void copyToModel(Feira feira) {
		feira.setNomeFeira(nomeFeira);
	}
}
