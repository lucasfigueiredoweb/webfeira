package com.br.webfeira.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class CsvUtils {

	private static final CsvMapper MAPPER = new CsvMapper().enable(CsvParser.Feature.SKIP_EMPTY_LINES);

	public static <T> List<T> read(Class<T> clazz, InputStream stream) throws IOException {
		MAPPER.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		CsvSchema schema = MAPPER.schemaFor(clazz).withHeader().withColumnSeparator(',').withColumnReordering(true);
		ObjectReader reader = MAPPER.readerFor(clazz).with(schema);
		return reader.<T>readValues(stream).readAll();
	}
}
