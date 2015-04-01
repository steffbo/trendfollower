package de.steffbo.twitter.trends.database;

import java.net.MalformedURLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;

import de.steffbo.twitter.trends.misc.TrendProperties;

public class TrendDb {

    private static Logger logger = LogManager.getLogger();

    private CouchDbConnector db;

    private static class LazyHolder {
	private static final TrendDb INSTANCE = new TrendDb();
    }

    public static TrendDb getInstance() {
	return LazyHolder.INSTANCE;
    }

    private TrendDb() {
	Properties props = TrendProperties.getInstance().getProperties();	
	try {
	    HttpClient httpClient = new StdHttpClient.Builder().url(props.getProperty("db.connection")).build();
	    CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
	    db = new StdCouchDbConnector(props.getProperty("db.name"), dbInstance);
	    db.createDatabaseIfNotExists();
	} catch (MalformedURLException e) {
	    logger.error(e.getMessage());
	}
    }

    public CouchDbConnector getDb() {
	return db;
    }

}
