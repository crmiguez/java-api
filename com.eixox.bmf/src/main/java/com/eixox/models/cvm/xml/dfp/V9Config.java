package com.eixox.models.cvm.xml.dfp;

import java.util.Date;

import com.eixox.adapters.DateYmdAdapter;
import com.eixox.adapters.UseAdapter;
import com.eixox.xml.Xml;

/**
 * Nome do XML: CONFIG.XML Descrição: Configurações.
 * 
 * @author Rodrigo Portela
 *
 */
@Xml(name = "Config")
public class V9Config {

	/**
	 * Código da empresa na CVM
	 */
	@Xml(name = "CODCVM")
	public int codigo_cvm;

	/**
	 * Data de término do exercício (formato AAAAMMDD)
	 * 
	 */
	@Xml(name = "DATADOC")
	@UseAdapter(DateYmdAdapter.class)
	public Date data_documento;

	/**
	 * Tipo de documento : 1 - DFP - Moeda Constante 2 - DFP - Legislação
	 * Societária 3 - ITR - Moeda Constante 4 - ITR - Legislação Societária 5 –
	 * IAN 6 – DFP IFRS 7 – ITR IFRS
	 */
	@Xml(name = "TIPO_DOC")
	public int tipo_documento;

	/**
	 * Tipo da exigência: 01 - Apresentação; 02 - Reapresentação Espontânea; 03
	 * - Reapresentação por Exigência;
	 */
	@Xml(name = "STATUS")
	public int tipo_exigencia;

	/**
	 * Número da exigência
	 */
	@Xml(name = "EXIGENCIA")
	public String numero_exigencia;

	/**
	 * Tipo da moeda: 01 - Real
	 */
	@Xml(name = "MOEDA")
	public int tipo_moeda;

	/**
	 * Escala da moeda: 01 - unidade; 02 - mil
	 * 
	 */
	@Xml(name = "ESCALA")
	public int tipo_escala_moeda;

	/**
	 * Escala de quantidade: 01 - unidade; 02 - mil;
	 */
	@Xml(name = "ESCALA_QTD")
	public int tipo_escala_quantidade;

	/**
	 * FATOR 17 Fator de correção(formato 999999.9999999999)
	 */
	@Xml(name = "FATOR")
	public double fator_correcao;

	/**
	 * Nome da pessoa da empresa para contato
	 */
	@Xml(name = "CONTATO")
	public String contato_nome;

	/**
	 * DDD do telefone da pessoa da empresa para contato
	 */
	@Xml(name = "DDD")
	public int contato_ddd;

	/**
	 * Telefone da pessoa da empresa para contato
	 */
	@Xml(name = "TELEFONE")
	public int contato_tel;

	/**
	 * Versão da tela
	 */
	@Xml(name = "VER_TELA")
	public String versao_tela;

	/**
	 * Versão do programa
	 */
	@Xml(name = "VER_PRG")
	public String versao_programa;

	/**
	 * Email da pessoa da empresa para contato
	 */
	@Xml(name = "EMAILREP")
	public String contato_email;
}
