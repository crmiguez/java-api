package com.eixox.bmf.fixedlength;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import com.eixox.models.bmf.fixedlength.SerieHistoricaBag;
import com.eixox.usecases.LocalFile;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.bmf.pregao.Import;
import com.eixox.usecases.bmf.pregao.Import.Parameters;
import com.eixox.usecases.bmf.pregao.Import.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.junit.Assert;

public class SerieHistoricaFileImport {

	@Test
	public void importAll() throws FileNotFoundException, IOException {

		final String[] fileNames = new String[] {
				// "C:\\Users\\Rodrigo
				// Portela\\Documents\\BOVESPA\\COTAHIST_A2014.ZIP",
				// "C:\\Users\\Rodrigo
				// Portela\\Documents\\BOVESPA\\COTAHIST_A2015.ZIP",
				// "C:\\Users\\Rodrigo
				// Portela\\Documents\\BOVESPA\\COTAHIST_A2016.ZIP",
				"C:\\SourceCode\\GitHub\\rportela\\bovespa-data\\SerieHistorica\\COTAHIST_A2017.ZIP",
		};

		ObjectMapper mapper = new ObjectMapper();

		UsecaseExecution<Parameters, Result> execution = UsecaseExecution.create(Import.class);
		execution.params = new Parameters();
		for (int i = 0; i < fileNames.length; i++) {
			execution.params.uploaded_file = new LocalFile(fileNames[i]);
			execution.run();

			String st = mapper
					.writer()
					.with(SerializationFeature.INDENT_OUTPUT)
					.without(SerializationFeature.FAIL_ON_EMPTY_BEANS)
					.writeValueAsString(execution);

			System.out.println(st);
		}

	}

	@Test
	public void buildBag() throws IOException {
		SerieHistoricaBag bag = new SerieHistoricaBag("C:\\SourceCode\\GitHub\\rportela\\bovespa-data\\SerieHistorica\\COTAHIST_A2017.ZIP");
		System.out.println(bag.size());
		Assert.assertTrue(bag.size() > 100);
	}

}
