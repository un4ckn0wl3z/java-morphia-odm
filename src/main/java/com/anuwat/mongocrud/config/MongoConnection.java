package com.anuwat.mongocrud.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import dev.morphia.Datastore;
import dev.morphia.Morphia;

public class MongoConnection {

	private static final String PACKAGE_BEANS_TARGET = "com.anuwat.mongocrud.beans";
	private static final String DB_BEANS_TARGET = "MorphiaCrud";
	private static final String MONGO_URL_TARGET = "mongodb://localhost:27017";

	public static Datastore getConnection() {
		final Morphia morphia = new Morphia();
		morphia.mapPackage(PACKAGE_BEANS_TARGET);
		final Datastore datastore = morphia.createDatastore(new MongoClient(new MongoClientURI(MONGO_URL_TARGET)),
				DB_BEANS_TARGET);
		datastore.ensureIndexes();
		
		return datastore;
	}
}
