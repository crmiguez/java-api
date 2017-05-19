package com.eixox.models.bmf;

import java.util.Date;

import com.eixox.data.Identity;
import com.eixox.data.sql.DatabaseColumn;
import com.eixox.data.sql.DatabaseTable;

@DatabaseTable("carteira_movimentacao")
public class CarteiraMovimentacao {

	@DatabaseColumn
	@Identity
	public int id;

	@DatabaseColumn
	public int carteira_id;

	@DatabaseColumn
	public int direcao;

	@DatabaseColumn
	public Date data;

	@DatabaseColumn
	public String ticker;

	@DatabaseColumn
	public double valor_unitario;

	public static final BovespaDb<CarteiraMovimentacao> DB = BovespaDb.getInstance(CarteiraMovimentacao.class);
}
