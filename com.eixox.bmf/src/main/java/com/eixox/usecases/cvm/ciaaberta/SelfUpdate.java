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
import com.eixox.models.bmf.CiaAbertaEndereco;
import com.eixox.models.bmf.CiaAbertaResponsavel;
import com.eixox.models.cvm.fixedlength.CiaAbertaTsv;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

public class SelfUpdate extends UsecaseImplementation<List<CiaAbertaTsv>> {

	@Override
	protected boolean authenticate(UsecaseExecution<List<CiaAbertaTsv>> execution) {
		return true;
	}

	@Override
	protected void executeFlow(UsecaseExecution<List<CiaAbertaTsv>> execution) throws Exception {

		URL url = new URL("http://sistemas.cvm.gov.br/cadastro/SPW_CIA_ABERTA.ZIP");
		CsvAspect<CiaAbertaTsv> aspect = new CsvAspect<CiaAbertaTsv>(CiaAbertaTsv.class);
		aspect.first_row_has_names = true;
		InputStream us = url.openStream();
		ZipInputStream zis = new ZipInputStream(us);
		zis.getNextEntry();
		TextReader<CiaAbertaTsv> reader = new TextReader<CiaAbertaTsv>(aspect, zis, Charset.forName("iso-8859-1"));

		execution.resultType = UsecaseResultType.SUCCESS;
		execution.result = new ArrayList<CiaAbertaTsv>();

		try {
			for (CiaAbertaTsv item : reader) {

				CiaAberta cia = new CiaAberta();
				cia.codigo_cvm = item.codigo_cvm;
				cia.auditor_cnpj = item.auditor_cnpj;
				cia.auditor_nome = item.auditor_nome;
				cia.cancelamento_data = item.cancelamento_data;
				cia.cancelamento_motivo = item.cancelamento_motivo;
				cia.categoria_data = item.categoria_data;
				cia.categoria_nome = item.categoria_nome;
				cia.cnpj = item.cnpj;
				cia.constituicao_data = item.constituicao_data;
				cia.fantasia = item.fantasia;
				cia.razao_social = item.razao_social;
				cia.registro_data = item.registro_data;
				cia.setor_atividade = item.setor_atividade;
				cia.situacao_nome = item.situacao_nome;
				cia.situacao_data = item.situacao_data;
				cia.situacao_emissor_data = item.situacao_emissor_data;
				cia.situacao_emissor_nome = item.situacao_emissor_nome;
				CiaAberta.DB.save(cia);

				if (item.endereco_logradouro != null && !item.endereco_logradouro.isEmpty()) {
					CiaAbertaEndereco end = new CiaAbertaEndereco();
					end.codigo_cvm = item.codigo_cvm;
					end.bairro = item.endereco_bairro;
					end.cep = item.endereco_cep;
					end.cidade = item.endereco_cidade;
					end.complemento = item.endereco_complemento;
					end.email = item.email;
					end.fax = item.fax;
					end.label = item.endereco_tipo == null || item.endereco_tipo.isEmpty() ? "Sede" : "";
					end.logradouro = item.endereco_logradouro;
					end.pais = item.endereco_pais;
					end.telefone = item.telefone;
					end.uf = item.endereco_uf;
					CiaAbertaEndereco.DB.save(end);
				}

				if (item.responsavel_nome != null && !item.responsavel_nome.isEmpty()) {
					CiaAbertaResponsavel resp = new CiaAbertaResponsavel();
					resp.codigo_cvm = item.codigo_cvm;
					resp.bairro = item.responsavel_endereco_bairro;
					resp.cep = item.responsavel_endereco_cep;
					resp.cidade = item.responsavel_endereco_cidade;
					resp.complemento = item.responsavel_endereco_complemento;
					resp.email = item.responsavel_email;
					resp.fax = item.responsavel_fax;
					resp.inicio = item.responsavel_inicio;
					resp.logradouro = item.responsavel_endereco_logradouro;
					resp.nome = item.responsavel_nome;
					resp.pais = item.responsavel_endereco_pais;
					resp.telefone = item.responsavel_telefone;
					resp.tipo = item.responsavel_tipo == null || item.responsavel_tipo.isEmpty() ? "Responsável" : item.responsavel_tipo;
					resp.uf = item.responsavel_endereco_uf;
					CiaAbertaResponsavel.DB.save(resp);
				}

				execution.result.add(item);

			}
		} finally {
			reader.close();
			zis.close();
			us.close();
		}

	}

}
