package com.eixox.usecases.bmf.pregao;

import java.sql.Date;
import java.util.List;

import com.eixox.data.DataSelect;
import com.eixox.data.FilterComparison;
import com.eixox.models.bmf.BovespaDb;
import com.eixox.models.bmf.Pregao;
import com.eixox.restrictions.Required;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

public class ByDate extends UsecaseImplementation<ByDate.Parameters, List<Pregao>> {

	public static class Parameters {
		@Required
		public int mercado_id;
		@Required
		public Date data;
		public String ticker;
	}

	@Override
	protected void mainFlow(UsecaseExecution<Parameters, List<Pregao>> execution) throws Exception {
		DataSelect<Pregao> select = BovespaDb.getInstance(Pregao.class).select();

		select
				.where("mercado_id", execution.params.mercado_id)
				.andWhere("data_pregao", execution.params.data);

		if (execution.params.ticker != null && !execution.params.ticker.isEmpty())
			select.andWhere("ticker", FilterComparison.LIKE, execution.params.ticker + "%");

		select.orderBy("ticker");

		execution.result = select.toList();
		execution.result_type = UsecaseResultType.SUCCESS;

	}

}
