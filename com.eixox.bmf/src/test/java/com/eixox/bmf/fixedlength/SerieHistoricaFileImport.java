package com.eixox.bmf.fixedlength;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.http.Part;

import org.junit.Test;

import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.bmf.pregao.Import;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

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
				"C:\\Users\\Rodrigo Portela\\Documents\\BOVESPA\\COTAHIST_A2017.ZIP",
		};

		ObjectMapper mapper = new ObjectMapper();

		for (int i = 0; i < fileNames.length; i++) {
			Import usecase = new Import();
			final int index = i;
			usecase.uploaded_file = new Part() {

				public void write(String fileName) throws IOException {
					throw new RuntimeException("Can't write");
				}

				public String getSubmittedFileName() {
					return fileNames[index];
				}

				public long getSize() {
					try {
						return Files.size(Paths.get(fileNames[index]));
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}

				public String getName() {
					return "uploaded_file";
				}

				public InputStream getInputStream() throws IOException {
					return new FileInputStream(fileNames[index]);
				}

				public Collection<String> getHeaders(String name) {
					return null;
				}

				public Collection<String> getHeaderNames() {
					return null;
				}

				public String getHeader(String name) {
					return null;
				}

				public String getContentType() {
					return "application/octet-stream";
				}

				public void delete() throws IOException {
					// can't delete
				}
			};

			UsecaseExecution<Import> execution = usecase.execute("0.0.0.0", "Junit test", (UUID) null);
			String st = mapper
					.writer()
					.with(SerializationFeature.INDENT_OUTPUT)
					.without(SerializationFeature.FAIL_ON_EMPTY_BEANS)
					.writeValueAsString(execution);

			System.out.println(st);
		}

	}

}
