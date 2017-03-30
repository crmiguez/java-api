package com.eixox.models.bmf.fixedlength;

public interface SerieHistoricaVisitor {

	public void visitHeader(SerieHistoricaHeader header);

	public void visitTrailer(SerieHistoricaTrailer trailer);

	public void visitItem(SerieHistorica item);
}
