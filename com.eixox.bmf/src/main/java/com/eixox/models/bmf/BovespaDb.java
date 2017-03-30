package com.eixox.models.bmf;

import java.util.HashMap;
import java.util.Properties;

import com.eixox.data.sql.Database;
import com.eixox.data.sql.DatabaseStorage;
import com.eixox.data.sql.Postgres;

public class BovespaDb<T> extends DatabaseStorage<T> {

	private BovespaDb(Database database, Class<T> claz) {
		super(claz, database);
	}

	private static final HashMap<Class<?>, BovespaDb<?>> INSTANCES = new HashMap<Class<?>, BovespaDb<?>>();

	@SuppressWarnings("unchecked")
	public static synchronized final <T> BovespaDb<T> getInstance(Class<T> claz) {
		BovespaDb<T> db = (BovespaDb<T>) INSTANCES.get(claz);
		if (db == null) {
			db = new BovespaDb<T>(getPostgresDb(), claz);
			INSTANCES.put(claz, db);
		}
		return db;
	}

	public static Database getPostgresDb() {
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "red#1289");
		return new Postgres("jdbc:postgresql://localhost/bovespa", props);
	}
}
