package com.eixox.bmf.carteira;

import java.util.LinkedHashMap;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import com.eixox.models.bmf.Carteira;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseResultType;
import com.eixox.usecases.bmf.carteira.Create;
import com.eixox.usecases.bmf.carteira.Create.Request;

public class SymTests {

	
	@Test
	public void testCarteira01() {

		UsecaseExecution<Request, Carteira> execution = UsecaseExecution.create(Create.class);
		execution.headers = new LinkedHashMap<String, Object>();
		execution.headers.put("authorization", UUID.fromString("16d412a4-0375-4607-bc4d-b8cc4fc089c0"));
		execution.params = new Request();
		execution.params.mercado_id = 10;
		execution.run();

		Assert.assertTrue(execution.result_type == UsecaseResultType.SUCCESS);
	}
}
