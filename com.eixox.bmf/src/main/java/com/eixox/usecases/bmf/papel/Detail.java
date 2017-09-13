package com.eixox.usecases.bmf.papel;

import com.eixox.models.bmf.Papel;
import com.eixox.restrictions.Required;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

public class Detail extends UsecaseImplementation<Detail.Parameters, Papel> {

	public static class Parameters {
		@Required
		public int mercado_id;

		@Required
		public String ticker;
	}

	@Override
	protected void mainFlow(UsecaseExecution<Parameters, Papel> execution) throws Exception {
		execution.result = Papel.DB
				.select()
				.where("mercado_id", execution.params.mercado_id)
				.andWhere("ticker", execution.params.ticker)
				.first();
		execution.result_type = UsecaseResultType.SUCCESS;

	}

}
