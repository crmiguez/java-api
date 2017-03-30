package com.eixox.models.bmf.fixedlength;

import java.util.Date;

import com.eixox.adapters.DateYmdAdapter;
import com.eixox.adapters.UseAdapter;
import com.eixox.data.text.FixedLength;

/**
 * REGISTRO - 00 - HEADER
 * 
 * @author Rodrigo Portela
 *
 */
public class SerieHistoricaHeader {

	/**
	 * NOME DO ARQUIVO FIXO “COTAHIST.AAAA” X(13) 03 15
	 */
	@FixedLength(start = 2, end = 15)
	public String nome_arquivo;

	/**
	 * CÓDIGO DA ORIGEM FIXO “BOVESPA” X(08) 16 23
	 */
	@FixedLength(start = 15, end = 23)
	public String codigo_origem;

	/**
	 * DATA DA GERAÇÃO DO ARQUIVO FORMATO “AAAAMMDD” N(08) 24 31
	 */
	@FixedLength(start = 23, end = 31)
	@UseAdapter(DateYmdAdapter.class)
	public Date data_geracao;

	/**
	 * RESERVA PREENCHER COM BRANCOS X(214) 32 245
	 */
	@FixedLength(start = 31, end = 245)
	public String reserva;

}
