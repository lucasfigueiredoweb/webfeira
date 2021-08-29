package com.br.webfeira.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.webfeira.model.Feira;

@Repository
public interface FeiraRepository extends CrudRepository<Feira, UUID> {
	
	Optional<Feira> findById(UUID id);
	
	Optional<Feira> findByCodigoRegistroFeira(String codigoRegistro);
	
	void deleteByCodigoRegistroFeira(String codigoRegistro);
	
	Feira findByNomeFeira(String nomeFeira);
	
	Feira findByMunicipio_Regiao5(String regiao5);
	
	Feira findByMunicipio_CodigoDistrito(String nomeDistrito);
	
	Feira findByEndereco_Bairro(String bairro);
}
