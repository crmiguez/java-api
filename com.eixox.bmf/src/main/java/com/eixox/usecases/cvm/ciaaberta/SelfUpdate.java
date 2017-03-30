package com.eixox.usecases.cvm.ciaaberta;

import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipInputStream;

import com.eixox.data.text.CsvAspect;
import com.eixox.data.text.TextReader;
import com.eixox.models.bmf.CiaAberta;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

public class SelfUpdate extends UsecaseImplementation<List<CiaAberta>> {

	@Override
	protected boolean authenticate(UsecaseExecution<List<CiaAberta>> execution) {
		return true;
	}

	@Override
	protected void executeFlow(UsecaseExecution<List<CiaAberta>> execution) throws Exception {

		URL url = new URL("http://sistemas.cvm.gov.br/cadastro/SPW_CIA_ABERTA.ZIP");
		CsvAspect<CiaAberta> aspect = new CsvAspect<CiaAberta>(CiaAberta.class);
		aspect.first_row_has_names = true;
		InputStream us = url.openStream();
		ZipInputStream zis = new ZipInputStream(us);
		zis.getNextEntry();
		TextReader<CiaAberta> reader = new TextReader<CiaAberta>(aspect, zis, Charset.forName("iso-8859-1"));

		execution.resultType = UsecaseResultType.SUCCESS;
		execution.result = new ArrayList<CiaAberta>();

		try {
			for (CiaAberta item : reader) {
				if (!CiaAberta.DB.select().where("codigo_cvm", item.codigo_cvm).exists()) {
					CiaAberta.DB.insert(item);
					execution.result.add(item);
				} else
					CiaAberta.DB.update(item);

			}
		} finally {
			reader.close();
			zis.close();
			us.close();
		}

	}

}
