package com.eixox.usecases.bmf.carteira;

import java.util.Date;

import com.eixox.Control;
import com.eixox.models.bmf.Carteira;
import com.eixox.restrictions.Required;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

public class Create extends UsecaseImplementation<Carteira> {

	@Control
	@Required
	public int mercado_id;

	@Override
	protected void executeFlow(UsecaseExecution<Carteira> execution) throws Exception {

		Carteira c = Carteira.DB
				.select()
				.where("mercado_id", mercado_id)
				.andWhere("person_id", execution.access_token.person_id)
				.first();

		if (c == null) {
			c = new Carteira();
			c.created_at = new Date();
			c.updated_at = new Date();
			c.person_id = execution.access_token.person_id;
			c.mercado_id = mercado_id;
			Carteira.DB.insert(c);
		}

		execution.result = c;
		execution.resultType = UsecaseResultType.SUCCESS;
	}

}
