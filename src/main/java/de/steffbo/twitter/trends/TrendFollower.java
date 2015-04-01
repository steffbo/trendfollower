package de.steffbo.twitter.trends;

import java.util.Properties;

import twitter4j.Location;
import twitter4j.ResponseList;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import de.steffbo.twitter.trends.misc.TrendProperties;

public class TrendFollower {

    private Twitter twitter;

    public TrendFollower() throws TwitterException {

	Properties props = TrendProperties.getInstance().getProperties();
	
	ConfigurationBuilder cb = new ConfigurationBuilder();
	cb.setDebugEnabled(true).setOAuthConsumerKey(props.getProperty("consumerKey")).setOAuthConsumerSecret(props.getProperty("consumerSecret"))
		.setOAuthAccessToken(props.getProperty("token")).setOAuthAccessTokenSecret(props.getProperty("tokenSecret"));

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
