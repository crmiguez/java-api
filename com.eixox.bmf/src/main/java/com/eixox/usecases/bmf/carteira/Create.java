package com.eixox.usecases.bmf.carteira;

import java.util.Date;

import com.eixox.models.bmf.Carteira;
import com.eixox.restrictions.Required;
import com.eixox.usecases.ProfilerUsecase;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseResultType;

public class Create extends ProfilerUsecase<Create.Request, Carteira> {

	public static class Request {

		@Required
		public int mercado_id;
	}

	@Override
	protected void mainFlow(UsecaseExecution<Request, Carteira> execution) throws Exception {
		Carteira c = Carteira.DB
				.select()
				.where("mercado_id", execution.params.mercado_id)
				.andWhere("person_id", token.person_id)
				.first();

		if (c == null) {
			c = new Carteira();
			c.created_at = new Date();
			c.updated_at = new Date();
			c.person_id = token.person_id;
			c.mercado_id = execution.params.mercado_id;
			Carteira.DB.insert(c);
		}

		execution.result = c;
		execution.result_type = UsecaseResultType.SUCCESS;

	}

}
