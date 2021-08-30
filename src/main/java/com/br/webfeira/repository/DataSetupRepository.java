package com.br.webfeira.repository;

import java.util.List;

import com.br.webfeira.dtos.FeiraDTO;

public interface DataSetupRepository {
	
	public List<FeiraDTO> loadInitialFeiraData();

}
