package com.eixox.models.bmf.fixedlength;

import com.eixox.data.text.FixedLength;

/**
 * REGISTRO - 01 - DADOS DAS EMPRESAS Ref:
 * http://bvmf.bmfbovespa.com.br/cias-listadas/Titulos-Negociaveis/download/Titulos_Negociaveis.PDF
 * 
 * @author Rodrigo Portela
 *
 */
public class TituloNegociavelCia {

	/**
	 * CÓDIGO DA EMPRESA X(04) 03 06
	 */
	@FixedLength(start = 2, end = 6)
	public String codigo_empresa;

	/**
	 * DENOMINAÇÃO SOCIAL DA EMPRESA X(60) 07 66
	 */
	@FixedLength(start = 6, end = 66)
	public String razao_social;

	/**
	 * NOME RESUMIDO DA EMPRESA X(12) 67 78
	 */
	@FixedLength(start = 66, end = 78)
	public String nome_resumido;

}
