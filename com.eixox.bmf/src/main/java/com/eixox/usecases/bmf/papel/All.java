package com.eixox.usecases.bmf.papel;

import java.util.List;

import com.eixox.data.DataSelect;
import com.eixox.data.FilterComparison;
import com.eixox.models.bmf.Papel;
import com.eixox.restrictions.Required;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

public class All extends UsecaseImplementation<All.Parameters, List<Papel>> {

	public static class Parameters {
		public int page_size;
		public int page;
		public String filter;
		@Required
		public int mercado_id;
	}

	@Override
	protected void mainFlow(UsecaseExecution<Parameters, List<Papel>> execution) throws Exception {
		if (execution.params.page_size == 0)
			execution.params.page_size = 24;

		DataSelect<Papel> select = Papel.DB
				.select()
				.where("mercado_id", execution.params.mercado_id)
				.page(execution.params.page_size, execution.params.page);

		if (execution.params.filter != null && !execution.params.filter.isEmpty())
			select.andWhere("ticker", FilterComparison.LIKE, execution.params.filter + "%");

		execution.result = select.toList();
		execution.result_type = UsecaseResultType.SUCCESS;

	}

}
