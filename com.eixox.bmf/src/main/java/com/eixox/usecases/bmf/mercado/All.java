package com.eixox.usecases.bmf.mercado;

import java.util.List;

import com.eixox.models.bmf.Mercado;
import com.eixox.usecases.Unregistered;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

@Unregistered
public class All extends UsecaseImplementation<List<Mercado>> {

	@Override
	protected boolean acceptMethod(String method) {
		return "get".equalsIgnoreCase(method) || super.acceptMethod(method);
	}

	@Override
	protected void log(UsecaseExecution<List<Mercado>> execution) {
		// don't log
	}

	@Override
	protected boolean authenticate(UsecaseExecution<List<Mercado>> execution) {
		// don't authenticate;
		return true;
	}

	@Override
	protected void executeFlow(UsecaseExecution<List<Mercado>> execution) throws Exception {
		execution.result = Mercado.DB.select().toList();
		execution.resultType = UsecaseResultType.SUCCESS;
	}

}
