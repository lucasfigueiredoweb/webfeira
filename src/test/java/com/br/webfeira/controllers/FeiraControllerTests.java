package com.br.webfeira.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.br.webfeira.exchange.FeiraRequest;
import com.br.webfeira.models.Endereco;
import com.br.webfeira.models.Feira;
import com.br.webfeira.models.Localizacao;
import com.br.webfeira.models.Municipio;
import com.br.webfeira.models.SetorCensitario;
import com.br.webfeira.services.FeiraService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@WebMvcTest(controllers = FeiraController.class)
class FeiraControllerTests {

	@MockBean
	private FeiraService feiraService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void shouldCreateFeira() throws Exception {
		final FeiraRequest feira = fillFeiraRequest();
		final String feiraString = objectMapper.writeValueAsString(feira);
		mockMvc.perform(post("/feira/")
			.contentType("application/json")
			.content(feiraString))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(status().isCreated());
	}

	private FeiraRequest fillFeiraRequest(){
		FeiraRequest feira = new FeiraRequest();

		feira.setNomeFeira("VILA FORMOSA DA NOITE");
		feira.setRegistroFeira("8888-8");

		feira.setLongitude("-46486026");
		feira.setLatitude("-23593747");

		feira.setCodigoCensitario("355030885000091");
		feira.setAreaCensitario("3550308005040");

		feira.setCodigoDistrito("87");
		feira.setNomeDistrito("VILA FORMOSA");
		feira.setCodigoPrefeitura("26");
		feira.setNomePrefeitura("ARICANDUVA-FORMOSA-CARRAO");
		feira.setRegiao5("Leste");
		feira.setRegiao8("Leste 1");

		feira.setLogradouro("RUA MARAGOJIPE");
		feira.setNumero("S/N");
		feira.setBairro("VL FORMOSA");
		feira.setReferencia("TV RUA PRETORIA");
		return feira;
	}
}
