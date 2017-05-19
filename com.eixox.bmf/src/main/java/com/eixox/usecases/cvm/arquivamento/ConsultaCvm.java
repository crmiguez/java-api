package com.eixox.usecases.cvm.arquivamento;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.eixox.HttpClient;
import com.eixox.UUIDHelper;
import com.eixox.models.bmf.Arquivamento;
import com.eixox.models.bmf.ArquivamentoAssunto;

public class ConsultaCvm {

	public String login = "397dwlmz";

	public String senha = "mzit12345";

	public Date data = new Date();

	public String tipo = "TODOS";

	public boolean incluirAssuntoIPE = true;

	public ArrayList<Arquivamento> response_items;

	public void execute() throws IOException, ParserConfigurationException, SAXException, ParseException {

		LinkedHashMap<String, String> postData = new LinkedHashMap<String, String>();
		postData.put("txtLogin", login);
		postData.put("txtSenha", senha);
		postData.put("txtData", new SimpleDateFormat("dd/MM/yyyy").format(data));
		postData.put("txtHora", new SimpleDateFormat("HH:mm").format(data));
		postData.put("txtDocumento", tipo);
		postData.put("txtAssuntoIPE", incluirAssuntoIPE ? "SIM" : "NÃO");

		HttpClient client = new HttpClient();

		client
				.setMethod("POST")
				.setUrl("https://WWW.RAD.CVM.GOV.BR/DOWNLOAD/SolicitaDownload.asp")
				.setBody(postData);

		client.connect();
		Document doc = client.downloadXml();
		client.close();

		NodeList lsDownloadMultiplo = doc.getElementsByTagName("DownloadMultiplo");
		if (lsDownloadMultiplo.getLength() == 1) {
			Element downloadMultiplo = (Element) lsDownloadMultiplo.item(0);
			String strDataConsulta = downloadMultiplo.getAttribute("DataConsulta");
			DateFormat fmtDataConsulta = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			Date dataConsulta = fmtDataConsulta.parse(strDataConsulta);

			NodeList links = doc.getElementsByTagName("Link");
			int size = links.getLength();

			this.response_items = new ArrayList<Arquivamento>(size);
			for (int i = 0; i < size; i++) {
				Arquivamento item = new Arquivamento((Element) links.item(i), dataConsulta);
				this.response_items.add(item);

				if (!Arquivamento.DB.select().where("url", item.url).exists()) {
					item.id = UUIDHelper.generateTimebased();
					Arquivamento.DB.insert(item);
					if (item.assuntos != null)
						for (ArquivamentoAssunto aa : item.assuntos) {
							aa.id = item.id;
							ArquivamentoAssunto.DB.insert(aa);
						}
				}
			}
		}

	}

}
