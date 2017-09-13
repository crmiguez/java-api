package com.eixox.models.bmf.fixedlength;

import java.util.Date;

import com.eixox.adapters.DateAdapter;
import com.eixox.adapters.DoubleDiv10000000Adapter;
import com.eixox.adapters.UseAdapter;
import com.eixox.data.text.FixedLength;

/**
 * REGISTRO - 02 - DADOS DOS TÍTULOS NEGOCIÁVEIS. Ref:
 * http://bvmf.bmfbovespa.com.br/cias-listadas/Titulos-Negociaveis/download/Titulos_Negociaveis.PDF
 */
public class TituloNegociavel {

	/**
	 * CÓDIGO DE NEGOCIAÇÃO DO PAPEL X(12) 03 14
	 */
	@FixedLength(start = 2, end = 14)
	public String codigo_negociacao;

	/**
	 * CÓDIGO DA EMPRESA X(04) 15 18
	 */
	@FixedLength(start = 14, end = 18)
	public String codigo_empresa;

	/**
	 * CÓDIGO BDI N(03) 19 21
	 */
	@FixedLength(start = 18, end = 21)
	public int codigo_bdi;

	/**
	 * DESCRIÇÃO DO CODBDI X(60) 22 81
	 */
	@FixedLength(start = 21, end = 81)
	public String descricao_bdi;

	/**
	 * CÓDIGO ISIN DO PAPEL X(12) 82 93
	 */
	@FixedLength(start = 81, end = 93)
	public String isin_papel;

	/**
	 * CÓDIGO ISIN DO PAPEL OBJETO X(12) 94 105
	 */
	@FixedLength(start = 93, end = 105)
	public String isin_papel_objeto;

	/**
	 * NÚMERO DISTRIBUIÇÃO DO PAPEL N(03) 106 108
	 */
	@FixedLength(start = 105, end = 108)
	public int numero_distribuicao_papel;

	/**
	 * CÓDIGO DO MERCADO N(03) 109 111
	 */
	@FixedLength(start = 108, end = 111)
	public int codigo_mercado;

	/**
	 * DESCRIÇÃO DO MERCADO X(15) 112 126
	 */
	@FixedLength(start = 111, end = 126)
	public String descricao_mercado;

	/**
	 * NÚMERO DE SÉRIE P/ OS MERCADOS DE OPÇÕES, TERMO SECUDÁRIO E FUTURO N(07)
	 * 127 133
	 * 
	 */
	@FixedLength(start = 126, end = 133)
	public int numero_serie_futuro;

	/**
	 * ESPECIFICAÇÃO DO PAPEL OBJETO X(10) 134 143
	 */
	@FixedLength(start = 133, end = 143)
	public String especificacao_papel_objeto;

	/**
	 * DATA DE VENCIMENTO PARA OS MERCADOS DE OPÇÕES DE COMPRA/ VENDA, TERMO
	 * SECUNDÁRIO E FUTURO FORMATO AAAA-MM-DD x(10) 144 153
	 */
	@FixedLength(start = 143, end = 153)
	@UseAdapter(value = DateAdapter.class, format = "yyyy-MM-dd")
	public Date data_vencimento;

	/**
	 * PREÇO SE MERCADO = 30, VALOR DO CONTRATO; SE MERCADO = 70 OU 80, PREÇO DE
	 * EXERCÍCIO; SE MERCADO = 50, PREÇO DE AJUSTE; CASO CONTRÁRIO CONTERÁ
	 * ZEROS.
	 */
	@FixedLength(start = 153, end = 171)
	@UseAdapter(value = DoubleDiv10000000Adapter.class)
	public double preco;

	/**
	 * ESTILO DA OPÇÃO PARA MERCADO DE OPÇÕES ‘E’ = EUROPÉIA ‘A’ = AMERICANA
	 * PARA DEMAIS MERCADOS ‘ ‘ = FIXO X(01) 172 172
	 */
	@FixedLength(start = 171, end = 172)
	public String estilo_opcao;

	/**
	 * INDICADOR DO TIPO DE MOEDA/CORREÇÃO PREÇOS DE EXERCÍCIO DE OPÇÕES DE
	 * COMPRA/VENDA OU VALOR DE CONTRATO PARA O MERCADO DE TERMO SECUNDÁRIO
	 * N(03) 173 175
	 * 
	 */
	@FixedLength(start = 172, end = 175)
	public int codigo_moeda;

	/**
	 * DESCRIÇÃO DO INDICADOR DO TIPO DE MOEDA/CORREÇÃO PREÇOS DE EXERCÍCIO DE
	 * OPÇÕES DE COMPRA/VENDA OU VALOR DE CONTRATO PARA O MERCADO DE TERMO
	 * SECUNDÁRIO ‘R$’ = SE ICOATV = 0 ‘PONTOS’ = SE ICOATV = 6 X(15) 176 190
	 */
	@FixedLength(start = 175, end = 190)
	public String descricao_moeda;

	/**
	 * PROTEÇÃO ‘NAO’ = NÃO PROTEGIDO ‘SIM’ = PROTEGIDO X(03) 191 193
	 */
	@FixedLength(start = 190, end = 193)
	public String protecao;
}
