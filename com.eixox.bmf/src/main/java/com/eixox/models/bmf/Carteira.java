package com.eixox.models.bmf;

import java.util.Date;
import java.util.UUID;

import com.eixox.data.Identity;
import com.eixox.data.sql.DatabaseColumn;
import com.eixox.data.sql.DatabaseTable;

@DatabaseTable("carteira")
public class Carteira {

	@DatabaseColumn
	@Identity
	public int id;

	@DatabaseColumn
	public UUID person_id;

	@DatabaseColumn
	public int mercado_id;

	@DatabaseColumn
	public Date created_at;

	@DatabaseColumn
	public Date updated_at;

	@DatabaseColumn
	public int num_tickers;

	@DatabaseColumn
	public double valor_total;

	public static final BovespaDb<Carteira> DB = BovespaDb.getInstance(Carteira.class);
}
