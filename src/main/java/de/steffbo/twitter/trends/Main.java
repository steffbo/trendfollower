package de.steffbo.twitter.trends;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import twitter4j.Trends;
import twitter4j.TwitterException;
import de.steffbo.twitter.trends.database.TrendDb;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws TwitterException {

	TrendFollower trendFollower = new TrendFollower();
	Trends trends = trendFollower.getTrends();
	TrendSnapshot snapshot = new TrendSnapshot(trends, new Date(), Woeid.BERLIN);
	TrendDb.getInstance().getDb().create(snapshot);
    }

}
