package com.eixox.usecases.bmf.carteira;

import java.util.List;

import com.eixox.models.bmf.Carteira;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

public class My extends UsecaseImplementation<List<Carteira>> {

	@Override
	protected void executeFlow(UsecaseExecution<List<Carteira>> execution) throws Exception {

		execution.result = Carteira.DB.select().where("person_id", execution.access_token.person_id).toList();
		execution.resultType = UsecaseResultType.SUCCESS;

	}

}
