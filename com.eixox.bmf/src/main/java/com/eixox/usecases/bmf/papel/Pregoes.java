package com.eixox.usecases.bmf.papel;

import java.util.List;

import com.eixox.Control;
import com.eixox.models.bmf.PapelPregaoWithAnterior;
import com.eixox.restrictions.Required;
import com.eixox.usecases.Unregistered;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

@Unregistered
public class Pregoes extends UsecaseImplementation<List<PapelPregaoWithAnterior>> {

	@Control
	@Required
	public int papel_id;

	@Override
	protected boolean acceptMethod(String method) {
		return "get".equalsIgnoreCase(method) || super.acceptMethod(method);
	}

	@Override
	protected void log(UsecaseExecution<List<PapelPregaoWithAnterior>> execution) {
		// don't log
	}

	@Override
	protected boolean authenticate(UsecaseExecution<List<PapelPregaoWithAnterior>> execution) {
		// don't authenticate;
		return true;
	}

	@Override
	protected void executeFlow(UsecaseExecution<List<PapelPregaoWithAnterior>> execution) throws Exception {
		execution.result = PapelPregaoWithAnterior.DB
				.select()
				.where("papel_id", this.papel_id)
				.orderBy("pregao_id")
				.toList();
		execution.resultType = UsecaseResultType.SUCCESS;
	}

}
