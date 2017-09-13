package com.eixox.usecases.bmf.pregao;

import java.util.List;

import com.eixox.data.DataSelect;
import com.eixox.models.bmf.BovespaDb;
import com.eixox.models.bmf.Pregao;
import com.eixox.restrictions.Required;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

public class All extends UsecaseImplementation<All.Parameters, List<Pregao>> {

	public static class Parameters {
		@Required
		public int mercado_id;

		@Required
		public String ticker;

		public int page_size;

		public int page;
	}

	@Override
	protected void mainFlow(UsecaseExecution<Parameters, List<Pregao>> execution) throws Exception {
		DataSelect<Pregao> select = BovespaDb.getInstance(Pregao.class).select();

		select.where("ticker", execution.params.ticker).andWhere("mercado_id", execution.params.mercado_id);

		if (execution.params.page_size == 0)
			execution.params.page_size = 21;

		select.page(execution.params.page_size, execution.params.page);

		execution.result = select.toList();
		execution.result_type = UsecaseResultType.SUCCESS;

	}

}
