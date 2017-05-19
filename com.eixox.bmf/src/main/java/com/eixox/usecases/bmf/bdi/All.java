package com.eixox.usecases.bmf.bdi;

import java.util.List;

import com.eixox.models.bmf.Bdi;
import com.eixox.usecases.Unregistered;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

@Unregistered
public class All extends UsecaseImplementation<List<Bdi>> {

	@Override
	protected boolean acceptMethod(String method) {
		return "get".equalsIgnoreCase(method) || super.acceptMethod(method);
	}

	@Override
	protected void log(UsecaseExecution<List<Bdi>> execution) {
		// don't log
	}

	@Override
	protected boolean authenticate(UsecaseExecution<List<Bdi>> execution) {
		// don't authenticate;
		return true;
	}

	@Override
	protected void executeFlow(UsecaseExecution<List<Bdi>> execution) throws Exception {
		execution.result = Bdi.all();
		execution.resultType = UsecaseResultType.SUCCESS;
	}

}
