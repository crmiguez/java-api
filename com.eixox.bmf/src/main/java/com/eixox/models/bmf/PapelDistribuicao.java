package com.eixox.models.bmf;

import java.util.Date;

import com.eixox.data.Identity;
import com.eixox.data.sql.DatabaseColumn;
import com.eixox.data.sql.DatabaseTable;

@DatabaseTable("papel_distribuicao")
public class PapelDistribuicao {

	@DatabaseColumn
	@Identity
	public int id;

	@DatabaseColumn
	public int papel_id;

	@DatabaseColumn
	public Date data_vencimento;

	@DatabaseColumn
	public int distribuicao;

	@DatabaseColumn
	public String especificacao;

	@DatabaseColumn
	public int fator_cotacao;

	@DatabaseColumn
	public int indicador_correcao;

	@DatabaseColumn
	public double pontos_exercicio;

	@DatabaseColumn
	public double prazo_dias;

	@DatabaseColumn
	public double preco_exercicio;

	public static final BovespaDb<PapelDistribuicao> DB = BovespaDb.getInstance(PapelDistribuicao.class);
}
