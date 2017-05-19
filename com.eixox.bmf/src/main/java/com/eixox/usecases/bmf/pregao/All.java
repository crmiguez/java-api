package com.eixox.usecases.bmf.pregao;

import java.util.List;

import com.eixox.Control;
import com.eixox.data.DataSelect;
import com.eixox.models.bmf.BovespaDb;
import com.eixox.models.bmf.Pregao;
import com.eixox.restrictions.Required;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

public class All extends UsecaseImplementation<List<Pregao>> {

	@Override
	protected boolean authenticate(UsecaseExecution<List<Pregao>> execution) {
		return true;
	}

	@Control
	@Required
	public int mercado_id;

	@Control
	@Required
	public String ticker;

	@Control
	public int page_size;

	@Control
	public int page;

	@Override
	protected void executeFlow(UsecaseExecution<List<Pregao>> execution) throws Exception {

		DataSelect<Pregao> select = BovespaDb.getInstance(Pregao.class).select();

		select.where("ticker", ticker).andWhere("mercado_id", mercado_id);

		if (page_size == 0)
			page_size = 21;

		select.page(page_size, page);

		execution.result = select.toList();
		execution.resultType = UsecaseResultType.SUCCESS;

	}

}
