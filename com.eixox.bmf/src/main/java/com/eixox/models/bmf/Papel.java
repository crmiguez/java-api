package com.eixox.models.bmf;

import com.eixox.data.Identity;
import com.eixox.data.sql.DatabaseColumn;
import com.eixox.data.sql.DatabaseTable;

@DatabaseTable("papel")
public class Papel {

	@DatabaseColumn
	@Identity
	public int id;

	@DatabaseColumn
	public String ticker;

	@DatabaseColumn
	public String isin;

	@DatabaseColumn
	public String emissor;

	public static final BovespaDb<Papel> DB = BovespaDb.getInstance(Papel.class);
}
