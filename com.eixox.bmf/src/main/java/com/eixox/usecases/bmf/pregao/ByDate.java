package com.eixox.usecases.bmf.pregao;

import java.sql.Date;
import java.util.List;

import com.eixox.Control;
import com.eixox.data.DataSelect;
import com.eixox.data.FilterComparison;
import com.eixox.models.bmf.BovespaDb;
import com.eixox.models.bmf.Pregao;
import com.eixox.restrictions.Required;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

public class ByDate extends UsecaseImplementation<List<Pregao>> {

	@Override
	protected boolean authenticate(UsecaseExecution<List<Pregao>> execution) {
		return true;
	}

	@Control
	@Required
	public int mercado_id;

	@Control
	@Required
	public Date data;

	@Control
	public String ticker;

	@Override
	protected void executeFlow(UsecaseExecution<List<Pregao>> execution) throws Exception {
		DataSelect<Pregao> select = BovespaDb.getInstance(Pregao.class).select();

		select
				.where("mercado_id", mercado_id)
				.andWhere("data_pregao", data);

		if (ticker != null && !ticker.isEmpty())
			select.andWhere("ticker", FilterComparison.LIKE, ticker + "%");

		select.orderBy("ticker");
		
		execution.result = select.toList();
		execution.resultType = UsecaseResultType.SUCCESS;
	}

}
