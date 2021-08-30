package com.br.webfeira.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.br.webfeira.exchange.FeiraRequest;
import com.br.webfeira.models.Feira;

public interface FeiraService {

	void updateByCodigoRegistroFeira(String codigoRegistro, FeiraRequest feiraRequest);

	Feira save(FeiraRequest feiraRequest);

	void deleteByCodigoRegistroFeira(String codigoRegistro);
		
	Feira findByCodigoRegistro(String codigoRegistro);
	
	Page<Feira> findByNomeFeira(String nomeFeira, Pageable pageable);
	
	Page<Feira> findByMunicipio_Regiao5(String regiao5, Pageable pageable);
	
	Page<Feira> findByMunicipio_NomeDistrito(String nomeDistrito, Pageable pageable);
	
	Page<Feira> findByEndereco_Bairro(String bairro, Pageable pageable);
}
