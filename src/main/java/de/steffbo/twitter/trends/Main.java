package de.steffbo.twitter.trends;

import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.TwitterException;

public class Main {

    public static void main(String[] args) throws TwitterException {

	TrendFollower trendFollower = new TrendFollower();

	Trends trends = trendFollower.getTrends();
	for (Trend t : trends.getTrends()) {
	    System.out.println(t);
	}
    }

}
