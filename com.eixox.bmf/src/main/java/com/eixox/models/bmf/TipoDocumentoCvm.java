package com.eixox.models.bmf;

public enum TipoDocumentoCvm {

	DFP_MOEDA_CONSTANTE(1, "DFP - Moeda Constante"),
	DFP_LEGISLACAO_SOCIETARIA(2, "DFP - Legislação Societária"),
	ITR_MOEDA_CONSTANTE(3, "ITR - Moeda Constante"),
	ITR_LEGISLACAO_SOCIETARIA(4, "ITR - Legislação Societária"),
	IAN(5, "IAN"),
	DFP_IFRS(6, "DFP IFRS"),
	ITR_IFRS(7, "ITR IFRS");

	public final int id;
	public final String nome;

	TipoDocumentoCvm(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public static final TipoDocumentoCvm byId(int id) {
		for (TipoDocumentoCvm item : TipoDocumentoCvm.values())
			if (item.id == id)
				return item;
		return null;
	}
}
