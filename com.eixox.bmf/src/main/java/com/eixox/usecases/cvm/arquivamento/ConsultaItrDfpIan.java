package com.eixox.usecases.cvm.arquivamento;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.eixox.Control;
import com.eixox.HttpClient;
import com.eixox.Pair;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

public class ConsultaItrDfpIan extends UsecaseImplementation<List<ConsultaItrDfpIan.ResponseItem>> {

	private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	protected boolean authenticate(UsecaseExecution<List<ResponseItem>> execution) {
		return true;
	}

	@Control
	public Date data_ini;

	@Control
	public Date data_fim;

	@SuppressWarnings("unchecked")
	@Override
	protected void executeFlow(UsecaseExecution<List<ResponseItem>> execution) throws Exception {

		if (data_fim == null)
			data_fim = new Date();

		if (data_ini == null)
			data_ini = new Date();

		HttpClient client = new HttpClient();

		String st_data_ini = dateFormat.format(data_ini);
		String st_data_fim = dateFormat.format(data_fim);

		client.open("POST", "http://siteempresas.bovespa.com.br/consbov/ListaEmpresaPeriodoItr.asp?busca=data&site=C&pregao=",
				new Pair<String, String>("hdnPagina", "Empresa"),
				new Pair<String, String>("ccvm", ""),
				new Pair<String, String>("razao", ""),
				new Pair<String, String>("mercado", ""),
				new Pair<String, String>("TipoArquivo", ""),
				new Pair<String, String>("fechaI", st_data_ini),
				new Pair<String, String>("fechaV", st_data_fim));

		String remote_content = client.downloadString();
		client.close();

		// debug: System.out.println(remote_content);

		Iterator<ResponseItem> jsMatches = findCompanies(remote_content);
		execution.result = new ArrayList<ResponseItem>();
		while (jsMatches.hasNext())
			execution.result.add(jsMatches.next());

		execution.resultType = UsecaseResultType.SUCCESS;

	}

	private Iterator<ResponseItem> findCompanies(final String content) {
		return new Iterator<ResponseItem>() {

			private int offset = 0;
			private String lookfor = "<td><IMG SRC=\".\\images\\simbolo.gif\"><font face=\"Arial\" size=\"2\" class=\"text\"><a href=\"javascript:exibedocumentos(";
			private String endswith = ");\">";
			private ResponseItem item;

			public boolean hasNext() {
				this.item = null;
				int ipos = content.indexOf(lookfor, offset);
				if (ipos < 0)
					return false;
				ipos = ipos + lookfor.length();
				int epos = content.indexOf(endswith, ipos);
				if (epos < 0)
					epos = content.length();

				String match = content.substring(ipos, epos);
				String[] spl = match.split("'");
				this.item = new ResponseItem();
				item.razao_social = spl[1];
				item.nome_pregao = spl[3];
				item.codigo_cvm = Integer.parseInt(spl[5]);
				item.mercado = Integer.parseInt(spl[7]);
				item.cnpj = Long.parseLong(spl[9]);
				offset = epos;
				return true;
			}

			public ResponseItem next() {
				return this.item;
			}
		};
	}

	public static class ResponseItem {

		public String razao_social;

		public String nome_pregao;

		public int codigo_cvm;

		public int mercado;

		public long cnpj;

	}
}
