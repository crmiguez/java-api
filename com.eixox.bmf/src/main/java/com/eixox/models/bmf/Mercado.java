package com.eixox.models.bmf;

import com.eixox.data.Unique;
import com.eixox.data.sql.DatabaseColumn;
import com.eixox.data.sql.DatabaseTable;

/**
 * Os tipos de marcado nas negociações da série histórica.
 * 
 * @author Rodrigo Portela
 *
 */
@DatabaseTable("mercado")
public class Mercado {

	@DatabaseColumn
	@Unique
	public int id;

	@DatabaseColumn
	public String nome;

	public static final BovespaDb<Mercado> DB = BovespaDb.getInstance(Mercado.class);

}
