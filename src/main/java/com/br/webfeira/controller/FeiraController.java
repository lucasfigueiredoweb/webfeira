package com.br.webfeira.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.webfeira.dto.FeiraDTO;
import com.br.webfeira.exceptions.ResourceNotFoundException;
import com.br.webfeira.exchange.FeiraRequest;
import com.br.webfeira.exchange.FeiraResponse;
import com.br.webfeira.model.Feira;
import com.br.webfeira.service.FeiraService;
import com.br.webfeira.utils.MessageConstants;

@RestController
@RequestMapping("/feira")
public class FeiraController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FeiraController.class);
	private static final int DEFAULT_PAGE_SIZE = 10;

	@Autowired
	private FeiraService feiraService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> create(@RequestBody @Valid FeiraRequest feiraRequest) {
		FeiraDTO feiraDTO = new FeiraDTO();
		try {
			feiraDTO = FeiraDTO.toDTO(feiraService.save(feiraRequest));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new FeiraResponse(MessageConstants.ERRO_SALVAR_FEIRA));
		} catch (Exception e) {
			LOGGER.error("Error ao Cadastrar a Feira", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new FeiraResponse(MessageConstants.ERRO_GENERICO_DO_SISTEMA));
		}
		LOGGER.info("Feira Criada com Sucesso");
		return ResponseEntity.accepted().body(feiraDTO);
	}

	@PutMapping("/{codigoRegistro}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Object> update(@PathVariable String codigoRegistro,
			@RequestBody @Valid FeiraRequest feiraRequest) {
		Feira feira = feiraService.findByCodigoRegistro(codigoRegistro);
		feiraRequest.copyToModel(feira);
		try {
			feiraService.updateByCodigoRegistroFeira(codigoRegistro, feiraRequest);
		} catch (ResourceNotFoundException e) {
			LOGGER.error("Feira nao Encontrada para atualizacao dos dados", e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new FeiraResponse(MessageConstants.FEIRA_NAO_ENCONTRADA));
		} catch (Exception e) {
			LOGGER.error("Error ao Atualizar a Feira", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new FeiraResponse(MessageConstants.ERRO_GENERICO_DO_SISTEMA));
		}
		LOGGER.info("Feira Atualizada com Sucesso");
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{codigoRegistro}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Object> delete(@PathVariable String codigoRegistro) {
		try {
			feiraService.deleteByCodigoRegistroFeira(codigoRegistro);
		} catch (ResourceNotFoundException e) {
			LOGGER.error("Feira nao Encontrada para atualizacao dos dados", e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new FeiraResponse(MessageConstants.FEIRA_NAO_ENCONTRADA));
		} catch (Exception e) {
			LOGGER.error("Error ao Remover a Feira", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new FeiraResponse(MessageConstants.ERRO_GENERICO_DO_SISTEMA));
		}
		LOGGER.info("Feira Removida com Sucesso");
		return ResponseEntity.noContent().build();
	}

	@GetMapping(path = "/buscaNomeFeira/{nomeFeira}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> findByNomeFeira(@PathVariable String nomeFeira,
			@PageableDefault(size = DEFAULT_PAGE_SIZE) Pageable pageable) {
		List<FeiraDTO> feirasDTO = new ArrayList<FeiraDTO>();
		try {
			feirasDTO = FeiraDTO.toDTOList(feiraService.findByNomeFeira(nomeFeira, pageable).getContent());
		} catch (ResourceNotFoundException e) {
			LOGGER.error("Feira nao Encontrada", e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new FeiraResponse(MessageConstants.FEIRA_NAO_ENCONTRADA));
		} catch (Exception e) {
			LOGGER.error("Feira nao Encontrada", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new FeiraResponse(MessageConstants.ERRO_GENERICO_DO_SISTEMA));
		}
		LOGGER.info("Busca por Nome da Feira realizada com Sucesso");
		return ResponseEntity.accepted().body(feirasDTO);
	}

	@GetMapping(path = "/buscaPorRegiao5/{regiao5}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> findByRegiao5(@PathVariable String regiao5,
			@PageableDefault(size = DEFAULT_PAGE_SIZE) Pageable pageable) {
		List<FeiraDTO> feirasDTO = new ArrayList<FeiraDTO>();
		try {
			feirasDTO = FeiraDTO.toDTOList(feiraService.findByMunicipio_Regiao5(regiao5, pageable).getContent());
		} catch (ResourceNotFoundException e) {
			LOGGER.error("Feira nao Encontrada", e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new FeiraResponse(MessageConstants.FEIRA_NAO_ENCONTRADA));
		} catch (Exception e) {
			LOGGER.error(MessageConstants.ERRO_GENERICO_DO_SISTEMA, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new FeiraResponse(MessageConstants.ERRO_GENERICO_DO_SISTEMA));
		}
		LOGGER.info("Busca por Regiao 5 realizada com Sucesso");
		return ResponseEntity.accepted().body(feirasDTO);
	}

	@GetMapping(path = "/buscaPorDistrito/{nomeDistrito}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> findByDistrito(@PathVariable String nomeDistrito,
			@PageableDefault(size = DEFAULT_PAGE_SIZE) Pageable pageable) {
		List<FeiraDTO> feirasDTO = new ArrayList<FeiraDTO>();
		try {
			feirasDTO = FeiraDTO
					.toDTOList(feiraService.findByMunicipio_NomeDistrito(nomeDistrito, pageable).getContent());
		} catch (ResourceNotFoundException e) {
			LOGGER.error("Feira nao Encontrada", e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new FeiraResponse(MessageConstants.FEIRA_NAO_ENCONTRADA));
		} catch (Exception e) {
			LOGGER.error(MessageConstants.ERRO_GENERICO_DO_SISTEMA, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new FeiraResponse(MessageConstants.ERRO_GENERICO_DO_SISTEMA));
		}
		LOGGER.info("Busca por Distrito realizada com Sucesso");
		return ResponseEntity.accepted().body(feirasDTO);
	}

	@GetMapping(path = "/buscaPorBairro/{bairro}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> findByBairro(@PathVariable String bairro,
			@PageableDefault(size = DEFAULT_PAGE_SIZE) Pageable pageable) {
		List<FeiraDTO> feirasDTO = new ArrayList<FeiraDTO>();
		try {
			feirasDTO = FeiraDTO.toDTOList(feiraService.findByEndereco_Bairro(bairro, pageable).getContent());
		} catch (ResourceNotFoundException e) {
			LOGGER.error("Feira nao Encontrada", e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new FeiraResponse(MessageConstants.FEIRA_NAO_ENCONTRADA));
		} catch (Exception e) {
			LOGGER.error(MessageConstants.ERRO_GENERICO_DO_SISTEMA, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new FeiraResponse(MessageConstants.ERRO_GENERICO_DO_SISTEMA));
		}
		LOGGER.info("Busca por Bairro realizada com Sucesso");
		return ResponseEntity.accepted().body(feirasDTO);
	}

}
