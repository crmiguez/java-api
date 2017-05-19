package com.eixox.models.bmf;

import java.util.Date;

import com.eixox.data.CompositeKey;
import com.eixox.data.sql.DatabaseColumn;
import com.eixox.data.sql.DatabaseTable;

@DatabaseTable("ciaaberta_responsavel")
public class CiaAbertaResponsavel {

	@DatabaseColumn
	@CompositeKey
	public int codigo_cvm;

	@DatabaseColumn
	@CompositeKey
	public String tipo;

	@DatabaseColumn
	public String nome;

	@DatabaseColumn
	public Date inicio;

	@DatabaseColumn
	public String logradouro;

	@DatabaseColumn
	public String complemento;

	@DatabaseColumn
	public String bairro;

	@DatabaseColumn
	public String cidade;

	@DatabaseColumn
	public String uf;

	@DatabaseColumn
	public String pais;

	@DatabaseColumn
	public int cep;

	@DatabaseColumn
	public String telefone;

	@DatabaseColumn
	public String fax;

	@DatabaseColumn
	public String email;

	public static final BovespaDb<CiaAbertaResponsavel> DB = BovespaDb.getInstance(CiaAbertaResponsavel.class);
}
