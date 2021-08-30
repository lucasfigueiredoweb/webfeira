package com.br.webfeira.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.br.webfeira.models.Feira;

public interface FeiraRepository extends CrudRepository<Feira, UUID> {

	Optional<Feira> findById(UUID id);

	Optional<Feira> findByCodigoRegistroFeira(String codigoRegistro);

	void deleteByCodigoRegistroFeira(String codigoRegistro);

	Page<Feira> findByNomeFeira(String nomeFeira, Pageable pageable);

	Page<Feira> findByMunicipio_Regiao5(String regiao5, Pageable pageable);

	Page<Feira> findByMunicipio_NomeDistrito(String nomeDistrito, Pageable pageable);

	Page<Feira> findByEndereco_Bairro(String bairro, Pageable pageable);
}
