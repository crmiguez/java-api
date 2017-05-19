package com.eixox.usecases.cvm.ciaaberta;

import java.util.List;

import com.eixox.Control;
import com.eixox.data.DataSelect;
import com.eixox.models.bmf.CiaAberta;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

public class All extends UsecaseImplementation<List<CiaAberta>> {

	@Control
	public int page;

	@Control
	public int page_size;

	@Override
	protected void executeFlow(UsecaseExecution<List<CiaAberta>> execution) throws Exception {

		DataSelect<CiaAberta> select = CiaAberta.DB.select();

		if (page_size == 0)
			page_size = 100;

		select.page(page_size, page);

		execution.result = select.toList();
		execution.resultType = UsecaseResultType.SUCCESS;

	}

}
