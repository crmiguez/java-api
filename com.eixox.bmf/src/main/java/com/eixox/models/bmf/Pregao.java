package com.eixox.models.bmf;

import java.util.Date;

import com.eixox.adapters.DateYmdAdapter;
import com.eixox.adapters.DoubleDiv1000000Adapter;
import com.eixox.adapters.DoubleDiv100Adapter;
import com.eixox.adapters.UseAdapter;
import com.eixox.data.Identity;
import com.eixox.data.sql.DatabaseColumn;
import com.eixox.data.sql.DatabaseTable;
import com.eixox.data.text.FixedLength;

/**
 * REGISTRO - 01 - COTAÇÕES HISTÓRICAS POR PAPEL-MERCADO
 * 
 * @author Rodrigo Portela
 *
 */
@DatabaseTable("pregao")
public class Pregao {

	/**
	 * DATA DO PREGÃO FORMATO “AAAAMMDD” N(08) 03 10
	 */
	@FixedLength(start = 2, end = 10)
	@UseAdapter(DateYmdAdapter.class)
	@DatabaseColumn
	public Date data_pregao;
	/**
	 * CODBDI - CÓDIGO BDI - UTILIZADO PARA CLASSIFICAR OS PAPÉIS NA EMISSÃO DO
	 * BOLETIM DIÁRIO DE INFORMAÇÕES VER TABELA ANEXA X(02) 11 12
	 */
	@FixedLength(start = 10, end = 12)
	@DatabaseColumn
	public int bdi_id;
	/**
	 * CODNEG - CÓDIGO DE NEGOCIAÇÃO DO PAPEL X(12) 13 24
	 */
	@FixedLength(start = 12, end = 24)
	@DatabaseColumn
	public String ticker;
	/**
	 * TPMERC - TIPO DE MERCADO - CÓD. DO MERCADO EM QUE O PAPEL ESTÁ CADASTRADO
	 * VER TABELA ANEXA N(03) 25 27
	 */
	@FixedLength(start = 24, end = 27)
	@DatabaseColumn
	public int mercado_id;
	/**
	 * NOMRES - NOME RESUMIDO DA EMPRESA EMISSORA DO PAPEL X(12) 28 39
	 */
	@FixedLength(start = 27, end = 39)
	@DatabaseColumn
	public String emissor;
	/**
	 * ESPECI - ESPECIFICAÇÃO DO PAPEL VER TABELA ANEXA X(10) 40 49
	 */
	@FixedLength(start = 39, end = 49)
	@DatabaseColumn
	public String especificacao;
	/**
	 * PRAZOT - PRAZO EM DIAS DO MERCADO A TERMO X(03) 50 52
	 */
	@FixedLength(start = 49, end = 52)
	@DatabaseColumn
	public int prazo_dias;
	/**
	 * MODREF - MOEDA DE REFERÊNCIA MOEDA USADA NA DATA DO PREGÃO X(04) 53 56
	 */
	@FixedLength(start = 52, end = 56)
	@DatabaseColumn
	public String moeda;
	/**
	 * PREABE - PREÇO DE ABERTURA DO PAPEL-MERCADO NO PREGÃO N(11)V99 57 69
	 */
	@FixedLength(start = 56, end = 69)
	@UseAdapter(DoubleDiv100Adapter.class)
	@DatabaseColumn
	public double preco_abertura;
	/**
	 * PREMAX - PREÇO MÁXIMO DO PAPEL-MERCADO NO PREGÃO N(11)V99 70 82
	 */
	@FixedLength(start = 69, end = 82)
	@UseAdapter(DoubleDiv100Adapter.class)
	@DatabaseColumn
	public double preco_maximo;
	/**
	 * PREMIN - PREÇO MÍNIMO DO PAPELMERCADO NO PREGÃO N(11)V99 83 95
	 */
	@FixedLength(start = 82, end = 95)
	@UseAdapter(DoubleDiv100Adapter.class)
	@DatabaseColumn
	public double preco_minimo;
	/**
	 * PREMED - PREÇO MÉDIO DO PAPELMERCADO NO PREGÃO N(11)V99 96 108
	 */
	@FixedLength(start = 95, end = 108)
	@UseAdapter(DoubleDiv100Adapter.class)
	@DatabaseColumn
	public double preco_medio;
	/**
	 * PREULT - PREÇO DO ÚLTIMO NEGÓCIO DO PAPEL-MERCADO NO PREGÃO N(11)V99 109
	 * 121
	 */
	@FixedLength(start = 108, end = 121)
	@UseAdapter(DoubleDiv100Adapter.class)
	@DatabaseColumn
	public double preco_ultimo;
	/**
	 * PREOFC - PREÇO DA MELHOR OFERTA DE COMPRA DO PAPEL-MERCADO N(11)V99 122
	 * 134
	 */
	@FixedLength(start = 121, end = 134)
	@UseAdapter(DoubleDiv100Adapter.class)
	@DatabaseColumn
	public double preco_melhor_oferta_compra;
	/**
	 * PREOFV - PREÇO DA MELHOR OFERTA DE VENDA DO PAPEL-MERCADO N(11)V99 135
	 * 147
	 */
	@FixedLength(start = 134, end = 147)
	@UseAdapter(DoubleDiv100Adapter.class)
	@DatabaseColumn
	public double preco_melhor_oferta_venda;
	/**
	 * TOTNEG - NEG. - NÚMERO DE NEGÓCIOS EFETUADOS COM O PAPELMERCADO NO PREGÃO
	 * N(05) 148 152
	 */
	@FixedLength(start = 147, end = 152)
	@DatabaseColumn
	public int num_negocios;
	/**
	 * QUATOT - QUANTIDADE TOTAL DE TÍTULOS NEGOCIADOS NESTE PAPELMERCADO N(18)
	 * 153 170
	 */
	@FixedLength(start = 152, end = 170)
	@DatabaseColumn
	public long num_titulos_negociados;
	/**
	 * VOLTOT - VOLUME TOTAL DE TÍTULOS NEGOCIADOS NESTE PAPELMERCADO N(16)V99
	 * 171 188
	 */
	@FixedLength(start = 170, end = 188)
	@UseAdapter(DoubleDiv100Adapter.class)
	@DatabaseColumn
	public double volume_negociado;
	/**
	 * PREEXE - PREÇO DE EXERCÍCIO PARA O MERCADO DE OPÇÕES OU VALOR DO CONTRATO
	 * PARA O MERCADO DE TERMO SECUNDÁRIO N(11)V99 189 201
	 */
	@FixedLength(start = 188, end = 201)
	@UseAdapter(DoubleDiv100Adapter.class)
	@DatabaseColumn
	public double preco_exercicio;
	/**
	 * INDOPC - INDICADOR DE CORREÇÃO DE PREÇOS DE EXERCÍCIOS OU VALORES DE
	 * CONTRATO PARA OS MERCADOS DE OPÇÕES OU TERMO SECUNDÁRIO VER TABELA ANEXA
	 * N(01) 202 202
	 */
	@FixedLength(start = 201, end = 202)
	@DatabaseColumn
	public int indicador_correcao;
	/**
	 * DATVEN - DATA DO VENCIMENTO PARA OS MERCADOS DE OPÇÕES OU TERMO
	 * SECUNDÁRIO FORMATO “AAAAMMDD” N(08) 203 210
	 */
	@FixedLength(start = 202, end = 210)
	@UseAdapter(DateYmdAdapter.class)
	@DatabaseColumn
	public Date data_vencimento;
	/**
	 * FATCOT - FATOR DE COTAÇÃO DO PAPEL ‘1’ = COTAÇÃO UNITÁRIA ‘1000’ =
	 * COTAÇÃO POR LOTE DE MIL AÇÕES N(07) 211 217
	 */
	@FixedLength(start = 210, end = 217)
	@DatabaseColumn
	public double fator_cotacao;
	/**
	 * PTOEXE - PREÇO DE EXERCÍCIO EM PONTOS PARA OPÇÕES REFERENCIADAS EM DÓLAR
	 * OU VALOR DE CONTRATO EM PONTOS PARA TERMO SECUNDÁRIO PARA OS
	 * REFERENCIADOS EM DÓLAR, CADA PONTO EQUIVALE AO VALOR, NA MOEDA CORRENTE,
	 * DE UM CENTÉSIMO DA TAXA MÉDIA DO DÓLAR COMERCIAL INTERBANCÁRIO DE
	 * FECHAMENTO DO DIA ANTERIOR, OU SEJA, 1 PONTO = 1/100 US$ N(07)V06 218 230
	 */
	@FixedLength(start = 217, end = 230)
	@UseAdapter(DoubleDiv1000000Adapter.class)
	@DatabaseColumn
	public double pontos_exercicio;
	/**
	 * CODISI - CÓDIGO DO PAPEL NO SISTEMA ISIN OU CÓDIGO INTERNO DO PAPEL.
	 * CÓDIGO DO PAPEL NO SISTEMA ISIN A PARTIR DE 15-05-1995 X(12) 231 242
	 */
	@FixedLength(start = 230, end = 242)
	@DatabaseColumn
	public String isin;
	/**
	 * DISMES - NÚMERO DE DISTRIBUIÇÃO DO PAPEL - NÚMERO DE SEQÜÊNCIA DO PAPEL
	 * CORRESPONDENTE AO ESTADO DE DIREITO VIGENTE 9(03) 243 245
	 */
	@FixedLength(start = 242, end = 245)
	@DatabaseColumn
	public int distribuicao;


	@DatabaseColumn
	public double variacao;

	@DatabaseColumn
	public double variacao_pct;

	@DatabaseColumn
	public Date data_pregao_anterior;
	

}
