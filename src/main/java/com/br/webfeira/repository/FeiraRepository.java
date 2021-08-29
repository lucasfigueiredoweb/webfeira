package com.br.webfeira.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.webfeira.model.Feira;

@Repository
public interface FeiraRepository extends JpaRepository<Feira, UUID> {
	
	Optional<Feira> findById(UUID id);
	
	Optional<Feira> findByCodigoRegistro(String codigoRegistro);
	
	void deleteByCodigoRegistro(String codigoRegistro);
	
	Feira findByNomeFeira(String nomeFeira);
	
	Feira findByRegiao5(String regiao5);
	
	Feira findByDistrito(String nomeDistrito);
	
	Feira findByBairro(String bairro);
}
