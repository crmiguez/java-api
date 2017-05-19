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
import com.eixox.models.bmf.Pregao;

public class SerieHistoricaParser {

	public static final FixedLengthAspect<SerieHistoricaHeader> HEADER_ASPECT = new FixedLengthAspect<SerieHistoricaHeader>(
			SerieHistoricaHeader.class);

	public static final FixedLengthAspect<Pregao> ITEM_ASPECT = new FixedLengthAspect<Pregao>(
			Pregao.class);

	public static final FixedLengthAspect<SerieHistoricaTrailer> TRAILER_ASPECT = new FixedLengthAspect<SerieHistoricaTrailer>(
			SerieHistoricaTrailer.class);

	public void accept(InputStream in, SerieHistoricaVisitor visitor) throws IOException {
		InputStreamReader is = new InputStreamReader(in);
		BufferedReader reader = new BufferedReader(is);
		String l = reader.readLine();
		while (l != null) {
			int tipo = Integer.parseInt(l.substring(0, 2));
			switch (tipo) {
			case 0: // header
				SerieHistoricaHeader header = HEADER_ASPECT.parse(l);
				visitor.visitHeader(header);
				break;
			case 1:// item
				Pregao item = ITEM_ASPECT.parse(l);
				visitor.visitItem(item);
				break;
			case 99:// trailer
				SerieHistoricaTrailer trailer = TRAILER_ASPECT.parse(l);
				visitor.visitTrailer(trailer);
				break;
			default:
				throw new RuntimeException("Tipo de Registro Desconhecido: " + tipo);
			}
			l = reader.readLine();
		}
	}

	public void accept(String fileName, SerieHistoricaVisitor visitor) throws IOException {
		FileInputStream fis = new FileInputStream(fileName);
		try {
			accept(fis, visitor);
		} finally {
			fis.close();
		}

	}

	public void acceptZip(InputStream in, SerieHistoricaVisitor visitor) throws IOException {
		final ZipInputStream is = new ZipInputStream(in);
		try {
			for (ZipEntry entry = is.getNextEntry(); entry != null; entry = is.available() > 0 ? is.getNextEntry()
					: null) {
				accept(is, visitor);
				is.closeEntry();
			}
		} finally {
			is.close();
		}

	}

	public void acceptZip(String fileName, SerieHistoricaVisitor visitor) throws FileNotFoundException, IOException {
		acceptZip(new FileInputStream(fileName), visitor);
	}

}
