package com.eixox.models.bmf;

import java.util.Date;

import com.eixox.adapters.DateAdapter;
import com.eixox.adapters.UseAdapter;
import com.eixox.data.Unique;
import com.eixox.data.sql.DatabaseColumn;
import com.eixox.data.sql.DatabaseTable;
import com.eixox.data.text.Csv;
import com.eixox.data.text.CsvFile;

/**
 * A tab separated file from CVM containing open company registration.
 * 
 * @author Rodrigo Portela
 *
 */
@CsvFile(separator = "\t", first_row_has_names = true)
@DatabaseTable("ciaaberta")
public class CiaAberta {

	/**
	 * The company's code on CVM;
	 */
	@Csv(name = "CD_CVM")
	@DatabaseColumn
	@Unique
	public int codigo_cvm;

	/**
	 * The company's registration name on CVM;
	 */
	@Csv(name = "DENOM_SOCIAL")
	@DatabaseColumn
	public String razao_social;

	/**
	 * The company's fantasy name on CVM;
	 */
	@Csv(name = "DENOM_COMERC")
	@DatabaseColumn
	public String fantasia;

	/**
	 * The company's sector of activity on CVM;
	 */
	@Csv(name = "SETOR_ATIV")
	@DatabaseColumn
	public String setor_atividade;

	/**
	 * The company's tax payer id on CVM;
	 */
	@Csv(name = "CNPJ")
	@DatabaseColumn
	public long cnpj;

	/**
	 * The date of the registration;
	 */
	@Csv(name = "DT_REG")
	@UseAdapter(value = DateAdapter.class, format = "dd/MM/yyyy")
	@DatabaseColumn
	public Date registro_data;

	/**
	 * The date of the company's constitution;
	 */
	@Csv(name = "DT_CONST")
	@UseAdapter(value = DateAdapter.class, format = "dd/MM/yyyy")
	@DatabaseColumn
	public Date constituicao_data;

	/**
	 * The date of the company's cancellation;
	 */
	@Csv(name = "DT_CANCEL")
	@UseAdapter(value = DateAdapter.class, format = "dd/MM/yyyy")
	@DatabaseColumn
	public Date cancelamento_data;

	/**
	 * The reason the company cancelled;
	 */
	@Csv(name = "MOTIVO_CANCEL")
	@DatabaseColumn
	public String cancelamento_motivo;

	@Csv(name = "SIT_REG")
	@DatabaseColumn
	public String situacao_nome;

	@Csv(name = "DT_INI_SIT")
	@UseAdapter(value = DateAdapter.class, format = "dd/MM/yyyy")
	@DatabaseColumn
	public Date situacao_data;

	@Csv(name = "SIT_EMISSOR")
	@DatabaseColumn
	public String situacao_emissor_nome;

	@Csv(name = "DT_INI_SIT_EMISSOR")
	@UseAdapter(value = DateAdapter.class, format = "dd/MM/yyyy")
	@DatabaseColumn
	public Date situacao_emissor_data;

	@Csv(name = "CATEG_REG")
	@DatabaseColumn
	public String categoria_registro;

	@Csv(name = "DT_INI_CATEG")
	@UseAdapter(value = DateAdapter.class, format = "dd/MM/yyyy")
	@DatabaseColumn
	public Date categoria_data;

	@Csv(name = "AUDITOR")
	@DatabaseColumn
	public String auditor_nome;

	@Csv(name = "CNPJ_AUDITOR")
	@DatabaseColumn
	public long auditor_cnpj;

	@Csv(name = "TP_ENDER")
	@DatabaseColumn
	public String endereco_label;

	@Csv(name = "LOGRADOURO")
	@DatabaseColumn
	public String endereco_logradouro;

	@Csv(name = "COMPL")
	@DatabaseColumn
	public String endereco_complemento;

	@Csv(name = "BAIRRO")
	@DatabaseColumn
	public String endereco_bairro;

	@Csv(name = "CIDADE")
	@DatabaseColumn
	public String endereco_cidade;

	@Csv(name = "UF")
	@DatabaseColumn
	public String endereco_uf;

	@Csv(name = "PAIS")
	@DatabaseColumn
	public String endereco_pais;

	@Csv(name = "CD_POSTAL")
	@DatabaseColumn
	public String endereco_cd_postal;

	@Csv(name = "TEL")
	@DatabaseColumn
	public String telefone;

	@Csv(name = "FAX")
	@DatabaseColumn
	public String fax;

	@Csv(name = "EMAIL")
	@DatabaseColumn
	public String email;

	@Csv(name = "TP_RESP")
	@DatabaseColumn
	public String responsavel_tipo;

	@Csv(name = "RESP")
	@DatabaseColumn
	public String responsavel_nome;

	@Csv(name = "DT_INI_RESP")
	@UseAdapter(value = DateAdapter.class, format = "dd/MM/yyyy")
	@DatabaseColumn
	public Date responsavel_inicio;

	@Csv(name = "LOGRADOURO_RESP")
	@DatabaseColumn
	public String responsavel_endereco_logradouro;

	@Csv(name = "COMPL_RESP")
	@DatabaseColumn
	public String responsavel_endereco_complemento;

	@Csv(name = "BAIRRO_RESP")
	@DatabaseColumn
	public String responsavel_endereco_bairro;

	@Csv(name = "CIDADE_RESP")
	@DatabaseColumn
	public String responsavel_endereco_cidade;

	@Csv(name = "UF_RESP")
	@DatabaseColumn
	public String responsavel_endereco_uf;

	@Csv(name = "PAIS_RESP")
	@DatabaseColumn
	public String responsavel_endereco_pais;

	@Csv(name = "CEP_RESP")
	@DatabaseColumn
	public int responsavel_endereco_cep;

	@Csv(name = "TEL_RESP")
	@DatabaseColumn
	public String responsavel_telefone;

	@Csv(name = "FAX_RESP")
	@DatabaseColumn
	public String responsavel_fax;

	@Csv(name = "EMAIL_RESP")
	@DatabaseColumn
	public String responsavel_email;

	public static final BovespaDb<CiaAberta> DB = BovespaDb.getInstance(CiaAberta.class);
}
