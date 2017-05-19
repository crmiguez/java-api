package com.eixox.usecases.bmf.papel;

import com.eixox.Control;
import com.eixox.models.bmf.Papel;
import com.eixox.restrictions.Required;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

public class Detail extends UsecaseImplementation<Papel> {

	@Control
	@Required
	public int mercado_id;

	@Control
	@Required
	public String ticker;

	@Override
	protected boolean authenticate(UsecaseExecution<Papel> execution) {
		return true;
	}

	@Override
	protected void executeFlow(UsecaseExecution<Papel> execution) throws Exception {
		execution.result = Papel.DB
				.select()
				.where("mercado_id", mercado_id)
				.andWhere("ticker", ticker)
				.first();
		execution.resultType = UsecaseResultType.SUCCESS;
	}

}
