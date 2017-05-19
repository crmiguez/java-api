package com.eixox.usecases.bmf.papel;

import java.util.List;

import com.eixox.Control;
import com.eixox.data.DataSelect;
import com.eixox.data.FilterComparison;
import com.eixox.models.bmf.Papel;
import com.eixox.restrictions.Required;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

public class All extends UsecaseImplementation<List<Papel>> {

	@Control
	public int page_size;

	@Control
	public int page;

	@Control
	public String filter;

	@Control
	@Required
	public int mercado_id;

	@Override
	protected boolean authenticate(UsecaseExecution<List<Papel>> execution) {
		return true;
	}

	@Override
	protected void executeFlow(UsecaseExecution<List<Papel>> execution) throws Exception {

		if (page_size == 0)
			page_size = 24;

		DataSelect<Papel> select = Papel.DB
				.select()
				.where("mercado_id", mercado_id)
				.page(page_size, page);

		if (filter != null && !filter.isEmpty())
			select.andWhere("ticker", FilterComparison.LIKE, filter + "%");

		execution.result = select.toList();
		execution.resultType = UsecaseResultType.SUCCESS;
	}

}
