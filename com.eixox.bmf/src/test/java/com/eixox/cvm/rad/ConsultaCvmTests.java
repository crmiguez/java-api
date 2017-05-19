package com.eixox.cvm.rad;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.eixox.models.bmf.Arquivamento;
import com.eixox.usecases.cvm.arquivamento.ConsultaCvm;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConsultaCvmTests {

	@Test
	public void testConsulta() throws IOException, ParserConfigurationException, SAXException, ParseException {

		ConsultaCvm consulta = new ConsultaCvm();

		//consulta.data = new GregorianCalendar(2016, 02, 30).getTime();
		consulta.data = new Date();
		consulta.execute();
		ObjectMapper mapper = new ObjectMapper();
		for (Arquivamento item : consulta.response_items)
			System.out.println(mapper.writeValueAsString(item));

		Assert.assertTrue(consulta.response_items.size() > 0);

	}

}
