package com.eixox.usecases.cvm.ciaaberta;

import java.util.List;

import com.eixox.data.DataSelect;
import com.eixox.models.bmf.CiaAberta;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

public class All extends UsecaseImplementation<All.Parameters, List<CiaAberta>> {

	public static class Parameters {
		public int page;

		public int page_size;
	}

	@Override
	protected void mainFlow(UsecaseExecution<Parameters, List<CiaAberta>> execution) throws Exception {
		DataSelect<CiaAberta> select = CiaAberta.DB.select();

		if (execution.params.page_size == 0)
			execution.params.page_size = 100;

		select.page(execution.params.page_size, execution.params.page);

		execution.result = select.toList();
		execution.result_type = UsecaseResultType.SUCCESS;

	}

}
