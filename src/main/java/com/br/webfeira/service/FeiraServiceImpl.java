package com.br.webfeira.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.br.webfeira.dto.FeiraDTO;
import com.br.webfeira.exchange.FeiraRequest;
import com.br.webfeira.model.Feira;
import com.br.webfeira.repository.DataSetupRepository;
import com.br.webfeira.repository.FeiraRepository;

@Service
public class FeiraServiceImpl implements FeiraService {

	@Autowired
	private FeiraRepository feiraRepository;

	@Autowired
	private DataSetupRepository dataRepository;

	@PostConstruct
	public void saveAllFeiraFromImportedFile() {
		List<Feira> feiras = new ArrayList<Feira>();
		List<FeiraDTO> feirasDTO = dataRepository.loadInitialFeiraData();
		for (FeiraDTO feiraDTO : feirasDTO) {
			Feira feira = FeiraDTO.fromDTO(feiraDTO);
			feiras.add(feira);
		}
		feiraRepository.saveAll(feiras);
	}

	public void updateByCodigoRegistroFeira(String codigoRegistro, FeiraRequest feiraRequest) {
		Feira feira = findByCodigoRegistro(codigoRegistro);
		feiraRequest.copyToModel(feira);
		feiraRepository.save(feira);
	}

	public Feira save(FeiraRequest feiraRequest) {
		Feira feira = new Feira();
		feiraRequest.copyToModel(feira);
		return feiraRepository.save(feira);
	}

	@Transactional
	public void deleteByCodigoRegistroFeira(String codigoRegistro) {
		feiraRepository.deleteByCodigoRegistroFeira(codigoRegistro);
	}

	public Feira findByCodigoRegistro(String codigoRegistro) {
		Optional<Feira> FeiraOptional = feiraRepository.findByCodigoRegistroFeira(codigoRegistro);
		return FeiraOptional.orElseThrow(() -> new com.br.webfeira.exceptions.ResourceNotFoundException(
				"Feira nao Encontrada com esse Codigo de Registro" + "Codigo de Registro: " + codigoRegistro));
	}

	public Page<Feira> findByNomeFeira(String nomeFeira, Pageable page) {
		return feiraRepository.findByNomeFeira(nomeFeira, page);
	}

	public Page<Feira> findByMunicipio_Regiao5(String regiao5, Pageable page) {
		return feiraRepository.findByMunicipio_Regiao5(regiao5, page);
	}

	public Page<Feira> findByMunicipio_NomeDistrito(String nomeDistrito, Pageable page) {
		return feiraRepository.findByMunicipio_NomeDistrito(nomeDistrito, page);
	}

	public Page<Feira> findByEndereco_Bairro(String bairro, Pageable page) {
		return feiraRepository.findByEndereco_Bairro(bairro, page);
	}
}
