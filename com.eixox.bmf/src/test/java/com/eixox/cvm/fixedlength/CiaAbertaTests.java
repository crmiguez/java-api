package com.eixox.cvm.fixedlength;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.eixox.models.cvm.fixedlength.CiaAbertaTsv;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.cvm.arquivamento.ConsultaItrDfpIan;
import com.eixox.usecases.cvm.ciaaberta.SelfUpdate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CiaAbertaTests {

	@Test
	public void testReadFile() throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		for (CiaAbertaTsv cia : new SelfUpdate().execute(null, null, (UUID) null).result)
			System.out.println(mapper.writeValueAsString(cia));

	}

	@Test
	public void testReadConsultaItrDfpIanTests() throws JsonProcessingException {

		ConsultaItrDfpIan usecase = new ConsultaItrDfpIan();
		usecase.data_ini = new GregorianCalendar(2017, 02, 22).getTime();
		usecase.data_fim = new GregorianCalendar(2017, 02, 28).getTime();

		ObjectMapper mapper = new ObjectMapper();

		UsecaseExecution<List<ConsultaItrDfpIan.ResponseItem>> execute = usecase.execute(null, null, (UUID) null);
		for (ConsultaItrDfpIan.ResponseItem item : execute.result)
			System.out.println(mapper.writeValueAsString(item));
	}

	@Test
	public void testSelfUpdate() {
		SelfUpdate usecase = new SelfUpdate();
		UsecaseExecution<List<CiaAbertaTsv>> execution = usecase.execute("127.0.0.1", "junit", (UUID) null);
		System.out.println(execution.resultType + ": " + execution.message);
	}

}
