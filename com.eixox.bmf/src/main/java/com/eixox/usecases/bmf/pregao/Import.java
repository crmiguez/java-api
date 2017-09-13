package com.eixox.usecases.bmf.pregao;

import java.util.Date;

import com.eixox.models.bmf.BovespaDb;
import com.eixox.models.bmf.Pregao;
import com.eixox.models.bmf.fixedlength.SerieHistoricaHeader;
import com.eixox.models.bmf.fixedlength.SerieHistoricaParser;
import com.eixox.models.bmf.fixedlength.SerieHistoricaTrailer;
import com.eixox.models.bmf.fixedlength.SerieHistoricaVisitor;
import com.eixox.restrictions.Required;
import com.eixox.usecases.FileSource;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Import extends UsecaseImplementation<Import.Parameters, Import.Result> implements SerieHistoricaVisitor {

	public static class Result {
		public Date start_time = null;
		public String fileName = null;
		public Date end_time = null;
		public int record_count;
	}

	public static class Parameters {
		@Required
		@JsonIgnore
		public FileSource uploaded_file;
	}

	private Result result;

	@JsonIgnore
	private final BovespaDb<Pregao> DB = BovespaDb.getInstance(Pregao.class);

	public void visitTrailer(SerieHistoricaTrailer trailer) {
		/*
		 * BovespaDb .getPostgresDb() .createCommand()
		 * .appendRaw("SELECT tmp_cotahist_sync();") .execute();
		 */
		this.result.record_count = trailer.total_registros;
		this.result.end_time = new Date();

	}

	public void visitItem(Pregao item) {
		if (!DB
				.select()
				.where("mercado_id", item.mercado_id)
				.andWhere("ticker", item.ticker)
				.andWhere("prazo_dias", item.prazo_dias)
				.andWhere("data_pregao", item.data_pregao)
				.exists())
			DB.insert(item);
	}

	public void visitHeader(SerieHistoricaHeader header) {
		this.result.start_time = new Date();
		this.result.fileName = header.nome_arquivo;
	}

	@Override
	protected void mainFlow(UsecaseExecution<Parameters, Result> execution) throws Exception {

		this.result = new Result();
		String name = execution.params.uploaded_file.getName();
		if (name.endsWith("zip") || name.endsWith("ZIP") || name.endsWith("ZiP") || name.endsWith("Zip"))
			new SerieHistoricaParser().acceptZip(execution.params.uploaded_file.getInputStream(), this);
		else
			new SerieHistoricaParser().accept(execution.params.uploaded_file.getInputStream(), this);

		execution.result = this.result;
		execution.result_type = UsecaseResultType.SUCCESS;
	}

}
