package com.eixox.models.bmf.fixedlength;

import java.util.Date;

import com.eixox.adapters.DateYmdAdapter;
import com.eixox.adapters.UseAdapter;
import com.eixox.data.text.FixedLength;

/**
 * REGISTRO - 99 - TRAILER
 * 
 * @author Rodrigo Portela
 *
 */
public class SerieHistoricaTrailer {

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
	 * TOTAL DE REGISTROS INCLUIR TAMBÉM OS REGISTROS HEADER E TRAILER. N(11) 32
	 * 42
	 */
	@FixedLength(start = 31, end = 42)
	public int total_registros;

	/**
	 * RESERVA PREENCHER COM BRANCOS X(203) 43 245
	 */
	@FixedLength(start = 42, end = 245)
	public String reserva;
}
