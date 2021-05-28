/**
 * 
 */
package com.sandeep.lms.ems.factory;

import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * @author sandeep.a.kumar
 *
 */

public class MongoFactory {

	private static Mongo mongo;
	
	private static Integer MONGO_PORT_NO = 27017;
	private static String MONGO_HOST_NAME = "localhost";
//	private static String MONGO_HOST_NAME = "mongohost";	
	private static String MONGO_DATABASE = "lmsDB";
	
	public MongoFactory() {
		// TODO Auto-generated constructor stub
	}
	
	// Returns a Mongo Instance
	public static Mongo getMongo() {
		if(mongo == null) {
			try {
				mongo = new Mongo(MONGO_HOST_NAME, MONGO_PORT_NO);
			}
			catch (MongoException e) {
				
			}
		}
		return mongo;
	}
	
	// Fetches the collection from the mongo database.
	public static DBCollection getDBCollection(String collection_name) {
		return getMongo().getDB(MONGO_DATABASE).getCollection(collection_name);
	}
	
}
