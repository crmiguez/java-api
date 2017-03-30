package com.eixox.bmf.fixedlength;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.TreeMap;

import org.junit.Test;

import com.eixox.models.bmf.BovespaDb;
import com.eixox.models.bmf.fixedlength.SerieHistorica;
import com.eixox.models.bmf.fixedlength.SerieHistoricaHeader;
import com.eixox.models.bmf.fixedlength.SerieHistoricaParser;
import com.eixox.models.bmf.fixedlength.SerieHistoricaTrailer;
import com.eixox.models.bmf.fixedlength.SerieHistoricaVisitor;

public class SerieHistoricaMarkov {

	@Test
	public void buildMarkovMatrix() throws FileNotFoundException, IOException {

		String[] fileNames = new String[] {
				"C:\\Users\\Rodrigo Portela\\Documents\\BOVESPA\\COTAHIST_A2014.ZIP",
				"C:\\Users\\Rodrigo Portela\\Documents\\BOVESPA\\COTAHIST_A2015.ZIP",
				"C:\\Users\\Rodrigo Portela\\Documents\\BOVESPA\\COTAHIST_A2016.ZIP",
				"C:\\Users\\Rodrigo Portela\\Documents\\BOVESPA\\COTAHIST_A2017.ZIP",
		};

		final TreeMap<Date, LinkedList<SerieHistorica>> pregoes = new TreeMap<Date, LinkedList<SerieHistorica>>();
		final ArrayList<String> tickers = new ArrayList<String>(700);
		SerieHistoricaParser serieHistorica = new SerieHistoricaParser();
		SerieHistoricaVisitor visitor = new SerieHistoricaVisitor() {

			private final BovespaDb<SerieHistorica> DB = BovespaDb.getInstance(SerieHistorica.class);

			public void visitTrailer(SerieHistoricaTrailer trailer) {
				// do nothing
			}

			public void visitItem(SerieHistorica item) {

				DB.insert(item);

				// Mercado de ações à vista
				if (item.tipo_mercado_id == 10 && item.bdi_id == 2) {

					if (!tickers.contains(item.ticker))
						tickers.add(item.ticker);

					LinkedList<SerieHistorica> pregao = pregoes.get(item.data_pregao);
					if (pregao == null) {
						pregao = new LinkedList<SerieHistorica>();
						pregoes.put(item.data_pregao, pregao);
					}
					pregao.add(item);
				}

			}

			public void visitHeader(SerieHistoricaHeader header) {
				// do nothing;
			}

		};

		for (int i = 0; i < fileNames.length; i++) {
			serieHistorica.acceptZip(fileNames[i], visitor);
			BovespaDb
					.getPostgresDb()
					.createCommand()
					.appendRaw("SELECT tmp_cotahist_sync();")
					.execute();
		}

		for (Date dt : pregoes.keySet())
			System.out.println(dt);

		int n = tickers.size();
		double[][] markov = new double[n][n];

		for (LinkedList<SerieHistorica> serie : pregoes.values()) {
			for (SerieHistorica item : serie) {
				int ordinal = tickers.indexOf(item.ticker);
				if (markov[ordinal][ordinal] == 0)
					markov[ordinal][ordinal] = item.preco_medio;
				else {

				}
			}
		}

	}

}
