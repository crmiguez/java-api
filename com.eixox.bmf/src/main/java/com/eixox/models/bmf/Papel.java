package com.eixox.models.bmf;

import java.util.Date;

import com.eixox.data.CompositeKey;
import com.eixox.data.sql.DatabaseColumn;
import com.eixox.data.sql.DatabaseTable;

@DatabaseTable("papel")
public class Papel {

	@DatabaseColumn
	@CompositeKey
	public int mercado_id;

	@DatabaseColumn
	@CompositeKey
	public String ticker;

	@DatabaseColumn
	public Date data_pregao_max;

	@DatabaseColumn
	public Date data_pregao_min;

	@DatabaseColumn
	public int num_negocios_min;

	@DatabaseColumn
	public int num_negocios_max;

	@DatabaseColumn
	public double num_negocios_avg;

	@DatabaseColumn
	public double preco_ultimo_avg;

	@DatabaseColumn
	public double preco_ultimo_min;

	@DatabaseColumn
	public double preco_ultimo_max;

	@DatabaseColumn
	public double variacao_pct_min;

	@DatabaseColumn
	public double variacao_pct_avg;

	@DatabaseColumn
	public double variacao_pct_max;

	@DatabaseColumn
	public int pregao_count;

	@DatabaseColumn
	public String emissor;

	public static final BovespaDb<Papel> DB = BovespaDb.getInstance(Papel.class);
}
