package com.eixox.models.bmf;

import java.util.Date;
import java.util.UUID;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.eixox.data.Unique;
import com.eixox.data.sql.DatabaseColumn;
import com.eixox.data.sql.DatabaseTable;

@DatabaseTable("arquivamento")
public class Arquivamento {

	@DatabaseColumn
	@Unique
	public UUID id;

	@DatabaseColumn
	@Unique
	public String url;

	@DatabaseColumn
	public String documento;

	@DatabaseColumn
	public String categoria;

	@DatabaseColumn
	public String tipo;

	@DatabaseColumn
	public String especie;

	@DatabaseColumn
	public int codigo_cvm;

	@DatabaseColumn
	public String data_referencia;

	@DatabaseColumn
	public String data_referencia_formato;

	@DatabaseColumn
	public String situacao;

	@DatabaseColumn
	public Date data_consulta;

	public ArquivamentoAssunto[] assuntos;

	public Arquivamento() {

	}

	public Arquivamento(Element element, Date data_consulta) {
		this.data_consulta = data_consulta;
		this.url = element.getAttribute("url");
		this.documento = element.getAttribute("Documento");
		this.categoria = element.getAttribute("Categoria");
		this.tipo = element.getAttribute("Tipo");
		this.especie = element.getAttribute("Especie");
		this.codigo_cvm = Integer.parseInt(element.getAttribute("ccvm").trim());
		this.data_referencia = element.getAttribute("DataRef");
		this.data_referencia_formato = element.getAttribute("FrmDtRef");
		this.situacao = element.getAttribute("Situacao");

		NodeList topAssXml = element.getElementsByTagName("Assuntos");
		if (topAssXml.getLength() > 0) {
			NodeList assXml = ((Element) topAssXml.item(0)).getElementsByTagName("Assunto");
			this.assuntos = new ArquivamentoAssunto[assXml.getLength()];
			for (int i = 0; i < this.assuntos.length; i++)
				this.assuntos[i] = new ArquivamentoAssunto(assXml.item(i).getTextContent().trim());
		}
	}

	public static final BovespaDb<Arquivamento> DB = BovespaDb.getInstance(Arquivamento.class);
}
