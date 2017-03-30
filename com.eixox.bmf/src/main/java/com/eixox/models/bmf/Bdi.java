package com.eixox.models.bmf;

import java.util.LinkedList;
import java.util.List;

/**
 * TABELA DE CODBDI - RELAÇÃO DOS VALORES PARA CÓDIGOS DE BDI
 * 
 * @author Rodrigo Portela
 *
 */
public class Bdi {

	/**
	 * O código do BDI
	 */
	public final int id;
	/**
	 * O nome do BDI
	 */
	public final String nome;

	public Bdi(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	private static final LinkedList<Bdi> BDIS;

	static {
		BDIS = new LinkedList<Bdi>();
		BDIS.add(new Bdi(02, "LOTE PADRÃO"));
		BDIS.add(new Bdi(06, "CONCORDATÁRIAS"));
		BDIS.add(new Bdi(10, "DIREITOS E RECIBOS"));
		BDIS.add(new Bdi(12, "FUNDOS IMOBILIÁRIOS"));
		BDIS.add(new Bdi(14, "CERTIFIC. INVESTIMENTO / DEBÊNTURES / TÍTULOS DIVIDA PÚBLICA"));
		BDIS.add(new Bdi(18, "OBRIGAÇÕES"));
		BDIS.add(new Bdi(22, "BÔNUS (PRIVADOS)"));
		BDIS.add(new Bdi(26, "APÓLICES / BÔNUS / TÍTULOS PÚBLICOS"));
		BDIS.add(new Bdi(32, "EXERCÍCIO DE OPÇÕES DE COMPRA DE ÍNDICE"));
		BDIS.add(new Bdi(33, "EXERCÍCIO DE OPÇÕES DE VENDA DE ÍNDICE"));
		BDIS.add(new Bdi(38, "EXERCÍCIO DE OPÇÕES DE COMPRA"));
		BDIS.add(new Bdi(42, "EXERCÍCIO DE OPÇÕES DE VENDA"));
		BDIS.add(new Bdi(46, "LEILÃO DE TÍTULOS NÃO COTADOS"));
		BDIS.add(new Bdi(48, "LEILÃO DE PRIVATIZAÇÃO"));
		BDIS.add(new Bdi(50, "LEILÃO"));
		BDIS.add(new Bdi(51, "LEILÃO FINOR"));
		BDIS.add(new Bdi(52, "LEILÃO FINAM"));
		BDIS.add(new Bdi(53, "LEILÃO FISET"));
		BDIS.add(new Bdi(54, "LEILÃO DE AÇÕES EM MORA"));
		BDIS.add(new Bdi(56, "VENDAS POR ALVARÁ JUDICIAL"));
		BDIS.add(new Bdi(58, "OUTROS"));
		BDIS.add(new Bdi(60, "PERMUTA POR AÇÕES"));
		BDIS.add(new Bdi(61, "META"));
		BDIS.add(new Bdi(62, "TERMO"));
		BDIS.add(new Bdi(66, "DEBÊNTURES COM DATA DE VENCIMENTO ATÉ 3 ANOS"));
		BDIS.add(new Bdi(68, "DEBÊNTURES COM DATA DE VENCIMENTO MAIOR QUE 3 ANOS"));
		BDIS.add(new Bdi(70, "FUTURO COM MOVIMENTAÇÃO CONTÍNUA"));
		BDIS.add(new Bdi(71, "FUTURO COM RETENÇÃO DE GANHO"));
		BDIS.add(new Bdi(74, "OPÇÕES DE COMPRA DE ÍNDICES"));
		BDIS.add(new Bdi(75, "OPÇÕES DE VENDA DE ÍNDICES"));
		BDIS.add(new Bdi(78, "OPÇÕES DE COMPRA"));
		BDIS.add(new Bdi(82, "OPÇÕES DE VENDA"));
		BDIS.add(new Bdi(83, "DEBÊNTURES E NOTAS PROMISSÓRIAS"));
		BDIS.add(new Bdi(96, "FRACIONÁRIO"));
		BDIS.add(new Bdi(99, "TOTAL GERAL"));
	}

	public static final List<Bdi> all() {
		return BDIS;
	}

	public static final Bdi get(int id) {
		for (Bdi b : BDIS)
			if (b.id == id)
				return b;
		return null;
	}
}
