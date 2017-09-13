package com.eixox.usecases.bmf.mercado;

import java.util.List;

import com.eixox.models.bmf.Mercado;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

public class All extends UsecaseImplementation<Void, List<Mercado>> {

	@Override
	protected void mainFlow(UsecaseExecution<Void, List<Mercado>> execution) throws Exception {
		execution.result = Mercado.all();
		execution.result_type = UsecaseResultType.SUCCESS;

	}

}
