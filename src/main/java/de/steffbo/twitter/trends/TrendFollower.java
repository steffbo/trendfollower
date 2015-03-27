package de.steffbo.twitter.trends;

import java.io.InputStream;
import java.util.Properties;

import twitter4j.Location;
import twitter4j.ResponseList;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TrendFollower {

    private Properties properties;

    private Twitter twitter;

    protected String getProperty(String key) {

	String propFileName = "config.properties";

	if (properties == null) {
	    try {
		properties = new Properties();
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		properties.load(inputStream);
	    } catch (Exception e) {
		throw new RuntimeException(e);
	    }
	}
	
	return properties.getProperty(key);
    }

    public TrendFollower() throws TwitterException {

	ConfigurationBuilder cb = new ConfigurationBuilder();
	cb.setDebugEnabled(true).setOAuthConsumerKey(getProperty("consumerKey")).setOAuthConsumerSecret(getProperty("consumerSecret"))
		.setOAuthAccessToken(getProperty("token")).setOAuthAccessTokenSecret(getProperty("tokenSecret"));
	
	TwitterFactory tf = new TwitterFactory(cb.build());
	twitter = tf.getInstance();	
    }

    public Trends getTrends() throws TwitterException {
	return twitter.getPlaceTrends(Woeid.BERLIN);
    }
    
    public ResponseList<Location> getLocations() throws TwitterException {
	return twitter.getAvailableTrends();
    }
}
