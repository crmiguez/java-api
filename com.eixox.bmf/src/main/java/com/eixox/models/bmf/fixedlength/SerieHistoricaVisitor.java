package com.eixox.models.bmf.fixedlength;

import com.eixox.models.bmf.Pregao;

public interface SerieHistoricaVisitor {

	public void visitHeader(SerieHistoricaHeader header);

	public void visitTrailer(SerieHistoricaTrailer trailer);

	public void visitItem(Pregao item);
}
