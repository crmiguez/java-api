package com.eixox.models.cvm;

import java.util.Date;

import com.eixox.adapters.DateAdapter;
import com.eixox.adapters.UseAdapter;
import com.eixox.data.text.Csv;
import com.eixox.data.text.CsvFile;

/**
 * A tab separated file from CVM containing open company registration.
 * 
 * @author Rodrigo Portela
 *
 */
@CsvFile(separator = "\t", first_row_has_names = true)
public class CiaAbertaTsv {

	/**
	 * The company's code on CVM;
	 */
	@Csv(name = "CD_CVM")
	public int codigo_cvm;

	/**
	 * The company's registration name on CVM;
	 */
	@Csv(name = "DENOM_SOCIAL")
	public String razao_social;

	/**
	 * The company's fantasy name on CVM;
	 */
	@Csv(name = "DENOM_COMERC")
	public String fantasia;

	/**
	 * The company's sector of activity on CVM;
	 */
	@Csv(name = "SETOR_ATIV")
	public String setor_atividade;

	/**
	 * The company's tax payer id on CVM;
	 */
	@Csv(name = "CNPJ")
	public long cnpj;

	/**
	 * The date of the registration;
	 */
	@Csv(name = "DT_REG")
	@UseAdapter(value = DateAdapter.class, format = "dd/MM/yyyy")
	public Date registro_data;

	/**
	 * The date of the company's constitution;
	 */
	@Csv(name = "DT_CONST")
	@UseAdapter(value = DateAdapter.class, format = "dd/MM/yyyy")
	public Date constituicao_data;

	/**
	 * The date of the company's cancellation;
	 */
	@Csv(name = "DT_CANCEL")
	@UseAdapter(value = DateAdapter.class, format = "dd/MM/yyyy")
	public Date cancelamento_data;

	/**
	 * The reason the company cancelled;
	 */
	@Csv(name = "MOTIVO_CANCEL")
	public String cancelamento_motivo;

	@Csv(name = "SIT_REG")
	public String situacao_nome;

	@Csv(name = "DT_INI_SIT")
	@UseAdapter(value = DateAdapter.class, format = "dd/MM/yyyy")
	public Date situacao_data;

	@Csv(name = "SIT_EMISSOR")
	public String situacao_emissor_nome;

	@Csv(name = "DT_INI_SIT_EMISSOR")
	@UseAdapter(value = DateAdapter.class, format = "dd/MM/yyyy")
	public Date situacao_emissor_data;

	@Csv(name = "CATEG_REG")
	public String categoria_nome;

	@Csv(name = "DT_INI_CATEG")
	@UseAdapter(value = DateAdapter.class, format = "dd/MM/yyyy")
	public Date categoria_data;

	@Csv(name = "AUDITOR")
	public String auditor_nome;

	@Csv(name = "CNPJ_AUDITOR")
	public long auditor_cnpj;

	@Csv(name = "TP_ENDER")
	public String endereco_tipo;

	@Csv(name = "LOGRADOURO")
	public String endereco_logradouro;

	@Csv(name = "COMPL")
	public String endereco_complemento;

	@Csv(name = "BAIRRO")
	public String endereco_bairro;

	@Csv(name = "CIDADE")
	public String endereco_cidade;

	@Csv(name = "UF")
	public String endereco_uf;

	@Csv(name = "PAIS")
	public String endereco_pais;

	@Csv(name = "CD_POSTAL")
	public String endereco_cep;

	@Csv(name = "TEL")
	public String telefone;

	@Csv(name = "FAX")
	public String fax;

	@Csv(name = "EMAIL")
	public String email;

	@Csv(name = "TP_RESP")
	public String responsavel_tipo;

	@Csv(name = "RESP")
	public String responsavel_nome;

	@Csv(name = "DT_INI_RESP")
	@UseAdapter(value = DateAdapter.class, format = "dd/MM/yyyy")
	public Date responsavel_inicio;

	@Csv(name = "LOGRADOURO_RESP")
	public String responsavel_endereco_logradouro;

	@Csv(name = "COMPL_RESP")
	public String responsavel_endereco_complemento;

	@Csv(name = "BAIRRO_RESP")
	public String responsavel_endereco_bairro;

	@Csv(name = "CIDADE_RESP")
	public String responsavel_endereco_cidade;

	@Csv(name = "UF_RESP")
	public String responsavel_endereco_uf;

	@Csv(name = "PAIS_RESP")
	public String responsavel_endereco_pais;

	@Csv(name = "CEP_RESP")
	public int responsavel_endereco_cep;

	@Csv(name = "TEL_RESP")
	public String responsavel_telefone;

	@Csv(name = "FAX_RESP")
	public String responsavel_fax;

	@Csv(name = "EMAIL_RESP")
	public String responsavel_email;

	
}
