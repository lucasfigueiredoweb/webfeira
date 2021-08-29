package com.br.webfeira.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.br.webfeira.service.FeiraService;
import com.br.webfeira.utils.MessageConstants;

@RestController
@RequestMapping("/feira")
public class FeiraController {

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
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new FeiraResponse(MessageConstants.ERRO_GENERICO_DO_SISTEMA));
		}

		return ResponseEntity.accepted().body(feiraDTO);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Object> update(@PathVariable String codigoRegistro,
			@RequestBody @Valid FeiraRequest feiraRequest) {
		try {
			feiraService.updateByCodigoRegistroFeira(codigoRegistro, feiraRequest);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new FeiraResponse(MessageConstants.FEIRA_NAO_ENCONTRADA));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new FeiraResponse(MessageConstants.ERRO_GENERICO_DO_SISTEMA));
		}
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Object> delete(@PathVariable String codigoRegistro) {
		try {
			feiraService.deleteByCodigoRegistroFeira(codigoRegistro);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new FeiraResponse(MessageConstants.FEIRA_NAO_ENCONTRADA));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new FeiraResponse(MessageConstants.ERRO_GENERICO_DO_SISTEMA));
		}
		return ResponseEntity.noContent().build();
	}

	@GetMapping(path = "/busca/{nomeFeira}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> findByNomeFeira(@PathVariable String nomeFeira) {
		FeiraDTO feiraDTO = new FeiraDTO();
		try {
			FeiraDTO.toDTO(feiraService.findByNomeFeira(nomeFeira));
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new FeiraResponse(MessageConstants.FEIRA_NAO_ENCONTRADA));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new FeiraResponse(MessageConstants.ERRO_GENERICO_DO_SISTEMA));
		}
		return ResponseEntity.accepted().body(feiraDTO);
	}

	@GetMapping(path = "/busca/{regiao5}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> findByRegiao5(@PathVariable String regiao5) {
		FeiraDTO feiraDTO = new FeiraDTO();
		try {
			FeiraDTO.toDTO(feiraService.findByRegiao5(regiao5));
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new FeiraResponse(MessageConstants.FEIRA_NAO_ENCONTRADA));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new FeiraResponse(MessageConstants.ERRO_GENERICO_DO_SISTEMA));
		}
		return ResponseEntity.accepted().body(feiraDTO);
	}

	@GetMapping(path = "/busca/{distrito}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> findByDistrito(@PathVariable String nomeDistrito) {
		FeiraDTO feiraDTO = new FeiraDTO();
		try {
			FeiraDTO.toDTO(feiraService.findByDistrito(nomeDistrito));
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new FeiraResponse(MessageConstants.FEIRA_NAO_ENCONTRADA));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new FeiraResponse(MessageConstants.ERRO_GENERICO_DO_SISTEMA));
		}
		return ResponseEntity.accepted().body(feiraDTO);
	}

	@GetMapping(path = "/busca/{bairro}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> findByBairro(@PathVariable String bairro) {
		FeiraDTO feiraDTO = new FeiraDTO();
		try {
			FeiraDTO.toDTO(feiraService.findByBairro(bairro));
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new FeiraResponse(MessageConstants.FEIRA_NAO_ENCONTRADA));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new FeiraResponse(MessageConstants.ERRO_GENERICO_DO_SISTEMA));
		}
		return ResponseEntity.accepted().body(feiraDTO);
	}

}
