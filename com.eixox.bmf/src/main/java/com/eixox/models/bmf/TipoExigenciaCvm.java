package com.eixox.models.bmf;

public enum TipoExigenciaCvm {

	APRESENTACAO(1, "Apresentação"),
	REAPRESENTACAO_ESPONTANEA(2, "Reapresentação Espontânea"),
	REAPRESENTACAO_EXIGENCIA(3, "Reapresentação por Exigência");

	public final int id;
	public final String nome;

	private TipoExigenciaCvm(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public static final TipoExigenciaCvm byId(int id) {
		for (TipoExigenciaCvm item : TipoExigenciaCvm.values())
			if (item.id == id)
				return item;
		return null;
	}
}
