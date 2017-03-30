package com.eixox.models.bmf;

public enum IndicadorDeCorrecao {

	USD(1, "US$", "CORREÇÃO PELA TAXA DO DÓLAR"),
	TJLP(2, "TJLP", "CORREÇÃO PELA TJLP"),
	TR(3, "TR", "CORREÇÃO PELA TR"),
	IPCR(4, "IPCR", "CORREÇÃO PELO IPCR"),
	SWA(5, "SWA", "OPÇÕES DE TROCA - SWOPTIONS"),
	INDICES(6, "ÍNDICES", "OPÇÕES REFERENCIADAS EM PONTOS DE ÍNDICE"),
	USD_PROTEGIDAS(7, "US$ (PROTEGIDAS)", "CORREÇÃO PELA TAXA DO DÓLAR - OPÇÕES PROTEGIDAS"),
	IGPM(8, "IGPM", "CORREÇÃO PELO IGP-M - OPÇÕES PROTEGIDAS"),
	URV(9, "URV", "CORREÇÃO PELA URV");

	public final int id;
	public final String sigla;
	public final String nome;

	private IndicadorDeCorrecao(int id, String sigla, String nome) {
		this.id = id;
		this.sigla = sigla;
		this.nome = nome;

	}

	public static final IndicadorDeCorrecao byId(int id) {
		for (IndicadorDeCorrecao i : IndicadorDeCorrecao.values())
			if (i.id == id)
				return i;
		return null;
	}
}
