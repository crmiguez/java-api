package com.eixox.models.bmf;

import java.util.UUID;

import com.eixox.data.sql.DatabaseColumn;
import com.eixox.data.sql.DatabaseTable;

@DatabaseTable("arquivamento_assunto")
public class ArquivamentoAssunto {

	@DatabaseColumn
	public UUID id;

	@DatabaseColumn
	public String assunto;

	public ArquivamentoAssunto() {

	}

	public ArquivamentoAssunto(String a) {
		this.assunto = a;
	}

	public static final BovespaDb<ArquivamentoAssunto> DB = BovespaDb.getInstance(ArquivamentoAssunto.class);
}
