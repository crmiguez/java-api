package com.eixox.usecases.bmf.bdi;

import java.util.List;

import com.eixox.models.bmf.Bdi;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

public class All extends UsecaseImplementation<Void, List<Bdi>> {

	@Override
	protected void mainFlow(UsecaseExecution<Void, List<Bdi>> execution) throws Exception {
		execution.result = Bdi.all();
		execution.result_type = UsecaseResultType.SUCCESS;
	}

}
