package de.steffbo.twitter.trends;

import java.util.ArrayList;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.TwitterException;
import de.steffbo.twitter.trends.database.TrendDb;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    private static TrendFollower trendFollower;

    public static void main(String[] args) throws TwitterException {

	trendFollower = new TrendFollower();
//	createSnapshot();
	 getSnapshotFromDb();
    }

    private static void createSnapshot() throws TwitterException {
	Trends trends = trendFollower.getTrends();

	ArrayList<String> trendList = new ArrayList<String>();
	for (Trend trend : trends.getTrends()) {
	    trendList.add(trend.getName());
	}

	TrendSnapshot snapshot = new TrendSnapshot(trendList, new Date(), Woeid.BERLIN);
	TrendDb.getInstance().getDb().create(snapshot);
    }

    private static void getSnapshotFromDb() {
	TrendSnapshot snapshot = TrendDb.getInstance().getLatestSnapshot();
	System.out.println(snapshot);
    }

}
