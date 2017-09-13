package com.eixox.models.bmf.fixedlength;

import java.io.IOException;
import java.util.ArrayList;

import com.eixox.models.bmf.Pregao;

public class SerieHistoricaBag extends ArrayList<Pregao> implements SerieHistoricaVisitor {

	/**
	 * Creates a new serie historica bag;
	 */
	public SerieHistoricaBag() {
		super(1000000);
	}

	/**
	 * Creates a new serie historica bag;
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public SerieHistoricaBag(String fileName) throws IOException {
		this();
		new SerieHistoricaParser().acceptZip(fileName, this);
	}

	/**
	 * The generated serial version UID;
	 */
	private static final long serialVersionUID = 4193106517585528570L;

	/**
	 * The header of the file;
	 */
	public SerieHistoricaHeader header;

	/**
	 * The footer of the file;
	 */
	public SerieHistoricaTrailer trailer;

	public void visitHeader(SerieHistoricaHeader header) {
		this.header = header;
	}

	public void visitTrailer(SerieHistoricaTrailer trailer) {
		this.trailer = trailer;
	}

	public void visitItem(Pregao item) {
		super.add(item);
	}
	
	

}
