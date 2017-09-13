package com.eixox.cvm.fixedlength;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import com.eixox.models.cvm.CiaAbertaTsv;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.cvm.arquivamento.ConsultaHtmlITRDFPIAN;
import com.eixox.usecases.cvm.arquivamento.ConsultaHtmlITRDFPIAN.Parameters;
import com.eixox.usecases.cvm.arquivamento.ConsultaHtmlITRDFPIAN.ResponseItem;
import com.eixox.usecases.cvm.ciaaberta.SelfUpdate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CiaAbertaTests {

	@Test
	public void testReadFile() throws IOException {

		UsecaseExecution<Void, List<CiaAbertaTsv>> execution = UsecaseExecution.create(SelfUpdate.class);
		execution.run();
		ObjectMapper mapper = new ObjectMapper();
		for (CiaAbertaTsv cia : execution.result)
			System.out.println(mapper.writeValueAsString(cia));

	}

	@Test
	public void testReadConsultaItrDfpIanTests() throws JsonProcessingException {

		UsecaseExecution<Parameters, List<ResponseItem>> execution = UsecaseExecution.create(ConsultaHtmlITRDFPIAN.class);
		execution.params = new Parameters();
		execution.params.data_ini = new GregorianCalendar(2017, 02, 22).getTime();
		execution.params.data_fim = new GregorianCalendar(2017, 02, 28).getTime();
		execution.run();

		ObjectMapper mapper = new ObjectMapper();

		for (ConsultaHtmlITRDFPIAN.ResponseItem item : execution.result)
			System.out.println(mapper.writeValueAsString(item));
	}

	@Test
	public void testSelfUpdate() {
		SelfUpdate usecase = new SelfUpdate();
		UsecaseExecution<Void, List<CiaAbertaTsv>> execution = usecase.execute(null, null);
		System.out.println(execution.result_type);
	}

}
