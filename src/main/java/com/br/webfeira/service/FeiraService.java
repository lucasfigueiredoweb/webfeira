package com.br.webfeira.service;

import com.br.webfeira.exchange.FeiraRequest;
import com.br.webfeira.model.Feira;

public interface FeiraService {

	void updateByCodigoRegistroFeira(String codigoRegistro, FeiraRequest feiraRequest);

	Feira save(FeiraRequest feiraRequest);

	void deleteByCodigoRegistroFeira(String codigoRegistro);
	
	Feira findByNomeFeira(String nomeFeira);
	
	Feira findByRegiao5(String regiao5);
	
	Feira findByDistrito(String nomeDistrito);
	
	Feira findByBairro(String bairro);
}
