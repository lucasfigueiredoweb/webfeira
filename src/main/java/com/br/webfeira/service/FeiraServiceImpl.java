package com.br.webfeira.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.webfeira.dto.FeiraDTO;
import com.br.webfeira.exchange.FeiraRequest;
import com.br.webfeira.model.Feira;
import com.br.webfeira.repository.DataSetup;
import com.br.webfeira.repository.DataSetupRepository;
import com.br.webfeira.repository.FeiraRepository;

@Service
public class FeiraServiceImpl implements FeiraService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FeiraServiceImpl.class);

	@Autowired
	private FeiraRepository feiraRepository;
	
	@Autowired
	private DataSetupRepository dataRepository;
	
	public void saveAllFeiraFromImportedFile() {
		List<Feira> feiras = new ArrayList<Feira>();
		List<FeiraDTO> feirasDTO = dataRepository.loadInitialFeiraData();
		for (FeiraDTO feiraDTO : feirasDTO) {
			Feira feira = FeiraDTO.fromDTO(feiraDTO);
			feiras.add(feira);
			LOGGER.info("FEIRA ADICIONADO A LISTA" + feiraDTO);
		}
		feiraRepository.saveAll(feiras);
	}

	public void updateByCodigoRegistroFeira(String codigoRegistro, FeiraRequest feiraRequest) {
		Feira feira = getFeiraByCodigoRegistro(codigoRegistro);
		feiraRequest.copyToModel(feira);
		feiraRepository.save(feira);
	}

	public Feira save(FeiraRequest feiraRequest) {
		Feira feira = new Feira();
		feiraRequest.copyToModel(feira);
		return feiraRepository.save(feira);
	}

	public void deleteByCodigoRegistroFeira(String codigoRegistro) {
		feiraRepository.deleteByCodigoRegistroFeira(codigoRegistro);
	}

	private Feira getFeiraByCodigoRegistro(String codigoRegistro) {
		Optional<Feira> FeiraOptional = feiraRepository.findByCodigoRegistroFeira(codigoRegistro);
		return FeiraOptional.orElseThrow(
				() -> new com.br.webfeira.exceptions.ResourceNotFoundException("Feira nao Encontrada com esse UUID"));
	}

	public Feira findByNomeFeira(String nomeFeira) {
		return feiraRepository.findByNomeFeira(nomeFeira);
	}

	public Feira findByRegiao5(String regiao5) {
		return feiraRepository.findByMunicipio_Regiao5(regiao5);
	}

	public Feira findByDistrito(String nomeDistrito) {
		return feiraRepository.findByMunicipio_CodigoDistrito(nomeDistrito);
	}

	public Feira findByBairro(String bairro) {
		return feiraRepository.findByEndereco_Bairro(bairro);
	}

}
