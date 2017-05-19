package com.eixox.usecases.bmf.pregao;

import java.util.Date;

import javax.servlet.http.Part;

import com.eixox.Control;
import com.eixox.models.bmf.BovespaDb;
import com.eixox.models.bmf.Pregao;
import com.eixox.models.bmf.fixedlength.SerieHistoricaHeader;
import com.eixox.models.bmf.fixedlength.SerieHistoricaParser;
import com.eixox.models.bmf.fixedlength.SerieHistoricaTrailer;
import com.eixox.models.bmf.fixedlength.SerieHistoricaVisitor;
import com.eixox.restrictions.Required;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Import extends UsecaseImplementation<Import> implements SerieHistoricaVisitor {

	@Override
	protected boolean authenticate(UsecaseExecution<Import> execution) {
		return true;
	}

	public Date start_time = null;
	public String fileName = null;
	public Date end_time = null;
	public int record_count;

	@Control
	@Required
	@JsonIgnore
	public Part uploaded_file;

	@Override
	protected void executeFlow(UsecaseExecution<Import> execution) throws Exception {

		String name = uploaded_file.getSubmittedFileName();
		if (name.endsWith("zip") || name.endsWith("ZIP") || name.endsWith("ZiP") || name.endsWith("Zip"))
			new SerieHistoricaParser().acceptZip(uploaded_file.getInputStream(), this);
		else
			new SerieHistoricaParser().accept(uploaded_file.getInputStream(), this);

		execution.result = this;
		execution.resultType = UsecaseResultType.SUCCESS;
		execution.get("uploaded_file").value = null;
	}

	@JsonIgnore
	private final BovespaDb<Pregao> DB = BovespaDb.getInstance(Pregao.class);

	public void visitTrailer(SerieHistoricaTrailer trailer) {
		/*
		 * BovespaDb .getPostgresDb() .createCommand()
		 * .appendRaw("SELECT tmp_cotahist_sync();") .execute();
		 */
		this.record_count = trailer.total_registros;
		this.end_time = new Date();

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
		this.start_time = new Date();
		this.fileName = header.nome_arquivo;
	}

}
