package com.eixox.models.bmf.fixedlength;

import com.eixox.data.text.FixedLength;

/**
 * REGISTRO - 09 - TRAILER
 * 
 * @author Rodrigo Portela
 *
 */
public class TituloNegociavelTrailer {

	/**
	 * QUANTIDADE DE REGISTROS GRAVADOS N(07) 03 09
	 */
	@FixedLength(start = 2, end = 9)
	public int quantidade_registros;
}
