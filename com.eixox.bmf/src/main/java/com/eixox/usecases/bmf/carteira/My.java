package com.eixox.usecases.bmf.carteira;

import java.util.List;

import com.eixox.models.bmf.Carteira;
import com.eixox.usecases.ProfilerUsecase;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseResultType;

public class My extends ProfilerUsecase<Void, List<Carteira>> {

	@Override
	protected void mainFlow(UsecaseExecution<Void, List<Carteira>> execution) throws Exception {
		execution.result = Carteira.DB.select().where("person_id", token.person_id).toList();
		execution.result_type = UsecaseResultType.SUCCESS;
	}

}
