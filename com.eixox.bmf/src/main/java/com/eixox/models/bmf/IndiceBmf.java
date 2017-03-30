package com.eixox.models.bmf;

/**
 * Um índice da BMF/Bovespa
 * 
 * @author Rodrigo Portela
 *
 */
public enum IndiceBmf {

	IBOV(1, "IBOV", "ÍNDICE BOVESPA"),
	IEEX(2, "IEEX", "ÍNDICE SETORIAL DE ENERGIA ELÉTRICA"),
	IVBX(3, "IVBX", "ÍNDICE IVBX2"),
	IBXX(4, "IBXX", "ÍNDICE IBRX BRASIL"),
	ITEL(5, "ITEL", "ÍNDICE ITELECOM"),
	IBXL(6, "IBXL", "ÍNDICE IBRX 50"),
	MIBV(7, "MIBV", "MINI IBOV"),
	IGCX(8, "IGCX", "ÍNDICE IGOVERNANÇA"),
	ITAG(10, "ITAG", "ITAG ALONG");

	/**
	 * O id do índice
	 */
	public final int id;
	/**
	 * A sigla do índice
	 */
	public final String sigla;
	/**
	 * O nome do índice
	 */
	public final String nome;

	/**
	 * Um novo indice do BMF bovespa
	 * 
	 * @param id
	 * @param sigla
	 * @param nome
	 */
	IndiceBmf(int id, String sigla, String nome) {
		this.id = id;
		this.sigla = sigla;
		this.nome = nome;
	}

	public static final IndiceBmf byId(int id) {
		for (IndiceBmf item : IndiceBmf.values())
			if (item.id == id)
				return item;
		return null;
	}
}
