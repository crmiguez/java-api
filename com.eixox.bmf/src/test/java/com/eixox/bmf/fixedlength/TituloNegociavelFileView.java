package com.eixox.bmf.fixedlength;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import com.eixox.models.bmf.fixedlength.TituloNegociavel;
import com.eixox.models.bmf.fixedlength.TituloNegociavelCia;
import com.eixox.models.bmf.fixedlength.TituloNegociavelHeader;
import com.eixox.models.bmf.fixedlength.TituloNegociavelParser;
import com.eixox.models.bmf.fixedlength.TituloNegociavelTrailer;
import com.eixox.models.bmf.fixedlength.TituloNegociavelVisitor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class TituloNegociavelFileView {

	@Test
	public void testReadFile() throws FileNotFoundException, IOException {

		TituloNegociavelParser parser = new TituloNegociavelParser();

		parser.acceptZip("C:\\Users\\Rodrigo Portela\\Downloads\\CVM\\Titulos_Negociaveis.zip", new TituloNegociavelVisitor() {

			private final ObjectWriter writer = new ObjectMapper().writerWithDefaultPrettyPrinter();
			
			public void visitTrailer(TituloNegociavelTrailer trailer) {
				try {
					System.out.println(writer.writeValueAsString(trailer));
				} catch (JsonProcessingException e) {
					throw new RuntimeException(e);
				}
			}

			public void visitItem(TituloNegociavel titulo) {
				try {
					System.out.println(writer.writeValueAsString(titulo));
				} catch (JsonProcessingException e) {
					throw new RuntimeException(e);
				}

			}

			public void visitHeader(TituloNegociavelHeader header) {
				try {
					System.out.println(writer.writeValueAsString(header));
				} catch (JsonProcessingException e) {
					throw new RuntimeException(e);
				}
			}

			public void visitCia(TituloNegociavelCia cia) {
				try {
					System.out.println(writer.writeValueAsString(cia));
				} catch (JsonProcessingException e) {
					throw new RuntimeException(e);
				}
			}
		});

	}
}
