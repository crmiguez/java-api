package com.eixox.bmf.fixedlength;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import com.eixox.models.bmf.fixedlength.SerieHistorica;
import com.eixox.models.bmf.fixedlength.SerieHistoricaHeader;
import com.eixox.models.bmf.fixedlength.SerieHistoricaParser;
import com.eixox.models.bmf.fixedlength.SerieHistoricaTrailer;
import com.eixox.models.bmf.fixedlength.SerieHistoricaVisitor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerieHistoricaTests {

	@Test
	public void testSerieHistorica() throws FileNotFoundException, IOException {
		String fileName = "C:\\Users\\Rodrigo Portela\\Documents\\BOVESPA\\BOT\\Processado\\COTAHIST_D18042016.TXT";
		SerieHistoricaParser serieHistorica = new SerieHistoricaParser();

		serieHistorica.accept(fileName, new SerieHistoricaVisitor() {

			private ObjectMapper mapper = new ObjectMapper();

			public void visitTrailer(SerieHistoricaTrailer trailer) {
				try {
					System.out.println(mapper.writeValueAsString(trailer));
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			}

			public void visitItem(SerieHistorica item) {
				try {
					System.out.println(mapper.writeValueAsString(item));
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}

			}

			public void visitHeader(SerieHistoricaHeader header) {
				try {
					System.out.println(mapper.writeValueAsString(header));
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Test
	public void testSerieHistoricaZip() throws FileNotFoundException, IOException {
		String fileName = "C:\\Users\\Rodrigo Portela\\Documents\\BOVESPA\\COTAHIST_D04042016.ZIP";
		SerieHistoricaParser serieHistorica = new SerieHistoricaParser();

		serieHistorica.acceptZip(fileName, new SerieHistoricaVisitor() {

			private ObjectMapper mapper = new ObjectMapper();

			public void visitTrailer(SerieHistoricaTrailer trailer) {
				try {
					System.out.println(mapper.writeValueAsString(trailer));
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			}

			public void visitItem(SerieHistorica item) {
				try {
					System.out.println(mapper.writeValueAsString(item));
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}

			}

			public void visitHeader(SerieHistoricaHeader header) {
				try {
					System.out.println(mapper.writeValueAsString(header));
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
