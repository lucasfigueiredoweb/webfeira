package com.br.webfeira.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.br.webfeira.exchange.FeiraRequest;
import com.br.webfeira.services.FeiraServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@ActiveProfiles("test")
@WebMvcTest(controllers = FeiraController.class)
class FeiraControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@SpyBean
	private FeiraServiceImpl feiraService;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void shouldCreateFeira() throws Exception {
		final FeiraRequest feiraRequest = fillFeiraRequest();
		final String feiraString = objectMapper.writeValueAsString(feiraRequest);

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
