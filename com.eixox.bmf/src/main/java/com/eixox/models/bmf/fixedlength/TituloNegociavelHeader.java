package com.eixox.models.bmf.fixedlength;

import java.util.Date;

import com.eixox.adapters.DateAdapter;
import com.eixox.adapters.UseAdapter;
import com.eixox.data.text.FixedLength;

/**
 * REGISTRO - 00 - HEADER Ref:
 * http://bvmf.bmfbovespa.com.br/cias-listadas/Titulos-Negociaveis/download/Titulos_Negociaveis.PDF
 * 
 * @author Rodrigo Portela
 *
 */
public class TituloNegociavelHeader {

	/**
	 * NOME DO ARQUIVO FIXO ‘TITULOS NEGOCIAVEIS’ X(28) 03 30
	 */
	@FixedLength(start = 2, end = 30)
	public String nome_arquivo;

	/**
	 * DATA DO PREGÃO FORMATO AAAA-MM-DD X(10) 31 40
	 */
	@FixedLength(start = 30, end = 40)
	@UseAdapter(format = "yyyy-MM-dd", value = DateAdapter.class)
	public Date data_pregao;
}
