package com.br.webfeira.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.webfeira.exchange.FeiraRequest;
import com.br.webfeira.model.Feira;
import com.br.webfeira.repository.FeiraRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FeiraServiceImpl implements FeiraService {

	private FeiraRepository repository;

	public void updateByCodigoRegistro(String codigoRegistro, FeiraRequest feiraRequest) {
		Feira feira = getFeiraByCodigoRegistro(codigoRegistro);
		feiraRequest.copyToModel(feira);
		repository.save(feira);
	}

	public Feira save(FeiraRequest feiraRequest) {
		Feira feira = new Feira();
		feiraRequest.copyToModel(feira);
		return repository.save(feira);
	}

	public void deleteByCodigoRegistro(String codigoRegistro) {
		repository.deleteByCodigoRegistro(codigoRegistro);
	}

	private Feira getFeiraByCodigoRegistro(String codigoRegistro) {
		Optional<Feira> FeiraOptional = repository.findByCodigoRegistro(codigoRegistro);
		return FeiraOptional.orElseThrow(
				() -> new com.br.webfeira.exceptions.ResourceNotFoundException("Feira nao Encontrada com esse UUID"));
	}

	public Feira findByNomeFeira(String nomeFeira) {
		return repository.findByNomeFeira(nomeFeira);
	}

	public Feira findByRegiao5(String regiao5) {
		return repository.findByRegiao5(regiao5);
	}

	public Feira findByDistrito(String nomeDistrito) {
		return repository.findByDistrito(nomeDistrito);
	}

	public Feira findByBairro(String bairro) {
		return repository.findByBairro(bairro);
	}

}
