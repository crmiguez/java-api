package com.eixox.models.bmf;

import java.util.LinkedList;
import java.util.List;

import com.eixox.data.Unique;
import com.eixox.data.sql.DatabaseColumn;
import com.eixox.data.sql.DatabaseTable;

/**
 * Os tipos de marcado nas negociações da série histórica.
 * 
 * @author Rodrigo Portela
 *
 */
@DatabaseTable("mercado")
public class Mercado {

	/**
	 * O id do tipo de mercado
	 */
	@DatabaseColumn
	@Unique
	public int id;

	/**
	 * O nome do mercado
	 */
	@DatabaseColumn
	public String nome;

	/**
	 * A referencia ao BD de mercados
	 */
	public static final BovespaDb<Mercado> DB = BovespaDb.getInstance(Mercado.class);

	/**
	 * Inicializa um objeto do tipo Mercado;
	 */
	public Mercado() {

	}

	/**
	 * Initializa um objeto do tipo Mercado;
	 * 
	 * @param id
	 * @param nome
	 */
	public Mercado(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	private static final LinkedList<Mercado> MERCADOS;

	static {
		MERCADOS = new LinkedList<Mercado>();
		MERCADOS.add(new Mercado(10, "A VISTA"));
		MERCADOS.add(new Mercado(12, "EXERCÍCIO DE OPÇÕES DE COMPRA"));
		MERCADOS.add(new Mercado(13, "EXERCÍCIO DE OPÇÕES DE VENDA"));
		MERCADOS.add(new Mercado(17, "LEILÃO"));
		MERCADOS.add(new Mercado(20, "FRACIONÁRIO"));
		MERCADOS.add(new Mercado(30, "A TERMO"));
		MERCADOS.add(new Mercado(50, "FUTURO COM RETENÇÃO DE GANHO"));
		MERCADOS.add(new Mercado(60, "FUTURO COM MOVIMENTAÇÃO CONTÍNUA"));
		MERCADOS.add(new Mercado(70, "OPÇÕES DE COMPRA"));
		MERCADOS.add(new Mercado(80, "OPÇÕES DE VENDA"));
	}

	public static final List<Mercado> all() {
		return MERCADOS;
	}

	public static final Mercado get(int id) {
		for (Mercado m : MERCADOS)
			if (m.id == id)
				return m;
		return null;
	}

}
