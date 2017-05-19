package com.eixox.models.bmf;

import com.eixox.data.CompositeKey;
import com.eixox.data.sql.DatabaseColumn;
import com.eixox.data.sql.DatabaseTable;

@DatabaseTable("ciaaberta_endereco")
public class CiaAbertaEndereco {

	@DatabaseColumn
	@CompositeKey
	public int codigo_cvm;

	@DatabaseColumn
	@CompositeKey
	public String label;

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
	public String cep;

	@DatabaseColumn
	public String telefone;

	@DatabaseColumn
	public String fax;

	@DatabaseColumn
	public String email;

	public static final BovespaDb<CiaAbertaEndereco> DB = BovespaDb.getInstance(CiaAbertaEndereco.class);

}
