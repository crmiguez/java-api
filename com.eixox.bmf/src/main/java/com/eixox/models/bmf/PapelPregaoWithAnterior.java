package com.eixox.models.bmf;

import java.util.Date;

import com.eixox.data.sql.DatabaseColumn;
import com.eixox.data.sql.DatabaseTable;

@DatabaseTable("papel_pregao_w_anterior")
public class PapelPregaoWithAnterior {

	@DatabaseColumn("id")
	public int pregao_id;

	@DatabaseColumn
	public int anterior_id;

	@DatabaseColumn
	public int mercado_id;

	@DatabaseColumn
	public int bdi_id;

	@DatabaseColumn
	public Date data_pregao;

	@DatabaseColumn
	public String moeda;

	@DatabaseColumn
	public int distribuicao_id;

	@DatabaseColumn
	public int papel_id;

	@DatabaseColumn
	public double preco_abertura;

	@DatabaseColumn
	public double preco_maximo;

	@DatabaseColumn
	public double preco_minimo;

	@DatabaseColumn
	public double preco_medio;

	@DatabaseColumn
	public double preco_melhor_oferta_compra;

	@DatabaseColumn
	public double preco_melhor_oferta_venda;

	@DatabaseColumn
	public int num_negocios;

	@DatabaseColumn
	public long num_titulos_negociados;

	@DatabaseColumn
	public double volume_negociado;

	@DatabaseColumn
	public double preco_abertura_anterior;

	@DatabaseColumn
	public double preco_maximo_anterior;

	@DatabaseColumn
	public double preco_minimo_anterior;

	@DatabaseColumn
	public double preco_medio_anterior;

	@DatabaseColumn
	public double preco_melhor_oferta_compra_anterior;

	@DatabaseColumn
	public double preco_melhor_oferta_venda_anterior;

	@DatabaseColumn
	public int num_negocios_anterior;

	@DatabaseColumn
	public long num_titulos_negociados_anterior;

	@DatabaseColumn
	public double volume_negociado_anterior;

	public static final BovespaDb<PapelPregaoWithAnterior> DB = BovespaDb.getInstance(PapelPregaoWithAnterior.class);
}
