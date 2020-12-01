/**
 * 
 */
package com.sandeep.lms.admin.mongo.factory;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

/**
 * @author sandeep.a.kumar
 *
 */

public class MongoFactory {

	private static Integer MONGO_PORT_NO = 27017;
	private static String MONGO_HOST_NAME = "localhost";
	private static String MONGO_DATABASE = "lmsDB";

	public MongoFactory() {
		// TODO Auto-generated constructor stub
	}

	static MongoClient mongoClient = new MongoClient(MONGO_HOST_NAME, MONGO_PORT_NO);

	static DB database = mongoClient.getDB(MONGO_DATABASE);

	// Fetches the collection from the mongo database.
	public static DBCollection getDBCollection(String collection_name) {
		return database.getCollection(collection_name);
	}

}
