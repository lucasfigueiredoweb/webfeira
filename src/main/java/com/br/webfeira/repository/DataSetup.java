package com.br.webfeira.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.br.webfeira.dto.FeiraDTO;
import com.br.webfeira.utils.CsvUtils;
import com.br.webfeira.utils.MessageConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Repository
public class DataSetup implements DataSetupRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataSetup.class);

	public List<FeiraDTO> loadInitialFeiraData() {
		LOGGER.info("Iniciando importacao do arquivo de feiras CSV");
		Resource resource = new ClassPathResource(MessageConstants.CSV_FILE_NAME);
		List<FeiraDTO> feiras = new ArrayList<FeiraDTO>();
		try {
			InputStream inFile = resource.getInputStream();
			feiras = CsvUtils.read(FeiraDTO.class, inFile);
		} catch (IOException e) {
			LOGGER.error("Falha ao importar arquivo CSV", e);
			e.printStackTrace();
		}
		LOGGER.info("Importacao concluida com sucesso");
		return feiras;
	}
}
