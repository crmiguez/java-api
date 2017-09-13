package com.eixox.models.bmf.fixedlength;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.eixox.data.text.FixedLengthAspect;

public class TituloNegociavelParser {

	private final FixedLengthAspect<TituloNegociavel> titulo_aspect;
	private final FixedLengthAspect<TituloNegociavelHeader> header_aspect;
	private final FixedLengthAspect<TituloNegociavelCia> cia_aspect;
	private final FixedLengthAspect<TituloNegociavelTrailer> trailer_aspect;

	public TituloNegociavelParser() {
		this.titulo_aspect = new FixedLengthAspect<TituloNegociavel>(TituloNegociavel.class);
		this.header_aspect = new FixedLengthAspect<TituloNegociavelHeader>(TituloNegociavelHeader.class);
		this.cia_aspect = new FixedLengthAspect<TituloNegociavelCia>(TituloNegociavelCia.class);
		this.trailer_aspect = new FixedLengthAspect<TituloNegociavelTrailer>(TituloNegociavelTrailer.class);
	}

	public void accept(InputStream in, TituloNegociavelVisitor visitor) throws IOException {
		InputStreamReader is = new InputStreamReader(in);
		BufferedReader reader = new BufferedReader(is);
		String l = reader.readLine();
		while (l != null) {
			int tipo = Integer.parseInt(l.substring(0, 2));
			switch (tipo) {
			case 0: // header
				TituloNegociavelHeader header = header_aspect.parse(l);
				visitor.visitHeader(header);
				break;
			case 1:// item
				TituloNegociavelCia cia = cia_aspect.parse(l);
				visitor.visitCia(cia);
				break;
			case 2:
				TituloNegociavel titulo = titulo_aspect.parse(l);
				visitor.visitItem(titulo);
				break;
			case 9:
				TituloNegociavelTrailer trailer = trailer_aspect.parse(l);
				visitor.visitTrailer(trailer);
				break;
			default:
				throw new RuntimeException("Tipo de Registro Desconhecido: " + tipo);
			}
			l = reader.readLine();
		}
	}

	public void accept(String fileName, TituloNegociavelVisitor visitor) throws IOException {
		FileInputStream fis = new FileInputStream(fileName);
		try {
			accept(fis, visitor);
		} finally {
			fis.close();
		}

	}

	public void acceptZip(InputStream in, TituloNegociavelVisitor visitor) throws IOException {
		final ZipInputStream is = new ZipInputStream(in);
		try {
			for (ZipEntry entry = is.getNextEntry(); entry != null; entry = is.available() > 0 ?
					is.getNextEntry() :
					null) {
				accept(is, visitor);
				is.closeEntry();
			}
		} finally {
			is.close();
		}

	}

	public void acceptZip(String fileName, TituloNegociavelVisitor visitor) throws FileNotFoundException, IOException {
		acceptZip(new FileInputStream(fileName), visitor);
	}

}
