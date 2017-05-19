package com.eixox.models.bmf;

import com.eixox.data.sql.DatabaseColumn;
import com.eixox.data.sql.DatabaseTable;

@DatabaseTable("carteira_papel")
public class CarteiraPapel {

	@DatabaseColumn
	public int carteira_id;

	@DatabaseColumn
	public String ticker;

	@DatabaseColumn
	public int quantidade;

	@DatabaseColumn
	public double valor_unitario;
}
