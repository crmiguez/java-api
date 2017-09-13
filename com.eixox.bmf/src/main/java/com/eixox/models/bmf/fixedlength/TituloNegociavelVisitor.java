package com.eixox.models.bmf.fixedlength;

/**
 * A visitor that can process items on a titulo negociavel file;
 * 
 * @author Rodrigo Portela
 *
 */
public interface TituloNegociavelVisitor {

	public void visitHeader(TituloNegociavelHeader header);

	public void visitTrailer(TituloNegociavelTrailer trailer);

	public void visitItem(TituloNegociavel titulo);

	public void visitCia(TituloNegociavelCia cia);
}
