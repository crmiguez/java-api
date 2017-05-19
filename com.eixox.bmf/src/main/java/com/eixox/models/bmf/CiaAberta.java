package com.eixox.models.bmf;

import java.util.Date;

import com.eixox.data.Unique;
import com.eixox.data.sql.DatabaseColumn;
import com.eixox.data.sql.DatabaseTable;

/**
 * Uma empresa de capital aberto registrada na CVM.
 * 
 * @author Rodrigo Portela
 *
 */
@DatabaseTable("ciaaberta")
public class CiaAberta {

	/**
	 * The company's code on CVM;
	 */
	@DatabaseColumn
	@Unique
	public int codigo_cvm;

	/**
	 * The company's registration name on CVM;
	 */
	@DatabaseColumn
	public String razao_social;

	/**
	 * The company's fantasy name on CVM;
	 */
	@DatabaseColumn
	public String fantasia;

	/**
	 * The company's sector of activity on CVM;
	 */
	@DatabaseColumn
	public String setor_atividade;

	/**
	 * The company's tax payer id on CVM;
	 */
	@DatabaseColumn
	public long cnpj;

	/**
	 * The date of the registration;
	 */
	@DatabaseColumn
	public Date registro_data;

	/**
	 * The date of the company's constitution;
	 */
	@DatabaseColumn
	public Date constituicao_data;

	/**
	 * The date of the company's cancellation;
	 */
	@DatabaseColumn
	public Date cancelamento_data;

	/**
	 * The reason the company cancelled;
	 */
	@DatabaseColumn
	public String cancelamento_motivo;

	/**
	 * Nome da situação da empresa na CVM.
	 */
	@DatabaseColumn
	public String situacao_nome;

	/**
	 * Data da situação da empresa na CVM.
	 */
	@DatabaseColumn
	public Date situacao_data;

	/**
	 * Nome do emissor da situação
	 */
	@DatabaseColumn
	public String situacao_emissor_nome;

	/**
	 * Data do emissor da situação;
	 */
	@DatabaseColumn
	public Date situacao_emissor_data;

	/**
	 * Categoria de registro;
	 */
	@DatabaseColumn
	public String categoria_nome;

	/**
	 * Data de inicio na categoria;
	 */
	@DatabaseColumn
	public Date categoria_data;

	/**
	 * Nome do auditor;
	 */
	@DatabaseColumn
	public String auditor_nome;

	/**
	 * CNPJ do auditor;
	 */
	@DatabaseColumn
	public long auditor_cnpj;

	public static final BovespaDb<CiaAberta> DB = BovespaDb.getInstance(CiaAberta.class);
}
