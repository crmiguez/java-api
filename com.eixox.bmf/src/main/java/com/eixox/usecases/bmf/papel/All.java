package com.eixox.usecases.bmf.papel;

import java.util.List;

import com.eixox.data.DataSelect;
import com.eixox.models.bmf.Papel;
import com.eixox.usecases.Unregistered;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

@Unregistered
public class All extends UsecaseImplementation<List<Papel>> {

	@Override
	protected boolean acceptMethod(String method) {
		return "get".equalsIgnoreCase(method) || super.acceptMethod(method);
	}

	@Override
	protected void log(UsecaseExecution<List<Papel>> execution) {
		// don't log
	}

	@Override
	protected boolean authenticate(UsecaseExecution<List<Papel>> execution) {
		// don't authenticate;
		return true;
	}

	@Override
	protected void executeFlow(UsecaseExecution<List<Papel>> execution) throws Exception {
		DataSelect<Papel> select = Papel.DB.select().setLimit(100);
		execution.result = select.toList();
		execution.resultType = UsecaseResultType.SUCCESS;
	}

}
